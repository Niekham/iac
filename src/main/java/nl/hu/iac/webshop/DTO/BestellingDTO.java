package nl.hu.iac.webshop.DTO;


public class BestellingDTO {
    private Long product_id;
    private int aantal;


    public BestellingDTO() {
    }

    public BestellingDTO(Long product_id, int aantal) {
        this.product_id = product_id;
        this.aantal = aantal;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public int getAantal() {
        return aantal;
    }
}
