package nl.hu.iac.webshop.repositories;

import nl.hu.iac.webshop.domain.Adres;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdresRepository extends JpaRepository<Adres, Long> {
        Optional<Adres> findById(Long id);
}
