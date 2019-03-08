package nl.hu.iac.webshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Bestelling {
    @Id
    @GeneratedValue
    private Long id;

    public Bestelling(){

    }

    public Long getId() {
        return id;
    }
}
