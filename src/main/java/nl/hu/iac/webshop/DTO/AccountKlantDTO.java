package nl.hu.iac.webshop.DTO;

import java.util.Date;

public class AccountKlantDTO {
    private String accountUsername;
    private String accountPassword;
    private Date accountOpenDatum;
    private String klantNaam;
    private String klantAfbeelding;
    private String adresStraat;
    private String adresStraatNummer;

    public AccountKlantDTO(String accountUsername, String accountPassword, Date accountOpenDatum,
                           String klantNaam, String klantAfbeelding, String adresStraat,
                           String adresStraatNummer) {
        this.accountUsername = accountUsername;
        this.accountPassword = accountPassword;
        this.accountOpenDatum = accountOpenDatum;
        this.klantNaam = klantNaam;
        this.klantAfbeelding = klantAfbeelding;
        this.adresStraat = adresStraat;
        this.adresStraatNummer = adresStraatNummer;
    }

    public String getAccountUsername() {
        return accountUsername;
    }

    public void setAccountUsername(String accountUsername) {
        this.accountUsername = accountUsername;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public Date getAccountOpenDatum() {
        return accountOpenDatum;
    }

    public void setAccountOpenDatum(Date accountOpenDatum) {
        this.accountOpenDatum = accountOpenDatum;
    }

    public String getKlantNaam() {
        return klantNaam;
    }

    public void setKlantNaam(String klantNaam) {
        this.klantNaam = klantNaam;
    }

    public String getKlantAfbeelding() {
        return klantAfbeelding;
    }

    public void setKlantAfbeelding(String klantAfbeelding) {
        this.klantAfbeelding = klantAfbeelding;
    }

    public String getAdresStraat() {
        return adresStraat;
    }

    public void setAdresStraat(String adresStraat) {
        this.adresStraat = adresStraat;
    }

    public String getAdresStraatNummer() {
        return adresStraatNummer;
    }

    public void setAdresStraatNummer(String adresStraatNummer) {
        this.adresStraatNummer = adresStraatNummer;
    }
}
