package nl.hu.iac.webshop.services;

import nl.hu.iac.webshop.domain.Aanbieding;
import nl.hu.iac.webshop.exceptions.AanbiedingNotFoundException;
import nl.hu.iac.webshop.exceptions.CategorieNotFoundException;
import nl.hu.iac.webshop.repositories.AanbiedingRepository;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AanbiedingService {
    private final AanbiedingRepository aanbiedingRepository;

    public AanbiedingService(AanbiedingRepository aanbiedingRepository) {
        this.aanbiedingRepository = aanbiedingRepository;
    }

    public List<Aanbieding> getAanbiedingenWithoutProducts(){
        List<Aanbieding> aanbiedingen = aanbiedingRepository.findAll();
        return aanbiedingen;
    }

    public List<Aanbieding> getAanbiedingen(){
        List<Aanbieding> aanbiedingen = aanbiedingRepository.findAll();
        List<Aanbieding> newList = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);
        for (Aanbieding aanbieding : aanbiedingen){
            if (date.after(aanbieding.getVanDatum()) && date.before(aanbieding.getTotDatum()) && !aanbieding.getProducts().isEmpty()){
                newList.add(aanbieding);
            }
        }
        return newList;
    }

    public Aanbieding getAanbiedingenById(Long id){return aanbiedingRepository.findById(id).orElseThrow(()-> new AanbiedingNotFoundException(id));}

    public Aanbieding saveAanbieding(Aanbieding aanbieding){ return aanbiedingRepository.save(aanbieding);}

    public Aanbieding changeAanbieding(Aanbieding changedAanbieding, Long id){
        return aanbiedingRepository.findById(id)
                .map(categorie -> {
                    categorie.setPercentage(changedAanbieding.getPercentage());
                    categorie.setTotDatum(changedAanbieding.getTotDatum().toString());
                    categorie.setVanDatum(changedAanbieding.getVanDatum().toString());
                    return aanbiedingRepository.save(categorie);
                }).orElseThrow(() -> new CategorieNotFoundException(id));
    }
}
