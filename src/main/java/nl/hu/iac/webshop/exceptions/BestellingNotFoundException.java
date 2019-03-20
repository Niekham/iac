package nl.hu.iac.webshop.exceptions;

public class BestellingNotFoundException extends RuntimeException {
    public BestellingNotFoundException() {super(String.format("Bestelling not found"));}

    public BestellingNotFoundException(Long id) {super(String.format("Bestelling %s not found", id));}
}
