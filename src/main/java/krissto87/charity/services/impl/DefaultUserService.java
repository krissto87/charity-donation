package krissto87.charity.services.impl;

import krissto87.charity.domain.entities.User;
import krissto87.charity.domain.repository.UserRepository;
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

    public DefaultUserService(UserRepository userRepository, ModelMapper mapper,
                              PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.encoder = encoder;
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
    public void makeUserActive(Long id) {
        User user = userRepository.getOne(id);
        user.setActive(Boolean.TRUE);
        userRepository.save(user);
        log.debug("User after token activation: {}", user);
    }
}
