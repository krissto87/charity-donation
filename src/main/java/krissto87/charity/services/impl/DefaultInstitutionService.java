package krissto87.charity.services.impl;

import krissto87.charity.dtos.InstitutionDTO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import krissto87.charity.domain.entities.Institution;
import krissto87.charity.domain.repository.InstitutionRepository;
import krissto87.charity.services.InstitutionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class DefaultInstitutionService implements InstitutionService {

    private final InstitutionRepository institutionRepository;
    private final ModelMapper mapper;

    public DefaultInstitutionService(InstitutionRepository institutionRepository, ModelMapper mapper) {
        this.institutionRepository = institutionRepository;
        this.mapper = mapper;
    }

    @Override
    public List<InstitutionDTO> findAllInstitutions() {
        List<Institution> institutions = institutionRepository.findAll();
        log.debug("Institutions from db: {}", institutions);
        return institutions.stream()
                .map(i-> mapper.map(i, InstitutionDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void save(InstitutionDTO institutionDTO) {
        log.debug("InstitutionDTO {}", institutionDTO);
        Institution institution = new Institution();
        institution.setName(institutionDTO.getName());
        institution.setDescription(institutionDTO.getDescription());
        log.debug("Institution object before save {}", institution);
        institutionRepository.save(institution);
    }

    @Override
    public InstitutionDTO findById(Long id) {
        return mapper.map(institutionRepository.findById(id).get(), InstitutionDTO.class);
    }

    @Override
    public void update(InstitutionDTO institutionDTO) {
        institutionRepository.save(mapper.map(institutionDTO, Institution.class));
    }

    @Override
    public void deleteInstitutionById(Long id) {
        institutionRepository.deleteById(id);
    }
}
