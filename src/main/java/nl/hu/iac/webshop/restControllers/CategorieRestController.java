package nl.hu.iac.webshop.restControllers;

import nl.hu.iac.webshop.domain.Categorie;
import nl.hu.iac.webshop.services.CategorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.unbescape.html.HtmlEscape.escapeHtml5;

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

    @DeleteMapping("/delete/{id}")
    public void deleteCategorie(@PathVariable Long id){
         categorieService.deleteCategorie(id);
    }

    @PostMapping("/add")
    public Categorie saveCategorie(@RequestBody Categorie categorie){
        categorie.setNaam(escapeHtml5(categorie.getNaam()));
        categorie.setOmschrijving(escapeHtml5(categorie.getOmschrijving()));
        categorie.setAfbeelding(escapeHtml5(categorie.getAfbeelding()));
        return categorieService.saveCategorie(categorie);
    }

    @PostMapping("/edit/{id}")
    public Categorie changeCategorie(@RequestBody Categorie categorie, @PathVariable Long id){
        categorie.setNaam(escapeHtml5(categorie.getNaam()));
        categorie.setOmschrijving(escapeHtml5(categorie.getOmschrijving()));
        categorie.setAfbeelding(escapeHtml5(categorie.getAfbeelding()));
        return categorieService.changeCategorie(categorie, id);
    }

}
