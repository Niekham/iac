package nl.hu.iac.webshop.DTO;


public class AccountKlantDTO {
    private String accountUsername;
    private String accountPassword;
    private String accountOpenDatum;
    private String klantNaam;
    private String klantEmail;
    private String klantAfbeelding;
    private String adresPlaats;
    private String adresStraat;
    private String adresPostcode;

    public AccountKlantDTO(String accountUsername, String accountPassword, String accountOpenDatum, String klantNaam, String klantEmail, String klantAfbeelding, String adresPlaats, String adresStraat, String adresPostcode) {
        this.accountUsername = accountUsername;
        this.accountPassword = accountPassword;
        this.accountOpenDatum = accountOpenDatum;
        this.klantNaam = klantNaam;
        this.klantEmail = klantEmail;
        this.klantAfbeelding = klantAfbeelding;
        this.adresPlaats = adresPlaats;
        this.adresStraat = adresStraat;
        this.adresPostcode = adresPostcode;
    }

    public String getAccountUsername() {
        return accountUsername;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public String getAccountOpenDatum() {
        return accountOpenDatum;
    }

    public String getKlantNaam() {
        return klantNaam;
    }

    public String getKlantAfbeelding() {
        return klantAfbeelding;
    }

    public String getAdresStraat() {
        return adresStraat;
    }

    public String getAdresPlaats() { return adresPlaats; }

    public String getAdresPostcode() { return adresPostcode; }

    public String getKlantEmail() { return klantEmail; }
}
