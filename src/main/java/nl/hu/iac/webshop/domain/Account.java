package nl.hu.iac.webshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Entity
public class Account {
    @Id
    @SequenceGenerator(name = "account_id_generator", sequenceName = "account_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_generator")
    private Long id;
    private String username;
    private String password;
    private Date openDatum;
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Klant klant;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Bestelling> bestellingen;

    public Account() {
    }

    public Account(String username, String password, Date openDatum, Klant klant, List<Bestelling> bestellingen) {
        this.username = username;
        this.password = password;
        this.openDatum = openDatum;
        this.klant = klant;
        this.bestellingen = bestellingen;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getOpenDatum() {
        return openDatum;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public List<Bestelling> getBestellingen() {
        return bestellingen;
    }

    public void setBestellingen(List<Bestelling> bestellingen) {
        this.bestellingen = bestellingen;
    }
}
