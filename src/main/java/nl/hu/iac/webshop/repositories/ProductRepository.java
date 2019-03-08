package nl.hu.iac.webshop.repositories;

import nl.hu.iac.webshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
