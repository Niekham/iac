package nl.hu.iac.webshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bestellingsregel {
    @Id
    @GeneratedValue
    Long id;
    private int aantal;
    private double prijs;
    private Product product;
}
