package nl.hu.iac.webshop.controllers;

import nl.hu.iac.webshop.domain.Categorie;
import nl.hu.iac.webshop.services.CategorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CategorieController.BASE_URL)
public class CategorieController {
    public static final String BASE_URL = "/api/categories";

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    public List<Categorie> getAllCategorie(){return categorieService.findAllCategories();}

    @GetMapping("/{id}")
    public Categorie getCategorieById(@PathVariable Long id){return categorieService.findById(id);}

    @PostMapping
    public Categorie saveCategorie(@RequestBody Categorie categorie){return categorieService.saveCategorie(categorie);}
}
