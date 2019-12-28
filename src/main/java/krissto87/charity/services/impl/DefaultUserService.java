package krissto87.charity.services.impl;

import krissto87.charity.domain.entities.User;
import krissto87.charity.domain.repository.UserRepository;
import krissto87.charity.dtos.UserDTO;
import krissto87.charity.services.UserService;
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
    public UserDTO findUserByName(String username) {
        User user = userRepository.findUserByEmail(username);
        log.debug("User data to edit: {}", user);
        return mapper.map(user, UserDTO.class);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        String newName = userDTO.getName();
        String newSurname = userDTO.getSurname();
        Long id = userDTO.getId();
        log.debug("User name: {}", newName);
        log.debug("User surname: {}", newSurname);
        log.debug("User id: {}", id);
        userRepository.updateUser(newName, newSurname, id);
    }

    @Override
    public void changeUserPassword(String username, String password) {
        log.debug("New password pre encoding: {}", password);
        String encodedPassword = encoder.encode(password);
        userRepository.changeUserPasswordByUsername(username, encodedPassword);
    }
}
