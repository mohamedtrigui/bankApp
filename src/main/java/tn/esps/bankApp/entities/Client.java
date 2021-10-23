package tn.esps.bankApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name ="t_clients")
@Getter @Setter @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String email;

//    @OneToMany(cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    } ,fetch=FetchType.LAZY,mappedBy="client")
//    @JsonIgnore
//    private Collection<Compte> comptes;
}
