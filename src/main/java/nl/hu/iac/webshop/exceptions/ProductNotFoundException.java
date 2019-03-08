package nl.hu.iac.webshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException() {
        super(String.format("Product not found"));
    }

    public ProductNotFoundException(Long id) {
        super(String.format("Product %s not found", id));
    }
}
