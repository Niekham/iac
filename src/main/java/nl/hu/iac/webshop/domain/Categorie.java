package nl.hu.iac.webshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categorie {
    @Id
    @GeneratedValue
    Long id;
    private String naam;
    private String afbeelding;
    private String omschrijving;
}
