package nl.hu.iac.webshop.controllers;

import nl.hu.iac.webshop.DTO.AanbiedingDTO;
import nl.hu.iac.webshop.domain.Aanbieding;
import nl.hu.iac.webshop.services.AanbiedingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AanbiedingController {
    private final AanbiedingService aanbiedingService;

    public AanbiedingController(AanbiedingService aanbiedingService) {
        this.aanbiedingService = aanbiedingService;
    }

    @GetMapping("/aanbiedingen")
    public List<Aanbieding> getAanbiedingen(){return aanbiedingService.getAanbiedingen();}

    @GetMapping("aanbiedingen/{id}")
    public Aanbieding getAanbiedingById(@PathVariable Long id){return aanbiedingService.getAanbiedingenById(id);}

    @PostMapping("/aanbiedingen")
    public Aanbieding saveAanbieding(@RequestBody AanbiedingDTO aanbiedingDTO){
        Aanbieding aanbieding = new Aanbieding();
        aanbieding.setVanDatum(aanbiedingDTO.getVanDatum());
        aanbieding.setTotDatum(aanbiedingDTO.getTotDatum());
        aanbieding.setPercentage(aanbiedingDTO.getPercentage());
        return aanbiedingService.saveAanbieding(aanbieding);}
}
