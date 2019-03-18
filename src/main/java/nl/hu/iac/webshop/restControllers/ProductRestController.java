package nl.hu.iac.webshop.restControllers;

import nl.hu.iac.webshop.domain.Product;
import nl.hu.iac.webshop.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ProductRestController.BASE_URL)
public class ProductRestController {
    static final String BASE_URL="/api/products";
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/edit/{id}")
    public Product changeProduct(@RequestBody Product product, @PathVariable Long id) {
        return productService.changeProduct(product, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
