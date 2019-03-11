package nl.hu.iac.webshop.services;

import nl.hu.iac.webshop.domain.Bestellingsregel;
import nl.hu.iac.webshop.repositories.BestellingRegelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BestellingRegelService {
    private final BestellingRegelRepository bestellingRegelRepository;

    public BestellingRegelService(BestellingRegelRepository bestellingRegelRepository) {
        this.bestellingRegelRepository = bestellingRegelRepository;
    }

    public void saveRegel(Bestellingsregel bestellingsregel){bestellingRegelRepository.save(bestellingsregel);}

    public List<Bestellingsregel> findByBestelling(Long id){return bestellingRegelRepository.findAllByBestelling_Id(id);}
}
