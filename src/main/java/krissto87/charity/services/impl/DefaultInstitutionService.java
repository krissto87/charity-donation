package krissto87.charity.services.impl;

import krissto87.charity.dtos.InstitutionDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import krissto87.charity.domain.entities.Institution;
import krissto87.charity.domain.repository.InstitutionRepository;
import krissto87.charity.services.InstitutionService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
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
        List<InstitutionDTO> institutionDTOS =  new ArrayList<>();
        for (Institution institution:
             institutions) {
            InstitutionDTO institutionDTO = mapper.map(institution, InstitutionDTO.class);
            institutionDTOS.add(institutionDTO);
        }
        return institutionDTOS;
    }
}
