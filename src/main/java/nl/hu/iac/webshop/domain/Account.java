package nl.hu.iac.webshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Account {
    @Id
    @SequenceGenerator(name = "account_id_generator", sequenceName = "account_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_generator")
    private Long id;
    private String username;
    private String password;
    private Date openDatum;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "klant_id")
    public Klant klant;
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

    public void setOpenDatum(Date openDatum) {
        this.openDatum = openDatum;
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
