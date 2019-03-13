package nl.hu.iac.webshop.exceptions;

public class KlantNotFoundException extends RuntimeException {
    public KlantNotFoundException() {
        super(String.format("Klant not found"));
    }

    public KlantNotFoundException(Long id) {
        super(String.format("Klant %s not found", id));
    }
}
