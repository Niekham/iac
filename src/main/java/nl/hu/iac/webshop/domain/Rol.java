package nl.hu.iac.webshop.domain;

import javax.persistence.*;

@Entity
public class Rol {
    @Id
    @SequenceGenerator(name = "rol_id_generator", sequenceName = "rol_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_id_generator")
    private Long id;
    private String name;

    public Rol() {}

    public Rol(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
