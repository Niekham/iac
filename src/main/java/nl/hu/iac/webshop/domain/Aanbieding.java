package nl.hu.iac.webshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Aanbieding {
    @Id
    @GeneratedValue
    Long id;
    private Date vanDatum;
    private Date totDatum;
}
