package tn.esps.bankApp.services;

import org.springframework.data.domain.Page;
import tn.esps.bankApp.entities.Compte;
import tn.esps.bankApp.entities.Operation;

import java.math.BigDecimal;

public interface IBanqueService {
    Compte consulterCompte(String codeCompte);
    void verser(String codeCompte, BigDecimal montant);
    void retirer(String codeCompte, BigDecimal montant);
    void virement(String codeCompte1,String codeCompte2,BigDecimal montant);
    Page<Operation> listOp(String codeCompte, int page, int size);
}
