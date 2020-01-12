package krissto87.charity.services.impl;

import krissto87.charity.domain.entities.Role;
import krissto87.charity.domain.entities.User;
import krissto87.charity.domain.entities.VerificationToken;
import krissto87.charity.domain.repository.RoleRepository;
import krissto87.charity.domain.repository.UserRepository;
import krissto87.charity.domain.repository.VerificationTokenRepository;
import krissto87.charity.dtos.RegistrationDataDTO;
import krissto87.charity.services.EmailService;
import krissto87.charity.services.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Transactional
@Slf4j
@Validated
public class DefaultRegistrationService implements RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper mapper;
    private final EmailService emailService;
    private final VerificationTokenRepository tokenRepository;

    public DefaultRegistrationService(PasswordEncoder passwordEncoder, UserRepository userRepository,
                                      RoleRepository roleRepository, ModelMapper mapper,
                                      EmailService emailService, VerificationTokenRepository tokenRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.mapper = mapper;
        this.emailService = emailService;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public void register(@Valid RegistrationDataDTO registrationData) {
        log.debug("Registration data to create user: {}", registrationData);
        User user = mapper.map(registrationData, User.class);
        log.debug("User after mapping from registrationData: {}", user);
        user.setActive(Boolean.FALSE);
        String encodedPassword = passwordEncoder.encode(registrationData.getPassword());
        user.setPassword(encodedPassword);
        Role roleUser = roleRepository.getByName("ROLE_USER");
        user.getRoles().add(roleUser);
        VerificationToken verificationToken = new VerificationToken(user);
        emailService.sendSimpleMessage(user.getEmail(), "Charity donation app: Complete your Registration!",
                "To activate your account, please click here (link valid 24 hours) : "
                        +"http://localhost:8080/confirm-account?token="+verificationToken.getToken());
        log.debug("VerificationToken object: {}", verificationToken);
        log.debug("User before save: {}", user);
        userRepository.save(user);
        log.debug("User after save: {}", user);
        verificationToken.getUser().setId(userRepository.findUserByEmail(user.getEmail()).getId());
        tokenRepository.save(verificationToken);
    }
}
