package tn.esps.bankApp.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tn.esps.bankApp.entities.Operation;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class OperationsData {
        private List<Operation> listOp;
        private int nbrPages;
}
