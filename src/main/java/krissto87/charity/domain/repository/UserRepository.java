package krissto87.charity.domain.repository;

import krissto87.charity.domain.entities.Role;
import krissto87.charity.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {

    User findUserByEmail(String username);

    List<User> findAllByRoles(Role adminRole);
}

