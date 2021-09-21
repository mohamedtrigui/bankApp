package tn.esps.bankApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esps.bankApp.dao.ClientDao;
import tn.esps.bankApp.entities.Client;

import java.util.List;

@Service
public class ClientServiceImpl {
    @Autowired
    private ClientDao clientDao;

    public void save(Client client){

        clientDao.save(client);
    }

    public Client getById(Long id){
      return clientDao.getById(id);
    }

    public List<Client> findAll() {
        return clientDao.findAll();
    }
}
