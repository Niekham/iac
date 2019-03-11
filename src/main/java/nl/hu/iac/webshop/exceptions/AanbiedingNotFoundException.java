package nl.hu.iac.webshop.exceptions;

public class AanbiedingNotFoundException extends RuntimeException{
    public AanbiedingNotFoundException() {
        super(String.format("Aanbieding not found"));
    }

    public AanbiedingNotFoundException(Long id) {
        super(String.format("Aanbieding %s not found", id));
    }
}
