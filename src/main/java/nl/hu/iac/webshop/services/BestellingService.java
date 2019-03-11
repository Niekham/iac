package nl.hu.iac.webshop.services;

import nl.hu.iac.webshop.domain.Account;
import nl.hu.iac.webshop.domain.Bestelling;
import nl.hu.iac.webshop.domain.Bestellingsregel;
import nl.hu.iac.webshop.repositories.BestellingRegelRepository;
import nl.hu.iac.webshop.repositories.BestellingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class BestellingService {
    private final BestellingRepository bestellingRepository;
    private final BestellingRegelRepository bestellingRegelRepository;

    public BestellingService(BestellingRepository bestellingRepository, BestellingRegelRepository bestellingRegelRepository) {
        this.bestellingRepository = bestellingRepository;
        this.bestellingRegelRepository = bestellingRegelRepository;
    }

    public void saveBestelling(Account account, Bestellingsregel bestellingsregel){
        List<Bestelling> bestellingen = account.getBestellingen();
        if (!bestellingen.isEmpty()){
            for(Bestelling bestelling : bestellingen) {
                if (bestelling.getStatus().equals("open")) {
                    bestellingsregel.setBestelling(bestelling);
                    bestellingRegelRepository.save(bestellingsregel);
                }else if (!bestelling.getStatus().equals("open")){
                    nieuweBestelling(account, bestellingsregel);
                }
            }
        }else {
            nieuweBestelling(account, bestellingsregel);
        }
    }

    private void nieuweBestelling(Account account, Bestellingsregel bestellingsregel) {
        Bestelling newBestelling = new Bestelling();
        List<Bestellingsregel> bestellingsregels = new ArrayList<>();
        bestellingsregels.add(bestellingsregel);
        newBestelling.newBestelling("open", account);
        newBestelling.setBestellingsregels(bestellingsregels);
        bestellingsregel.setBestelling(newBestelling);
        bestellingRepository.save(newBestelling);
        bestellingRegelRepository.save(bestellingsregel);
    }
}
