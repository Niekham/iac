package nl.hu.iac.webshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Bestelling {
    @Id
    @GeneratedValue
    private Long id;
    private String status;
    @ManyToOne
    @JoinColumn(name = "bestelling_id")
    private Account account;
    @JsonIgnore
    @OneToMany(mappedBy = "bestelling")
    private List<Bestellingsregel> bestellingsregels;

    public Bestelling() {
    }

    public Bestelling(String status, Account account, List<Bestellingsregel> bestellingsregels) {
        this.status = status;
        this.account = account;
        this.bestellingsregels = bestellingsregels;
    }

    public Long getId() {
        return id;
    }

    public String getStatus(){return this.status;}

    public List<Bestellingsregel> getBestellingsregels() {
        return bestellingsregels;
    }

    public void setBestellingsregels(List<Bestellingsregel> bestellingsregels) {
        this.bestellingsregels = bestellingsregels;
    }

    public Account getAccount() {
        return account;
    }
}
