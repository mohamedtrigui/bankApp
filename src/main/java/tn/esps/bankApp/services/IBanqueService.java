package tn.esps.bankApp.services;

import tn.esps.bankApp.dto.OperationsData;
import tn.esps.bankApp.entities.Compte;

import java.math.BigDecimal;

public interface IBanqueService {
    Compte consulterCompte(String codeCompte);
    void verser(String codeCompte, BigDecimal montant);
    void retirer(String codeCompte, BigDecimal montant);
    void virement(String codeCompte1,String codeCompte2,BigDecimal montant);
    OperationsData listOp(String codeCompte, int page, int size);
}
