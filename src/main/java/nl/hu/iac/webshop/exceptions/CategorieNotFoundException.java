package nl.hu.iac.webshop.exceptions;

public class CategorieNotFoundException extends RuntimeException{
    public CategorieNotFoundException() {
        super(String.format("Categorie not found"));
    }

    public CategorieNotFoundException(Long id) {
        super(String.format("Categorie %s not found", id));
    }
}
