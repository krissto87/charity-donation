package krissto87.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import krissto87.charity.domain.entities.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
