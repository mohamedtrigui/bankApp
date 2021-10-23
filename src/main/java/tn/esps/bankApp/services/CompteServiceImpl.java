package tn.esps.bankApp.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esps.bankApp.dao.CompteDao;
import tn.esps.bankApp.entities.Client;
import tn.esps.bankApp.entities.Compte;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class CompteServiceImpl {
    private CompteDao compteDao;
    private ClientServiceImpl clientService;

    public void save(Compte compte, Long id) throws Exception {
        Client client = clientService.findById(id);
        System.out.println(client);
        if (client == null) throw new RuntimeException("Pas de client avec ce Id");
        compte.setClient(client);
        compte.setDateCreation(new Date());
        save(compte);
    }

    public List<Compte> findAll() {
        return compteDao.findAll();
    }


    public Compte consulterCompte(String codeCompte) {
        Compte cp = compteDao.findByCodeCompte(codeCompte);
        if (cp == null) throw new RuntimeException("compte introuvable");
        return cp;
    }

    public void save(Compte cp) {
        compteDao.save(cp);
    }

    public void deleteById(Long id) {
         compteDao.deleteById(String.valueOf(id));
    }

    public Compte findById(Long id) {
        return compteDao.findById(id);
    }

}
