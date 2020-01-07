package krissto87.charity.services.impl;

import krissto87.charity.domain.entities.Role;
import krissto87.charity.domain.entities.User;
import krissto87.charity.domain.repository.RoleRepository;
import krissto87.charity.domain.repository.UserRepository;
import krissto87.charity.dtos.RegistrationDataDTO;
import krissto87.charity.services.EmailService;
import krissto87.charity.services.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class DefaultRegistrationService implements RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper mapper;
    private final EmailService emailService;

    public DefaultRegistrationService(PasswordEncoder passwordEncoder, UserRepository userRepository,
                                      RoleRepository roleRepository, ModelMapper mapper, EmailService emailService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.mapper = mapper;
        this.emailService = emailService;
    }

    @Override
    public void register(RegistrationDataDTO registrationData) {
        log.debug("Registration data to create user: {}", registrationData);
        User user = mapper.map(registrationData, User.class);
        log.debug("User after mapping from registrationData: {}", user);
        user.setActive(Boolean.TRUE);
        String encodedPassword = passwordEncoder.encode(registrationData.getPassword());
        user.setPassword(encodedPassword);
        Role roleUser = roleRepository.getByName("ROLE_USER");
        user.getRoles().add(roleUser);
        emailService.sendSimpleMessage(user.getEmail(),
                "Registration confirm", "Click link below to confirm registration");
        log.debug("User before save: {}", user);
        userRepository.save(user);
        log.debug("User after save: {}", user);
    }
}
