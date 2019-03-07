package nl.hu.iac.webshop.domain;

import javax.persistence.Entity;

@Entity
public class Klant {
    private String naam;
    private String afbeelding;
    private Adres adres;
    private Account account;
}
