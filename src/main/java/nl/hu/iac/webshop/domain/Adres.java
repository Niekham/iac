package nl.hu.iac.webshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Adres {
    @Id
    @GeneratedValue
    private Long id;
    private String straat;
    private String straatNummer;

    public Adres() {
    }

    public Long getId() {
        return id;
    }


    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getStraatNummer() {
        return straatNummer;
    }

    public void setStraatNummer(String straatNummer) {
        this.straatNummer = straatNummer;
    }
}
