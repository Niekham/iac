package nl.hu.iac.webshop.exceptions;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException() {
        super(String.format("Account not found"));
    }

    public AccountNotFoundException(Long id) {
        super(String.format("Account %s not found", id));
    }
}
