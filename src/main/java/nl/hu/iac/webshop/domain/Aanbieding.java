package nl.hu.iac.webshop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Aanbieding")
public class Aanbieding {
    @Id
    @GeneratedValue
    private Long id;
    private Date vanDatum;
    private Date totDatum;
    private int percentage;
    @OneToMany(mappedBy = "aanbieding")
    private List<Product> products;


    public Aanbieding() {
        this.products = new ArrayList<>();
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

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
