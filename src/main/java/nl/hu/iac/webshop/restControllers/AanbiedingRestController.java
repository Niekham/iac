package nl.hu.iac.webshop.restControllers;

import nl.hu.iac.webshop.DTO.AanbiedingDTO;
import nl.hu.iac.webshop.domain.Aanbieding;
import nl.hu.iac.webshop.services.AanbiedingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AanbiedingRestController.BASE_URL)
public class AanbiedingRestController {
    static final String BASE_URL = "/api/aanbieding";
    private final AanbiedingService aanbiedingService;

    public AanbiedingRestController(AanbiedingService aanbiedingService) {
        this.aanbiedingService = aanbiedingService;
    }

    @GetMapping
    public List<Aanbieding> getAanbiedingen(){return aanbiedingService.getAanbiedingen();}

    @GetMapping("/{id}")
    public Aanbieding getAanbiedingById(@PathVariable Long id){return aanbiedingService.getAanbiedingenById(id);}

    @PostMapping
    public Aanbieding saveAanbieding(@RequestBody AanbiedingDTO aanbiedingDTO){
        Aanbieding aanbieding = new Aanbieding();
        aanbieding.setVanDatum(aanbiedingDTO.getVanDatum());
        aanbieding.setTotDatum(aanbiedingDTO.getTotDatum());
        aanbieding.setPercentage(aanbiedingDTO.getPercentage());
        return aanbiedingService.saveAanbieding(aanbieding);}
}