package tn.esps.bankApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esps.bankApp.entities.Compte;

public interface CompteDao extends JpaRepository<Compte, String> {
    Compte findByCodeCompte(String codeCompte);
}
