package nl.hu.iac.webshop.repositories;

import nl.hu.iac.webshop.domain.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
