package nl.hu.iac.webshop.DTO;


public class AccountKlantDTO {
    private String email;
    private String username;
    private String password;
    private String naam;
    private String tussenvoegsel;
    private String achternaam;
    private String plaats;
    private String postcode;
    private String straat;

    public AccountKlantDTO(String username, String password, String naam, String tussenvoegsel, String achternaam, String email, String plaats, String straat, String postcode) {
        this.username = username;
        this.password = password;
        this.naam = naam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.email = email;
        this.plaats = plaats;
        this.straat = straat;
        this.postcode = postcode;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNaam() {
        return naam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getEmail() {
        return email;
    }

    public String getPlaats() {
        return plaats;
    }

    public String getStraat() {
        return straat;
    }

    public String getPostcode() {
        return postcode;
    }
}
