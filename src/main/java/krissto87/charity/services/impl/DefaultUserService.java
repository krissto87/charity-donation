package krissto87.charity.services.impl;

import krissto87.charity.domain.entities.User;
import krissto87.charity.domain.repository.UserRepository;
import krissto87.charity.dtos.UserDTO;
import krissto87.charity.dtos.UserProfileDTO;
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
    public UserProfileDTO findUserByName(String username) {
        User user = userRepository.findUserByEmail(username);
        log.debug("User data to edit: {}", user);
        return mapper.map(user, UserProfileDTO.class);
    }

    @Override
    public void updateUser(UserDTO user) {
        String newName = user.getName();
        String newSurname = user.getSurname();
        String email = user.getEmail();
        Long id = user.getId();
        log.debug("User name: {}", newName);
        log.debug("User surname: {}", newSurname);
        log.debug("User id: {}", id);
        log.debug("User email: {}", email);
        userRepository.updateUser(newName, newSurname, email, id);
    }

    @Override
    public void changeUserPassword(String username, String password) {
        log.debug("New password pre encoding: {}", password);
        String encodedPassword = encoder.encode(password);
        userRepository.changeUserPasswordByUsername(username, encodedPassword);
    }
}
