package nl.hu.iac.webshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import nl.hu.iac.webshop.domain.Product;
import nl.hu.iac.webshop.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping
public class ProductController{ private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "products";
    }

    @GetMapping("/products/categorie/{id}")
    public String getProductByCategorie(@PathVariable Long id, Model model){
        model.addAttribute("products", productService.findByCategory(id));
        return "products";
    }

    @GetMapping("/products/aanbieding/{id}")
    public String getProductByAanbieding(@PathVariable Long id, Model model){
        model.addAttribute("products", productService.findByAanbieding(id));
        return "products";
    }

    @GetMapping("/products/{id}")
    public String handleGetRequest() {
        return "productDetail";
    }


    @PostMapping("/products/add")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/products/edit/{id}")
    public Product changeProduct(@RequestBody Product product, @PathVariable Long id) {
        return productService.changeProduct(product, id);
    }

    @DeleteMapping("/product/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
