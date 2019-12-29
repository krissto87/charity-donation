package krissto87.charity.services;

import krissto87.charity.domain.entities.Institution;
import krissto87.charity.dtos.InstitutionDTO;

import java.util.List;

public interface InstitutionService {
    List<InstitutionDTO> findAllInstitutions();
}