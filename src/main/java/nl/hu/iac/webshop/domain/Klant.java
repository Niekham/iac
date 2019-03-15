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
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    public Account account;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adres_id")
    private Adres adres;

    public Klant(){

    }

    public Klant(String naam, String email, Account account, Adres adres) {
        this.naam = naam;
        this.email = email;
        this.account = account;
        this.adres = adres;
    }

    public Long getId() {
        return id;
    }


    public String getNaam() {
        return naam;
    }

    public String getEmail() {
        return email;
    }

    public Account getAccount() {
        return account;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
