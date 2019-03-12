package nl.hu.iac.webshop.DTO;

import java.util.Date;
;

public class AanbiedingDTO {
    private String vanDatum;
    private String totDatum;
    private int percentage;

    public AanbiedingDTO(String vanDatum, String totDatum, int percentage) {
        this.vanDatum = vanDatum;
        this.totDatum = totDatum;
        this.percentage = percentage;
    }

    public String getVanDatum() {
        return vanDatum;
    }

    public String getTotDatum() {
        return totDatum;
    }

    public int getPercentage() {
        return percentage;
    }
}
