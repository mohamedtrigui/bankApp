package tn.esps.bankApp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esps.bankApp.entities.Operation;

public interface OperationDao extends JpaRepository<Operation, Long> {
    Page<Operation> findOperationsByCompteCodeCompte(String codeCompte, Pageable peagable);
}
