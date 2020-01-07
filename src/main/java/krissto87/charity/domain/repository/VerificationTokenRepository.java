package krissto87.charity.domain.repository;

import krissto87.charity.domain.entities.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository <VerificationToken, Long> {
    VerificationToken findByToken(String token);
}
