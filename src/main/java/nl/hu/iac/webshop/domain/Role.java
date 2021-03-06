package nl.hu.iac.webshop.domain;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @SequenceGenerator(name = "role_id_generator", sequenceName = "role_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_generator")
    private Long id;
    private String name;

    public Role() {}

    public Role(String name) {
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
