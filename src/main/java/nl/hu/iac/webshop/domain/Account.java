package nl.hu.iac.webshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private Date openDatum;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public Date getOpenDatum() {
        return openDatum;
    }

    public void setOpenDatum(Date openDatum) {
        this.openDatum = openDatum;
    }
}
