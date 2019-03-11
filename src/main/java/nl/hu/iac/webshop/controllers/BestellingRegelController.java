package nl.hu.iac.webshop.controllers;

import nl.hu.iac.webshop.domain.Bestellingsregel;
import nl.hu.iac.webshop.services.BestellingRegelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(BestellingRegelController.BASE_URL)
public class BestellingRegelController {
    static final String BASE_URL = "/api/regel";

    private final BestellingRegelService bestellingRegelService;

    public BestellingRegelController(BestellingRegelService bestellingRegelService) {
        this.bestellingRegelService = bestellingRegelService;
    }

    @GetMapping("/{id}")
    public List<Bestellingsregel> findAllByBestelling(@PathVariable Long id){return bestellingRegelService.findByBestelling(id);}
}
