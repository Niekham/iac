package nl.hu.iac.webshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.hu.iac.webshop.Validators.AdresConstraint;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Adres {
    @Id
    @JsonIgnore
    @SequenceGenerator(name = "adres_id_generator", sequenceName = "adres_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adres_id_generator")
    private Long id;
    @NotBlank
    private String straat;
    @AdresConstraint
    private String postcode;
    @NotBlank
    private String plaats;
    @JsonIgnore
    @OneToOne(mappedBy = "adres", cascade = CascadeType.ALL)
    private Klant klant;

    public Adres() {
    }

    public Adres(String straat, String postcode, String plaats, Klant klant) {
        this.straat = straat;
        this.postcode = postcode;
        this.plaats = plaats;
        this.klant = klant;
    }

    public Long getId() {
        return id;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public Klant getKlant() {
        return klant;
    }

    public String getPostcode() { return postcode;}

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public String getPlaats() { return plaats; }
}
