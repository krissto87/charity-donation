package krissto87.charity.domain.repository;

import krissto87.charity.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository <User, Long> {
    User findUserByEmail(String username);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET name = ?1, surname = ?2, email = ?3 WHERE id = ?4",nativeQuery = true)
    void updateUser(String name, String surname, String email, Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET password = ?2 WHERE email = ?1",nativeQuery = true)
    void changeUserPasswordByUsername(String username, String encodedPassword);

}

