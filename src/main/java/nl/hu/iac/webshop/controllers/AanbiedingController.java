package nl.hu.iac.webshop.controllers;


import nl.hu.iac.webshop.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AanbiedingController {
    private final ProductService productService;

    public AanbiedingController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/aanbieding/{id}")
    public String getProductByAanbieding(@PathVariable Long id, Model model){
        model.addAttribute("products", productService.findByAanbieding(id));
        return "products";
    }

}
