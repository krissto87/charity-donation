package krissto87.charity.domain.repository;

import krissto87.charity.domain.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT SUM(quantity) FROM donations", nativeQuery = true)
    Long sumQuantities();

    @Query(value = "SELECT COUNT(DISTINCT institution_id) FROM donations d JOIN institutions i ON d.institution_id = i.id", nativeQuery = true)
    Long countOfInstitutionWithDonation();

    List<Donation> findAllByDonorEmailOrderByDeliveredDescDeliverTimeDescCreateTimeDesc(String username);

}
