package krissto87.charity.services;

import krissto87.charity.domain.entities.Institution;

import java.util.List;

public interface InstitutionService {
    List<Institution> findAllInstitutions();

    Long countOfInstitutions();
}