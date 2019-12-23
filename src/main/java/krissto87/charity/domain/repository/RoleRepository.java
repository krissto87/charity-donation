package krissto87.charity.domain.repository;

import krissto87.charity.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Long> {
    Role getByName(String name);
}
