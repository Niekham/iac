package nl.hu.iac.webshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bestellingsregel {
    @Id
    @GeneratedValue
    private Long id;
    private int aantal;
    private double prijs;

    public Bestellingsregel() {
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
}
