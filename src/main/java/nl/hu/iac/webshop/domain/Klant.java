package nl.hu.iac.webshop.domain;

import javax.persistence.*;

@Entity
@Table(name = "KLANT")
public class Klant {
    @Id
    @SequenceGenerator(name = "klant_id_generator", sequenceName = "klant_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "klant_id_generator")
    private Long id;
    private String naam;
    private String afbeelding;
    @OneToOne(mappedBy = "klant",cascade = CascadeType.ALL)
    public Account account;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adres_id")
    public Adres adres;

    public Klant(){

    }

    public Klant(String naam, String afbeelding, Account account, Adres adres) {
        this.naam = naam;
        this.afbeelding = afbeelding;
        this.account = account;
        this.adres = adres;
    }


    public Long getId() {
        return id;
    }


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAfbeelding() {
        return afbeelding;
    }

    public void setAfbeelding(String afbeelding) {
        this.afbeelding = afbeelding;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Adres getAdres() {
        return adres;
    }
}
