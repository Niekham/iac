package nl.hu.iac.webshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Aanbieding {
    @Id
    @GeneratedValue
    private Long id;
    private Date vanDatum;
    private Date totDatum;

    public Aanbieding() {
    }

    public Long getId() {
        return id;
    }

    public Date getVanDatum() {
        return vanDatum;
    }

    public void setVanDatum(Date vanDatum) {
        this.vanDatum = vanDatum;
    }

    public Date getTotDatum() {
        return totDatum;
    }

    public void setTotDatum(Date totDatum) {
        this.totDatum = totDatum;
    }
}
