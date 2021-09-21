package tn.esps.bankApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name ="t_clients")
@Data @NoArgsConstructor @AllArgsConstructor
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String email;
    @OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY,mappedBy="client")
    private Collection<Compte> comptes;
}
