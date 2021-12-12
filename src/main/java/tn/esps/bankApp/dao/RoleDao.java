package tn.esps.bankApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esps.bankApp.entities.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
