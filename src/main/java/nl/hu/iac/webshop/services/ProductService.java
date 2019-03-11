package nl.hu.iac.webshop.services;

import nl.hu.iac.webshop.domain.Categorie;
import nl.hu.iac.webshop.domain.Product;
import nl.hu.iac.webshop.exceptions.CategorieNotFoundException;
import nl.hu.iac.webshop.exceptions.ProductNotFoundException;
import nl.hu.iac.webshop.repositories.CategorieRepository;
import nl.hu.iac.webshop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategorieRepository categorieRepository;


    public ProductService(ProductRepository productRepository, CategorieRepository categorieRepository) {
        this.productRepository = productRepository;
        this.categorieRepository = categorieRepository;
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public List<Product> findByCategory(Long id){
        return productRepository.findProductsByCategories_Id(id);
    }

    public List<Product> findByAanbieding(Long id){return productRepository.findProductsByAanbiedingId(id);}

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product changeProduct(Product changedProduct, Long id){
        return productRepository.findById(id)
                .map(product -> {
                    product.setNaam(changedProduct.getNaam());
                    product.setPrijs(changedProduct.getPrijs());
                    product.setPrijs(changedProduct.getPrijs());
                    return productRepository.save(product);
                }).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
