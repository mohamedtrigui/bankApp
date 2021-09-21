package tn.esps.bankApp.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DiscriminatorValue("R")
@Data
@EqualsAndHashCode(callSuper=true)
public class Retrait extends Operation{

    @Builder
    public Retrait() {
    }

    @Builder
    public Retrait(Long id, Date dateOperation, BigDecimal montant, Compte compte) {
        super(id, dateOperation, montant, compte);
    }

    public Retrait(Date dateOperation, BigDecimal montant, Compte compte) {
        super(dateOperation, montant, compte);
    }
}
