package nl.hu.iac.webshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "CATEGORIE")
public class Categorie {
    @Id
    @SequenceGenerator(name = "category_id_generator", sequenceName = "category_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_id_generator")
    private Long id;
    private String naam;
    private String afbeelding;
    private String omschrijving;
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "categorie_product",
            joinColumns = {@JoinColumn(name="categorie_id")},
            inverseJoinColumns = {@JoinColumn(name="product_id")}
    )
    private List<Product> products;

    public Categorie() {
    }

    public Categorie(String naam, String afbeelding, String omschrijving, List<Product> products) {
        this.naam = naam;
        this.afbeelding = afbeelding;
        this.omschrijving = omschrijving;
        this.products = products;
    }

    public Long getId() { return id; }

    public String getNaam() { return naam; }

    public void setNaam(String naam) { this.naam = naam; }

    public String getAfbeelding() {
        return afbeelding;
    }

    public void setAfbeelding(String afbeelding) {
        this.afbeelding = afbeelding;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct() {
    }
}
