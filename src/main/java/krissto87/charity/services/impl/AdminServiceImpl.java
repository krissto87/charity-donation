package krissto87.charity.services.impl;

import krissto87.charity.domain.entities.Role;
import krissto87.charity.domain.entities.User;
import krissto87.charity.domain.repository.RoleRepository;
import krissto87.charity.domain.repository.UserRepository;
import krissto87.charity.dtos.AdminDto;
import krissto87.charity.dtos.DeleteAdminDto;
import krissto87.charity.dtos.EditAdminDto;
import krissto87.charity.dtos.EditUserDto;
import krissto87.charity.services.AdminService;

import krissto87.charity.services.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@Slf4j
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final EmailService emailService;

    public AdminServiceImpl(UserRepository userRepository, ModelMapper mapper, RoleRepository
            roleRepository, PasswordEncoder encoder, EmailService emailService) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.emailService = emailService;
    }

    @Override
    public List<AdminDto> findAllAdmins() {
        List<User> admins = userRepository.findAllByRoles(getAdminRole());
        log.debug("Admins from db: {}", admins);
        return admins.stream().map(a -> mapper.map(a, AdminDto.class)).collect(Collectors.toList());
    }

    @Override
    public void save(AdminDto admin) {
        log.debug("Admin from form: {}", admin);
        User user = new User();
        user.setName(admin.getName());
        user.setSurname(admin.getSurname());
        user.setEmail(admin.getEmail());
        user.setActive(Boolean.TRUE);

        CharacterRule alphabets = new CharacterRule(EnglishCharacterData.Alphabetical);
        CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);
        CharacterRule special = new CharacterRule(EnglishCharacterData.Special);
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.generatePassword(8, alphabets, digits, special);
        user.setPassword(encoder.encode(password));
        emailService.sendSimpleMessage(user.getEmail(), "Password for your charity admin account",
                "Welcome "+ admin.getName() + "! Password to your charity admin account is: " + password);

        user.getRoles().add(getAdminRole());
        log.debug("Admin before save: {}", user);
        userRepository.save(user);
        log.info("Added new admin!");
    }

    @Override
    public EditAdminDto findAdminById(Long id) {
        return mapper.map(userRepository.getOne(id), EditAdminDto.class);
    }

    @Override
    public void updateAdmin(EditAdminDto adminDTO) {
        log.debug("Admin DTO: {}", adminDTO);
        User user = mapper.map(adminDTO, User.class);
        user.setActive(Boolean.TRUE);
        user.getRoles().add(getAdminRole());
        user.setPassword(encoder.encode(adminDTO.getPassword()));
        log.debug("Admin before save to user table: {}", user);
        userRepository.save(user);
    }

    public Role getAdminRole() {
        return roleRepository.getByName("ROLE_ADMIN");
    }

    public Role getUserRole() {
        return roleRepository.getByName("ROLE_USER");
    }

    @Override
    public void deleteAdminById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<EditUserDto> findAllUsers() {
        return userRepository.findAllByRoles(getUserRole())
                .stream().map(m -> mapper.map(m, EditUserDto.class)).collect(Collectors.toList());
    }

    @Override
    public EditUserDto findUserById(Long id) {
        return mapper.map(userRepository.getOne(id), EditUserDto.class);
    }

    @Override
    public void updateUser(EditUserDto userDTO) {
        User user = mapper.map(userDTO, User.class);
        user.setActive(Boolean.TRUE);
        user.getRoles().add(getUserRole());
        user.setPassword(encoder.encode(userDTO.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void blockUserById(Long id) {
        User user = userRepository.getOne(id);
        user.setActive(Boolean.FALSE);
        userRepository.save(user);
    }

    @Override
    public void activateUserById(Long id) {
        User user = userRepository.getOne(id);
        user.setActive(Boolean.TRUE);
        userRepository.save(user);
    }

    @Override
    public DeleteAdminDto findAdminToDeleteById(Long id) {
        return mapper.map(userRepository.getOne(id), DeleteAdminDto.class);
    }

}
