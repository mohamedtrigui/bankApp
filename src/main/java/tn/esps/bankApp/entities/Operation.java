package tn.esps.bankApp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name ="t_operations")
@Data @NoArgsConstructor @AllArgsConstructor
@Inheritance()
@DiscriminatorColumn(name="type_op",discriminatorType = DiscriminatorType.STRING,length = 1)
public abstract class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateOperation;
    private BigDecimal montant;

    @ManyToOne(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    private Compte compte;

    public Operation(Date dateOperation, BigDecimal montant, Compte compte) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.compte = compte;
    }
}
