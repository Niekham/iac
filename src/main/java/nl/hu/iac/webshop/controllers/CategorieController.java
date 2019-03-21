package nl.hu.iac.webshop.controllers;


import nl.hu.iac.webshop.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategorieController {
    private final ProductService productService;

    public CategorieController(ProductService productService){this.productService = productService;}

    @GetMapping("/categorie/{id}")
    public String getProductByCategorie(@PathVariable Long id, Model model){
        model.addAttribute("products", productService.findByCategory(id));
        return "products";
    }

    @GetMapping("api/categorie/add")
    public String add_categorie(){
        return "categorie_toevoegen";
    }

    @GetMapping("api/bestaande_categorie")
    public String add_Bestaande_categorie(){
        return "bestaande_categorie";
    }
}
