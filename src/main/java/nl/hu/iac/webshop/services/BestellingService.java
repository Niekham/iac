package nl.hu.iac.webshop.services;

import nl.hu.iac.webshop.domain.Account;
import nl.hu.iac.webshop.domain.Bestelling;
import nl.hu.iac.webshop.domain.Bestellingsregel;
import nl.hu.iac.webshop.repositories.BestellingRegelRepository;
import nl.hu.iac.webshop.repositories.BestellingRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BestellingService {
    private final BestellingRepository bestellingRepository;
    private final BestellingRegelRepository bestellingRegelRepository;

    public BestellingService(BestellingRepository bestellingRepository, BestellingRegelRepository bestellingRegelRepository) {
        this.bestellingRepository = bestellingRepository;
        this.bestellingRegelRepository = bestellingRegelRepository;
    }

    public void saveBestelling(Account account, List<Bestellingsregel> bestellingsregels){
        List<Bestelling> bestellingen = account.getBestellingen();
        if (!bestellingen.isEmpty()){
            for(Bestelling bestelling : bestellingen) {
                if (bestelling.getStatus().equals("open")) {
                    for (Bestellingsregel regel : bestellingsregels) {
                        regel.setBestelling(bestelling);
                        bestellingRegelRepository.save(regel);
                    }
                }else if (!bestelling.getStatus().equals("open")){
                    nieuweBestelling(account, bestellingsregels);
                }
            }
        }else {
            nieuweBestelling(account, bestellingsregels);
        }
    }

    private void nieuweBestelling(Account account, List<Bestellingsregel> bestellingsregels) {
        Bestelling newBestelling = new Bestelling("open", account, bestellingsregels);
        for(Bestellingsregel regel : bestellingsregels){
            regel.setBestelling(newBestelling);
        }
        bestellingRepository.save(newBestelling);
        for(Bestellingsregel regel : bestellingsregels)
        bestellingRegelRepository.save(regel);
    }
}
