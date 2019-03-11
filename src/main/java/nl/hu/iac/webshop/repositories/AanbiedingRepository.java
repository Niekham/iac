package nl.hu.iac.webshop.repositories;

import nl.hu.iac.webshop.domain.Aanbieding;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AanbiedingRepository extends JpaRepository<Aanbieding, Long> {
}
