package krissto87.charity.domain.repository;

import krissto87.charity.domain.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Query(value = "SELECT SUM(quantity) FROM donations", nativeQuery = true)
    Long sumQuantities();

    @Query(value = "SELECT COUNT(DISTINCT institution_id) FROM donations d JOIN institutions i ON d.institution_id = i.id", nativeQuery = true)
    Long countOfInstitutionWithDonation();
    @Query(value = "SELECT * FROM donations d JOIN users u ON d.donor_id WHERE email= ?1 ORDER BY delivered, deliver_time desc, create_time desc ", nativeQuery = true)
    List<Donation> findAllWithUserSorted(String username);

    @Modifying
    @Transactional
    @Query(value = "UPDATE donations SET delivered = ?1, deliver_time = ?3 WHERE id = ?2", nativeQuery = true)
    void updateUserStatus(Boolean delivered, Long id, String deliveredTime);

}
