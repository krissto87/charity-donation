package krissto87.charity.services.impl;

import krissto87.charity.domain.entities.Role;
import krissto87.charity.domain.entities.User;
import krissto87.charity.domain.repository.RoleRepository;
import krissto87.charity.domain.repository.UserRepository;
import krissto87.charity.dtos.AdminDTO;
import krissto87.charity.dtos.ChangePasswordDTO;
import krissto87.charity.dtos.UserProfileDTO;
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
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder encoder;
    private final RoleRepository roleRepository;

    public DefaultUserService(UserRepository userRepository, ModelMapper mapper,
                              PasswordEncoder encoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.encoder = encoder;
        this.roleRepository = roleRepository;
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
    public void save(AdminDTO admin) {
        log.debug("Admin from form: {}", admin);
        User user = new User();
        user.setName(admin.getName());
        user.setSurname(admin.getSurname());
        user.setEmail(admin.getEmail());
        user.setActive(Boolean.TRUE);
        user.setPassword(encoder.encode(admin.getPassword()));
        Role adminRole = roleRepository.getByName("ROLE_ADMIN");
        user.getRoles().add(adminRole);
        log.debug("Admin before save: {}", user);
        userRepository.save(user);
        log.info("Added new admin!");
    }
}
