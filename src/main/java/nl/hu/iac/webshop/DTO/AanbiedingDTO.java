package nl.hu.iac.webshop.DTO;

import javax.validation.constraints.NotEmpty;

;

public class AanbiedingDTO {
    @NotEmpty
    private String vanDatum;
    @NotEmpty
    private String totDatum;
    @NotEmpty
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
