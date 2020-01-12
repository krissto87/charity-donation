package krissto87.charity.domain.repository;

import krissto87.charity.domain.entities.Role;
import krissto87.charity.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {
    User findUserByEmail(String username);

    List<User> findAllByRoles(Role role);

    Boolean existsByEmail(String email);

}

