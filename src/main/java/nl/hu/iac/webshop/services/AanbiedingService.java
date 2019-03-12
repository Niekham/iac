package nl.hu.iac.webshop.services;

import nl.hu.iac.webshop.domain.Aanbieding;
import nl.hu.iac.webshop.exceptions.AanbiedingNotFoundException;
import nl.hu.iac.webshop.repositories.AanbiedingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AanbiedingService {
    private final AanbiedingRepository aanbiedingRepository;

    public AanbiedingService(AanbiedingRepository aanbiedingRepository) {
        this.aanbiedingRepository = aanbiedingRepository;
    }

    public List<Aanbieding> getAanbiedingen(){return aanbiedingRepository.findAll();}

    public Aanbieding getAanbiedingenById(Long id){return aanbiedingRepository.findById(id).orElseThrow(()-> new AanbiedingNotFoundException(id));}

    public Aanbieding saveAanbieding(Aanbieding aanbieding){ return aanbiedingRepository.save(aanbieding);}
}
