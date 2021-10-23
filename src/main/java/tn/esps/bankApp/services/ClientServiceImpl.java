package tn.esps.bankApp.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esps.bankApp.dao.ClientDao;
import tn.esps.bankApp.entities.Client;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ClientServiceImpl {
    private ClientDao clientDao;

    public void save(Client client){
        clientDao.save(client);
    }

    public Client findById(Long id){
      return clientDao.findClientById(id);
    }

    public List<Client> findAll() {
        return clientDao.findAll();
    }

    public void deleteById(Long id) {
        clientDao.deleteById(id);
    }
}
