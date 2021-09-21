package tn.esps.bankApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esps.bankApp.entities.Compte;
import tn.esps.bankApp.services.CompteServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/comptes")
@CrossOrigin("*")
public class CompteController {
    @Autowired
    private CompteServiceImpl compteService;

    @GetMapping
    public List<Compte> findAll(){
        return compteService.findAll();
    }


    @PostMapping("/client/{id}")
    public void save(@RequestBody Compte compte, @PathVariable(name = "id") Long idClient){
        compteService.save(compte, idClient);
    }
}
