package nl.hu.iac.webshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @SequenceGenerator(name = "product_id_generator", sequenceName = "product_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_generator")
    @Column(nullable = false, name = "ID")
    private Long id;
    @Column(name = "NAAM")
    private String naam;
    @Column(name = "PRIJS")
    private double prijs;
    @Column(name = "AANBIEDINGPRIJS")
    private String aanbiedingprijs;
    @Column(name = "AFBEELDING")
    private String afbeelding;
    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<Categorie> categories;
    @ManyToOne
    @JoinColumn(name = "aanbieding_id")
    private Aanbieding aanbieding;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Bestellingsregel> bestellingsregels;

    public Product() {
    }

    public Product(String naam, double prijs, String aanbiedingprijs, String afbeelding, List<Categorie> categories, Aanbieding aanbieding, List<Bestellingsregel> bestellingsregels) {
        this.naam = naam;
        this.prijs = prijs;
        this.aanbiedingprijs = aanbiedingprijs;
        this.afbeelding = afbeelding;
        this.categories = categories;
        this.aanbieding = aanbieding;
        this.bestellingsregels = bestellingsregels;
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

    public List<Categorie> getCategories() { return categories; }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public Aanbieding getAanbieding() {
        return aanbieding;
    }

    public void setAanbieding(Aanbieding aanbieding) {
        this.aanbieding = aanbieding;
    }

    public String getAanbiedingprijs() {
        return aanbiedingprijs;
    }

    public void setAanbiedingprijs(String aanbiedingprijs) {
        this.aanbiedingprijs = aanbiedingprijs;
    }

    public List<Bestellingsregel> getBestellingsregels() {
        return bestellingsregels;
    }
}
