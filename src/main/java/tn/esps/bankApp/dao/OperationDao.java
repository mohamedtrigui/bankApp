package tn.esps.bankApp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esps.bankApp.entities.Operation;

public interface OperationDao extends JpaRepository<Operation, Long> {
    Page<Operation> findOperationsByCompteCodeCompte(String codeCompte, Pageable peagable);
}
