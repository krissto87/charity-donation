package pl.coderslab.charity.services;

import pl.coderslab.charity.domain.entities.Institution;

import java.util.List;

public interface InstitutionService {
    List<Institution> findAllInstitutions();

    Long countOfInstitutions();
}