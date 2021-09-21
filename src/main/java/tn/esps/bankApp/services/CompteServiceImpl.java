package tn.esps.bankApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esps.bankApp.dao.CompteDao;
import tn.esps.bankApp.entities.Client;
import tn.esps.bankApp.entities.Compte;

import java.util.Date;
import java.util.List;

@Service
public class CompteServiceImpl implements ICompteService{

    @Autowired
    private CompteDao compteDao;

    @Autowired
    private ClientServiceImpl clientService;

    public void save(Compte compte, Long id) {
        Client client = clientService.getById(id);
        compte.setClient(client);
        compte.setDateCreation(new Date());
        compteDao.save(compte);
    }

    public List<Compte> findAll() {
        return compteDao.findAll();
    }
}
