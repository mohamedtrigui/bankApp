package tn.esps.bankApp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esps.bankApp.entities.Client;
import tn.esps.bankApp.services.ClientServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
@AllArgsConstructor
public class ClientController {
    private ClientServiceImpl clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK) ;
    }

    @PostMapping("")
    public ResponseEntity<Void> save(@RequestBody Client client){
        clientService.save(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
        clientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
