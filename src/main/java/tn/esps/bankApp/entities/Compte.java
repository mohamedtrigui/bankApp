package tn.esps.bankApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name ="t_comptes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codeCompte;
    private Date dateCreation;
    private BigDecimal solde;

    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonIgnore
    private Client client;

    @OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY,mappedBy="compte")
    private Collection<Operation> operations;
}
