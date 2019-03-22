package nl.hu.iac.webshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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
    private String omschrijving;
    @JsonIgnore
    @OneToMany(mappedBy = "aanbieding")
    private List<Product> products;

    public Aanbieding() {
    }

    public Aanbieding(Date vanDatum, Date totDatum, int percentage, List<Product> products, String omschrijving) {
        this.vanDatum = vanDatum;
        this.totDatum = totDatum;
        this.percentage = percentage;
        this.products = products;
        this.omschrijving = omschrijving;
    }

    public Long getId() {
        return id;
    }

    public Date getVanDatum() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date vanDatum = this.vanDatum;
        dateFormat.format(vanDatum);
        return vanDatum;
    }

    public void setVanDatum(String vanDatum) {
        TimeZone zone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-M-d");
        formatter1.setTimeZone(zone);
        try {

            this.vanDatum = formatter1.parse(vanDatum);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setTotDatum(String totDatum) {
        TimeZone zone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-M-d");
        formatter2.setTimeZone(zone);
        try {
            this.totDatum = formatter2.parse(totDatum + " 22-59-00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getTotDatum() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date vanDatum = this.totDatum;
        dateFormat.format(totDatum);
        return totDatum;
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

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }
}
