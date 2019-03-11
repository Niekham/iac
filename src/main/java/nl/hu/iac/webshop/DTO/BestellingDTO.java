package nl.hu.iac.webshop.DTO;

import nl.hu.iac.webshop.domain.Bestelling;

public class BestellingDTO {
    private Long account_id;
    private Long product_id;
    private int aantal;
    private int prijs;


    public BestellingDTO() {
    }

    public BestellingDTO(Long account_id, Long product_id, int aantal, int prijs) {
        this.account_id = account_id;
        this.product_id = product_id;
        this.aantal = aantal;
        this.prijs = prijs;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    @Override
    public String toString() {
        return "BestellingDTO{" +
                "account_id=" + account_id +
                ", product_id=" + product_id +
                ", aantal=" + aantal +
                ", prijs=" + prijs +
                '}';
    }
}
