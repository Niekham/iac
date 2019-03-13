package nl.hu.iac.webshop.exceptions;

public class AdresNotFoundException extends RuntimeException {
    public AdresNotFoundException() {
        super(String.format("Adres not found"));
    }

    public AdresNotFoundException(Long id) {
        super(String.format("Adres %s not found", id));
    }
}
