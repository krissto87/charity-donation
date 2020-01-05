package krissto87.charity.services.impl;

import krissto87.charity.domain.entities.Role;
import krissto87.charity.domain.entities.User;
import krissto87.charity.domain.repository.RoleRepository;
import krissto87.charity.domain.repository.UserRepository;
import krissto87.charity.dtos.AdminDTO;
import krissto87.charity.dtos.EditAdminDTO;
import krissto87.charity.services.AdminService;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@Slf4j
public class DefaultAdminService implements AdminService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    public DefaultAdminService(UserRepository userRepository, ModelMapper mapper,
                               RoleRepository roleRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public List<AdminDTO> findAll() {
        Role adminRole = roleRepository.getByName("ROLE_ADMIN");
        List<User> admins = userRepository.findAllByRoles(adminRole);
        log.debug("Admins from db: {}", admins);
        return admins.stream().map(a -> mapper.map(a, AdminDTO.class)).collect(Collectors.toList());
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

    @Override
    public EditAdminDTO findUserById(Long id) {
        return mapper.map(userRepository.getOne(id), EditAdminDTO.class);
    }

    @Override
    public void update(EditAdminDTO adminDTO) {
        log.debug("Admin DTO: {}", adminDTO);
        User user = mapper.map(adminDTO, User.class);
        user.setActive(Boolean.TRUE);
        Role adminRole = roleRepository.getByName("ROLE_ADMIN");
        user.getRoles().add(adminRole);
        user.setPassword(encoder.encode(adminDTO.getPassword()));
        log.debug("Admin before save to user table: {}", user);
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
