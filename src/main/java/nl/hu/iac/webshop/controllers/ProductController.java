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
    public String handleGetRequest(@PathVariable Long id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "productDetail";
    }

    @GetMapping("api/product/add")
    public String add_product(){ return "Product_toevoegen"; }

    @GetMapping("api/bestaandeProducten")
    public String add_productToAanbieding(){ return "bestaande_producten"; }

}