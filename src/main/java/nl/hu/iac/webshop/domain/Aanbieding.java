package nl.hu.iac.webshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "AANBIEDING")
public class Aanbieding {
    @Id
    @SequenceGenerator(name = "aanbieding_id_generator", sequenceName = "aanbieding_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aanbieding_id_generator")
    private Long id;
    private Date vanDatum;
    private Date totDatum;
    private int percentage;
    @JsonIgnore
    @OneToMany(mappedBy = "aanbieding")
    private List<Product> products;

    public Aanbieding() {
    }

    public Aanbieding(Date vanDatum, Date totDatum, int percentage, List<Product> products) {
        this.vanDatum = vanDatum;
        this.totDatum = totDatum;
        this.percentage = percentage;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }
}
