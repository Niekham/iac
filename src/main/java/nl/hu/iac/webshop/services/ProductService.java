package nl.hu.iac.webshop.services;

import nl.hu.iac.webshop.domain.Aanbieding;
import nl.hu.iac.webshop.domain.Product;
import nl.hu.iac.webshop.exceptions.ProductNotFoundException;
import nl.hu.iac.webshop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.unbescape.html.HtmlEscape.escapeHtml5;

@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Product findProduct(String naam, double prijs, String afbeelding){
        return productRepository.findIdByNaamAndPrijsAndAfbeelding(naam, prijs, afbeelding);
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public List<Product> findByCategory(Long id){
        return productRepository.findProductsByCategories_Id(id);
    }

    public List<Product> findByAanbieding(Long id){return productRepository.findProductsByAanbiedingId(id);}

    public Product saveProduct(Product product){

        // escape HTML5
        product.setNaam(escapeHtml5(product.getNaam()));
        product.setAfbeelding(escapeHtml5(product.getAfbeelding()));
        product.setAanbiedingprijs(escapeHtml5(product.getAanbiedingprijs()));

        return productRepository.save(product);
    }

    public Product changeProduct(Product changedProduct, Long id){
        return productRepository.findById(id)
                .map(product -> {
                    product.setNaam(escapeHtml5(changedProduct.getNaam()));
                    product.setAfbeelding(escapeHtml5(changedProduct.getAfbeelding()));
                    product.setPrijs(changedProduct.getPrijs());
                    product.setPrijs(changedProduct.getPrijs());
                    return productRepository.save(product);
                }).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public Aanbieding findAanbieding(Product product) {
        return product.getAanbieding();
    }
}
