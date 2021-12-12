package tn.esps.bankApp.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esps.bankApp.services.BanqueServiceImpl;
import tn.esps.bankApp.dto.OperationsData;

import java.math.BigDecimal;

@RestController
@RequestMapping("/operations")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class OperationController {
    private BanqueServiceImpl banqueService;


    @GetMapping(value = {"/{codeCompte}"})
    public ResponseEntity<OperationsData> listOp(@PathVariable(value = "codeCompte") String codeCompte, @RequestParam int page, @RequestParam int size){
        OperationsData operationsData = banqueService.listOp(codeCompte,page,size) ;
        return new ResponseEntity<>(operationsData, HttpStatus.OK);
    }

    @PostMapping("/versement")
    public ResponseEntity<Void> verser(@RequestBody OperationRequest operation){
        banqueService.verser(operation.getCodeCompte(), operation.getMontant());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/retrait")
    public ResponseEntity<Void> retirer(@RequestBody OperationRequest operation){
        banqueService.retirer(operation.getCodeCompte(), operation.getMontant());

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/virement")
    public ResponseEntity<Void> virement(@RequestBody Virement virement){
        banqueService.virement(virement.getCodeCompte(), virement.getCodeCompteTwo(), virement.getMontant());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
@Getter
class Virement {
    private String codeCompte;
    private String codeCompteTwo;
    private BigDecimal montant;
}
@Getter
class OperationRequest {
    private String codeCompte;
    private BigDecimal montant;
}

