package nl.hu.iac.webshop.repositories;


import nl.hu.iac.webshop.domain.Klant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface KlantRepository extends JpaRepository<Klant, Long> {
    Optional<Klant> findById(Long id);
}
