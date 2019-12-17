package pl.coderslab.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.domain.entities.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Query(value = "SELECT SUM(quantity) FROM donations", nativeQuery = true)
    Long sumQuantities();
}
