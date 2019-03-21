package nl.hu.iac.webshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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

    public Date getVanDatum() { return vanDatum;
    }

    public void setVanDatum(String vanDatum) {
        TimeZone zone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat formatter1 = new SimpleDateFormat("d-M-yyyy");
        formatter1.setTimeZone(zone);
        System.out.println(vanDatum);
        try {

            this.vanDatum = formatter1.parse(vanDatum);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setTotDatum(String totDatum) {
        TimeZone zone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat formatter2 = new SimpleDateFormat("d-M-yyyy HH-mm-ss");
        formatter2.setTimeZone(zone);
        try {
            this.totDatum = formatter2.parse(totDatum + " 22-59-00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getTotDatum() {
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
}
