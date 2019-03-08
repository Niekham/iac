package nl.hu.iac.webshop.controllers;

import nl.hu.iac.webshop.domain.Product;
import nl.hu.iac.webshop.services.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ProductController.BASE_URL)
public class ProductController {
    public static final String BASE_URL = "/products";

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    List<Product> getAllProducts(){return productService.findAllProducts();}
}
