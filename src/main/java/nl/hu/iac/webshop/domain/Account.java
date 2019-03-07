package nl.hu.iac.webshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Account {
    @Id
    @GeneratedValue
    Long id;
    private Date openDatum;
    private Adres factuurAdres;
    private Bestelling bestelling;
}
