package nl.hu.iac.webshop.repositories;

import nl.hu.iac.webshop.domain.Aanbieding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AanbiedingRepository extends JpaRepository<Aanbieding, Long> {
}
