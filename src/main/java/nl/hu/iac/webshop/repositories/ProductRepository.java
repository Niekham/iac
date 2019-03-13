package nl.hu.iac.webshop.repositories;

import nl.hu.iac.webshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByCategories_Id(Long id);
    List<Product> findProductsByAanbiedingId(Long id);
}
