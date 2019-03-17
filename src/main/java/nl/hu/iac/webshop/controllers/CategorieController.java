package nl.hu.iac.webshop.controllers;

import nl.hu.iac.webshop.domain.Categorie;
import nl.hu.iac.webshop.services.CategorieService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/categories")
    public List<Categorie> getAllCategories(){
        return categorieService.findAllCategories();
    }

    @GetMapping("/categories/{id}")
    public Categorie getCategorieById(@PathVariable Long id){return categorieService.findById(id);}

    @PostMapping("categories")
    public Categorie saveCategorie(@RequestBody Categorie categorie){return categorieService.saveCategorie(categorie);}
}
