package nl.hu.iac.webshop.services;

import nl.hu.iac.webshop.domain.Product;
import nl.hu.iac.webshop.exceptions.ProductNotFoundException;
import nl.hu.iac.webshop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }


}
