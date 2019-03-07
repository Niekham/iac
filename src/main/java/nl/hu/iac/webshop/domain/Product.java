package nl.hu.iac.webshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue
    Long id;
    private String naam;
    private double prijs;
    private Aanbieding aanbieding;
    private Categorie categorie;

}
