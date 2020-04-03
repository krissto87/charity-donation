package krissto87.charity.services.impl;

import krissto87.charity.domain.entities.User;
import krissto87.charity.domain.entities.VerificationToken;
import krissto87.charity.domain.repository.UserRepository;
import krissto87.charity.domain.repository.VerificationTokenRepository;
import krissto87.charity.dtos.ChangePasswordDto;
import krissto87.charity.dtos.UserProfileDto;
import krissto87.charity.services.EmailService;
import krissto87.charity.services.UserService;
import krissto87.charity.utils.GeneralUtils;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder encoder;
    private final EmailService emailService;
    private final VerificationTokenRepository tokenRepository;

    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper,
                           PasswordEncoder encoder, EmailService emailService,
                           VerificationTokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.encoder = encoder;
        this.emailService = emailService;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public UserProfileDto findUser() {
        User user = userRepository.findUserByEmail(GeneralUtils.getUsername());
        return mapper.map(user, UserProfileDto.class);
    }

    @Override
    public void updateUser(UserProfileDto profile) {
        User user = userRepository.findUserByEmail(GeneralUtils.getUsername());
        log.debug("User from db: {}", user);
        user.setName(profile.getName());
        user.setSurname(profile.getSurname());
        user.setEmail(profile.getEmail());
        log.debug("User before save: {}", user);
        userRepository.save(user);
    }

    @Override
    public void changeUserPassword(ChangePasswordDto changePasswordDTO) {
        String username = GeneralUtils.getUsername();
        User user = userRepository.findUserByEmail(username);
        log.debug("User from db: {}", user);
        user.setPassword(encoder.encode(changePasswordDTO.getPassword()));
        log.debug("User before save: {}", user);
        userRepository.save(user);
    }

    @Override
    public Boolean sendEmailToResetPassword(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            VerificationToken verificationToken = new VerificationToken(user);
            emailService.sendSimpleMessage(email, "Charity donation app: Reset your password!",
                    "To reset your password, please click here (link valid 24 hours) : "
                            +"http://localhost:8080/reset-password?token="+verificationToken.getToken());
            verificationToken.getUser().setId(userRepository.findUserByEmail(user.getEmail()).getId());
            tokenRepository.save(verificationToken);
            log.debug("VerificationToken after save: {}", verificationToken);
            return true;
        }
        log.info("Email from user not found in database!");
        return false;
    }

    @Override
    public void changeUserPasswordAfterRemind(ChangePasswordDto changePassword, String tokenUrl) {
        VerificationToken token = tokenRepository.findByToken(tokenUrl);
        User user = userRepository.getOne(token.getUser().getId());
        user.setPassword(encoder.encode(changePassword.getPassword()));
        userRepository.save(user);
    }

}
