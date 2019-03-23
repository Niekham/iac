package nl.hu.iac.webshop.services;

import nl.hu.iac.webshop.domain.Categorie;
import nl.hu.iac.webshop.exceptions.CategorieNotFoundException;
import nl.hu.iac.webshop.repositories.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.unbescape.html.HtmlEscape.escapeHtml5;

@Service
public class CategorieService {
    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository){this.categorieRepository = categorieRepository;}

    public List<Categorie> findAllCategories(){return categorieRepository.findAll();}

    public Categorie findById(Long id){return categorieRepository.findById(id).orElseThrow(()-> new CategorieNotFoundException(id));}

    public Categorie saveCategorie(Categorie categorie){

        // escape HTML5
        categorie.setNaam(escapeHtml5(categorie.getNaam()));
        categorie.setOmschrijving(escapeHtml5(categorie.getOmschrijving()));
        categorie.setAfbeelding(escapeHtml5(categorie.getAfbeelding()));

        return categorieRepository.save(categorie);
    }

    public void deleteCategorie (Long id){
        categorieRepository.deleteById(id);
    }

    public Categorie changeCategorie(Categorie changedCategorie, Long id){
        return categorieRepository.findById(id)
                .map(categorie -> {
                    categorie.setAfbeelding(escapeHtml5(changedCategorie.getAfbeelding()));
                    categorie.setNaam(escapeHtml5(changedCategorie.getNaam()));
                    categorie.setOmschrijving(escapeHtml5(changedCategorie.getOmschrijving()));
                    return categorieRepository.save(categorie);
                }).orElseThrow(() -> new CategorieNotFoundException(id));

}

}
