package nl.hu.iac.webshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import nl.hu.iac.webshop.domain.Product;
import nl.hu.iac.webshop.services.CategorieService;
import nl.hu.iac.webshop.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(ProductController.BASE_URL)
public class ProductController{
    static final String BASE_URL = "/api/products";

    private final ProductService productService;

    public ProductController(ProductService productService, CategorieService categorieService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProducts() {
        return "products";
    }

    @GetMapping("/test")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting.html";
    }

    @GetMapping("/{id}")
    public String handleGetRequest() {
        return "productDetail";
    }

    @GetMapping("/categorie/{id}")
    public List<Product> getProductByCategorie(@PathVariable Long id){
        return productService.findByCategory(id);
    }

    @GetMapping("/aanbieding/{id}")
    public List<Product> getProductByAanbieding(@PathVariable Long id){return productService.findByAanbieding(id);}

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public Product changeProduct(@RequestBody Product product, @PathVariable Long id) {
        return productService.changeProduct(product, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
