package nl.hu.iac.webshop.restControllers;

import nl.hu.iac.webshop.domain.Bestellingsregel;
import nl.hu.iac.webshop.services.BestellingRegelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(BestellingRegelRestController.BASE_URL)
public class BestellingRegelRestController {
    static final String BASE_URL = "/api/bestellingregel";

    private final BestellingRegelService bestellingRegelService;

    public BestellingRegelRestController(BestellingRegelService bestellingRegelService) {
        this.bestellingRegelService = bestellingRegelService;
    }

    @GetMapping("/{id}")
    public List<Bestellingsregel> findAllByBestelling(@PathVariable Long id){return bestellingRegelService.findByBestelling(id);}
}
