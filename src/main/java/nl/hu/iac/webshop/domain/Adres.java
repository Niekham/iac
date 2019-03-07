package nl.hu.iac.webshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Adres {
    @Id
    @GeneratedValue
    Long id;
    private String straat;
    private String straatNummer;
}
