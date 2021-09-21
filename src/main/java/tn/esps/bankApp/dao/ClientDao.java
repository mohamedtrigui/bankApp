package tn.esps.bankApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esps.bankApp.entities.Client;

public interface ClientDao extends JpaRepository<Client, Long> {

}
