package krissto87.charity.services.impl;

import krissto87.charity.domain.entities.Institution;
import krissto87.charity.domain.repository.InstitutionRepository;
import krissto87.charity.dtos.InstitutionDTO;
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

    private final InstitutionRepository institutionRepository;
    private final ModelMapper mapper;

    public DefaultAdminService(InstitutionRepository institutionRepository, ModelMapper mapper) {
        this.institutionRepository = institutionRepository;
        this.mapper = mapper;
    }

    @Override
    public List<InstitutionDTO> findAll() {
        List<Institution> institutions = institutionRepository.findAll();
        log.debug("Institutions from db: {}", institutions);
        return institutions.stream()
                .map(i-> mapper.map(i, InstitutionDTO.class)).collect(Collectors.toList());
    }
}
