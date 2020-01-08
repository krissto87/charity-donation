package krissto87.charity.services.impl;

import krissto87.charity.domain.entities.User;
import krissto87.charity.domain.entities.VerificationToken;
import krissto87.charity.domain.repository.UserRepository;
import krissto87.charity.domain.repository.VerificationTokenRepository;
import krissto87.charity.dtos.ChangePasswordDTO;
import krissto87.charity.dtos.UserProfileDTO;
import krissto87.charity.services.EmailService;
import krissto87.charity.services.UserService;
import krissto87.charity.utils.GeneralUtils;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Transactional
@Slf4j
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder encoder;
    private final EmailService emailService;
    private final VerificationTokenRepository tokenRepository;

    public DefaultUserService(UserRepository userRepository, ModelMapper mapper,
                              PasswordEncoder encoder, EmailService emailService,
                              VerificationTokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.encoder = encoder;
        this.emailService = emailService;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public UserProfileDTO findUser() {
        User user = userRepository.findUserByEmail(GeneralUtils.getUsername());
        return mapper.map(user, UserProfileDTO.class);
    }

    @Override
    public void updateUser(UserProfileDTO profile) {
        User user = userRepository.findUserByEmail(GeneralUtils.getUsername());
        log.debug("User from db: {}", user);
        user.setName(profile.getName());
        user.setSurname(profile.getSurname());
        user.setEmail(profile.getEmail());
        log.debug("User before save: {}", user);
        userRepository.save(user);
    }

    @Override
    public void changeUserPassword(ChangePasswordDTO changePasswordDTO) {
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

}
