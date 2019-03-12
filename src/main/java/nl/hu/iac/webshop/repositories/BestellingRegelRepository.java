package nl.hu.iac.webshop.repositories;

import nl.hu.iac.webshop.domain.Bestellingsregel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BestellingRegelRepository extends JpaRepository<Bestellingsregel, Long> {
    List<Bestellingsregel> findAllByBestelling_Id(Long id);
}
