package pl.coderslab.charity.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.Institution;
import pl.coderslab.charity.domain.repository.InstitutionRepository;
import pl.coderslab.charity.services.InstitutionService;

import java.util.List;

@Service
@Transactional
public class DefaultInstitutionService implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    public DefaultInstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> findAllInstitutions() {
        return institutionRepository.findAll();
    }

    @Override
    public Long countOfInstitutions() {
        return institutionRepository.count();
    }
}
