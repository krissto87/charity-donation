package krissto87.charity.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import krissto87.charity.domain.entities.Institution;
import krissto87.charity.domain.repository.InstitutionRepository;
import krissto87.charity.services.InstitutionService;

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
}
