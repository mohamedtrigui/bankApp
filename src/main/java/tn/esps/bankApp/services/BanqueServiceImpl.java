package tn.esps.bankApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esps.bankApp.dao.OperationDao;
import tn.esps.bankApp.entities.Compte;
import tn.esps.bankApp.entities.Operation;
import tn.esps.bankApp.entities.Retrait;
import tn.esps.bankApp.entities.Versement;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BanqueServiceImpl implements IBanqueService{

    @Autowired
    private OperationDao operationDao;

    @Autowired
    private CompteServiceImpl compteService;

    @Override
    public Compte consulterCompte(String codeCompte) {
        Compte cp = compteService.consulterCompte(codeCompte);
        return cp;
    }

    @Override
    public void verser(String codeCompte, BigDecimal montant) {
        Compte cp = consulterCompte(codeCompte);
        Versement v = new Versement(new Date(),montant, cp);
        operationDao.save(v);
        //mettre à jour le solde dans le compte
        cp.setSolde(cp.getSolde().add(montant));
        compteService.save(cp);
    }

    @Override
    public void retirer(String codeCompte, BigDecimal montant) {
        Compte cp = consulterCompte(codeCompte);
        System.out.println(montant);
        if (cp.getSolde().compareTo(montant) < 0) throw new RuntimeException("solde insuffisant");
        Retrait v = new Retrait(new Date(),montant, cp);
        operationDao.save(v);
        //mettre à jour le solde dans le compte
        cp.setSolde(cp.getSolde().subtract(montant));
        compteService.save(cp);
    }

    @Override
    public void virement(String codeCompte1, String codeCompte2, BigDecimal montant) {
        retirer(codeCompte1, montant);
        verser(codeCompte2, montant);
    }

    @Override
    public OperationsData listOp(String codeCompte, int page, int size) {

        int nbrPages = operationDao.findOperationsByCompteCodeCompte(codeCompte, PageRequest.of(page, size)).getTotalPages();
        List<Operation> listOp = operationDao.findOperationsByCompteCodeCompte(codeCompte, PageRequest.of(page, size)).toList();
        return new OperationsData(listOp, nbrPages);

    }
}

