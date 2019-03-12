package nl.hu.iac.webshop.repositories;

import nl.hu.iac.webshop.domain.Bestelling;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BestellingRepository extends JpaRepository<Bestelling, Long> {
}
