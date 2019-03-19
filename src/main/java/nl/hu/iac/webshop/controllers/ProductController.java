package nl.hu.iac.webshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import nl.hu.iac.webshop.services.ProductService;
import org.springframework.web.bind.annotation.*;



@Controller
public class ProductController{
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "products";
    }


    @GetMapping("/products/{id}")
    public String handleGetRequest() {
        return "productDetail";
    }
}