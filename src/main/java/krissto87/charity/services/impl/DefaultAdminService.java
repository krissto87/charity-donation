package krissto87.charity.services.impl;

import krissto87.charity.domain.entities.User;
import krissto87.charity.domain.repository.UserRepository;
import krissto87.charity.dtos.AdminDTO;
import krissto87.charity.services.AdminService;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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

    public DefaultAdminService(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public List<AdminDTO> findAll() {
        List<User> admins = userRepository.findAllUsersByRoles();
        log.debug("Admins from db: {}", admins);
        return admins.stream().map(a -> mapper.map(a, AdminDTO.class)).collect(Collectors.toList());
    }
}
