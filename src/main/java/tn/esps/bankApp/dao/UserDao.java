package tn.esps.bankApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esps.bankApp.entities.User;

public interface UserDao extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
