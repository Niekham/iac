package nl.hu.iac.webshop.restControllers;

import nl.hu.iac.webshop.domain.Categorie;
import nl.hu.iac.webshop.domain.Product;
import nl.hu.iac.webshop.services.CategorieService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(CategorieRestController.BASE_URL)
public class CategorieRestController {
    static final String BASE_URL="/api/categories";

    private final CategorieService categorieService;

    public CategorieRestController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    public List<Categorie> getAllCategories(){
        return categorieService.findAllCategories();
    }

    @GetMapping("/{id}")
    public Categorie getCategorieById(@PathVariable Long id){return categorieService.findById(id);}

    @PostMapping("/add")
    public Categorie saveCategorie(@RequestBody Categorie categorie){return categorieService.saveCategorie(categorie);}



}
