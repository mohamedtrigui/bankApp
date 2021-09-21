package tn.esps.bankApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esps.bankApp.entities.Client;
import tn.esps.bankApp.services.ClientServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping
    public List<Client> findAll(){
        return clientService.findAll();
    }

    @PostMapping
    public void save(@RequestBody Client client){
        clientService.save(client);
    }
}
