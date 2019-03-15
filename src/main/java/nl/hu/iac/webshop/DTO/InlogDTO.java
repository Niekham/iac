package nl.hu.iac.webshop.DTO;

public class InlogDTO {
    private String username;
    private String password;

    public InlogDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }



}
