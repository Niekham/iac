package nl.hu.iac.webshop.domain;

import javax.persistence.*;

@Entity
public class Adres {
    @Id
    @SequenceGenerator(name = "adres_id_generator", sequenceName = "adres_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adres_id_generator")
    private Long id;
    private String straat;
    private String straatNummer;
    @OneToOne(mappedBy = "adres", cascade = CascadeType.ALL)
    private Klant klant;

    public Adres() {
    }

    public Adres(String straat, String straatNummer, Klant klant) {
        this.straat = straat;
        this.straatNummer = straatNummer;
        this.klant = klant;
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

    public Klant getKlant() {
        return klant;
    }
}
