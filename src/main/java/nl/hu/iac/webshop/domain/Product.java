package nl.hu.iac.webshop.domain;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @SequenceGenerator(name = "product_id_generator", sequenceName = "product_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_generator")
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAAM")
    private String naam;
    @Column(name = "PRIJS")
    private double prijs;
    @Column(name = "AFBEELDING")
    private String afbeelding;

    public Product(){}

    public Product(Long id, String naam, double prijs, String afbeelding) {
        this.id = id;
        this.naam = naam;
        this.prijs = prijs;
        this.afbeelding = afbeelding;
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

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getAfbeelding() {
        return afbeelding;
    }

    public void setAfbeelding(String afbeelding) {
        this.afbeelding = afbeelding;
    }

}
