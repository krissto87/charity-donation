package pl.coderslab.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.domain.entities.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}
