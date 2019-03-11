package nl.hu.iac.webshop.domain;


import javax.persistence.*;

@Entity
public class Bestellingsregel {
    @Id
    @GeneratedValue
    private Long id;
    private int aantal;
    private double prijs;
    @ManyToOne
    @JoinColumn(name = "bestelling_id")
    private Bestelling bestelling;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Bestellingsregel() {
    }

    public Bestellingsregel(int aantal, double prijs, Bestelling bestelling, Product product) {
        this.aantal = aantal;
        this.prijs = prijs;
        this.bestelling = bestelling;
        this.product = product;
    }

    public Long getId() {
        return id;
    }


    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public Bestelling getBestelling() {
        return bestelling;
    }
}
