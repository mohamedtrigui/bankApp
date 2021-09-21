package tn.esps.bankApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esps.bankApp.dao.CompteDao;
import tn.esps.bankApp.dao.OperationDao;
import tn.esps.bankApp.entities.Compte;
import tn.esps.bankApp.entities.Operation;
import tn.esps.bankApp.entities.Retrait;
import tn.esps.bankApp.entities.Versement;

import java.math.BigDecimal;
import java.util.Date;

@Service
@Transactional
public class BanqueServiceImpl implements IBanqueService{

    @Autowired
    private CompteDao compteDao;

    @Autowired
    private OperationDao operationDao;

    @Override
    public Compte consulterCompte(String codeCompte) {
        Compte cp = compteDao.findByCodeCompte(codeCompte);
        if (cp == null) throw new RuntimeException("compte introuvable");
        return cp;
    }

    @Override
    public void verser(String codeCompte, BigDecimal montant) {
        Compte cp = consulterCompte(codeCompte);
        Versement v = new Versement(new Date(),montant, cp);
        operationDao.save(v);
        //mettre à jour le solde dans le compte
        cp.setSolde(cp.getSolde().add(montant));
        compteDao.save(cp);
    }

    @Override
    public void retirer(String codeCompte, BigDecimal montant) {
        Compte cp = consulterCompte(codeCompte);
        if (cp.getSolde().compareTo(montant) < 0) throw new RuntimeException("solde insuffisant");
        Retrait v = new Retrait(new Date(),montant, cp);
        operationDao.save(v);
        //mettre à jour le solde dans le compte
        cp.setSolde(cp.getSolde().subtract(montant));
        compteDao.save(cp);
    }

    @Override
    public void virement(String codeCompte1, String codeCompte2, BigDecimal montant) {
        retirer(codeCompte1, montant);
        verser(codeCompte2, montant);

    }

    @Override
    public Page<Operation> listOp(String codeCompte, int page, int size) {

        //return null;
        //je ne sais pas pourquoi page request ne fonctionne pas
        return operationDao.findOperationsByCompteCodeCompte(codeCompte, PageRequest.of(page, size));

    }
}
