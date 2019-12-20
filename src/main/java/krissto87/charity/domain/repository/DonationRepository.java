package krissto87.charity.domain.repository;

import krissto87.charity.domain.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Query(value = "SELECT SUM(quantity) FROM donations", nativeQuery = true)
    Long sumQuantities();

    @Query(value = "SELECT COUNT(DISTINCT institution_id) FROM donations JOIN institutions i ON donations.institution_id = i.id", nativeQuery = true)
    Long countOfInstitutionWithDonation();
}
