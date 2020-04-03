package krissto87.charity.services;

import krissto87.charity.dtos.InstitutionDto;

import java.util.List;

public interface InstitutionService {
    List<InstitutionDto> findAllInstitutions();

    void save(InstitutionDto institutionDTO);

    InstitutionDto findById(Long id);

    void update(InstitutionDto institutionDTO);

    void deleteInstitutionById(Long id);
}