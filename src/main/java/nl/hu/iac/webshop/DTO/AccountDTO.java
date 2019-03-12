package nl.hu.iac.webshop.DTO;

import nl.hu.iac.webshop.domain.Klant;
import java.util.Date;

public class AccountDTO {
    private String username;
    private String password;
    private Date openDatum;
    private Klant klant;

    public AccountDTO(String username, String password, Date openDatum, Klant klant) {
        this.username = username;
        this.password = password;
        this.openDatum = openDatum;
        this.klant = klant;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getOpenDatum() {
        return openDatum;
    }

    public Klant getKlant() {
        return klant;
    }
}
