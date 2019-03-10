package nl.hu.iac.webshop.services;

import nl.hu.iac.webshop.domain.Categorie;
import nl.hu.iac.webshop.exceptions.CategorieNotFoundException;
import nl.hu.iac.webshop.repositories.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository){this.categorieRepository = categorieRepository;}

    public List<Categorie> findAllCategories(){return categorieRepository.findAll();}

    public Categorie findById(Long id){return categorieRepository.findById(id).orElseThrow(()-> new CategorieNotFoundException(id));}

    public Categorie saveCategorie(Categorie categorie){return categorieRepository.save(categorie);}
}
