package tn.esps.bankApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name ="t_comptes")
@Getter @Setter @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codeCompte;
    private Date dateCreation;
    private BigDecimal solde;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    } ,fetch=FetchType.EAGER)
    @NotNull
    @JoinColumn(name="client_id")
    private Client client;

    @OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY,mappedBy="compte")
    @JsonIgnore
    private Collection<Operation> operations;
}
