package tn.esps.bankApp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esps.bankApp.entities.Compte;
import tn.esps.bankApp.services.CompteServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/comptes")
@CrossOrigin("*")
@AllArgsConstructor
public class CompteController {
    private CompteServiceImpl compteService;

    @GetMapping
    public ResponseEntity<List<Compte>> findAll(){
        return new ResponseEntity<>(compteService.findAll(), HttpStatus.OK) ;
    }


    @PostMapping("/client/{id}")
    public ResponseEntity<Void> save(@RequestBody Compte compte, @PathVariable(name = "id") Long idClient){
        try {
            compteService.save(compte, idClient);
        } catch (Exception e) {
            //à implementer: message d'error dans l'objet Response
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    //pour l'update
    public ResponseEntity<Void> save(@RequestBody Compte compte){
        compteService.save(compte);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Compte> findById(@PathVariable(name = "id") Long id) {
        return  new ResponseEntity<>(compteService.findById(id), HttpStatus.OK) ;
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<Compte> findByCode(@PathVariable(name = "code") String code) {
        return  new ResponseEntity<>(compteService.consulterCompte(code), HttpStatus.OK) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
         compteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
