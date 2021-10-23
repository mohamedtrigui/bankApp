package tn.esps.bankApp.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DiscriminatorValue("V")
@Data
@EqualsAndHashCode(callSuper=true)
public class Versement extends Operation {
    @Column(name="type_op", insertable = false, updatable = false)
    protected String typeOp;

    @Builder
    public Versement() {
    }

    @Builder
    public Versement(Long id, Date dateOperation, BigDecimal montant, Compte compte) {
        super(id, dateOperation, montant, compte);
    }

    @Builder
    public Versement(Date dateOperation, BigDecimal montant, Compte compte) {
        super(dateOperation, montant, compte);
    }
}
