package nl.hu.iac.webshop.controllers;

import nl.hu.iac.webshop.domain.Aanbieding;
import nl.hu.iac.webshop.services.AanbiedingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(AanbiedingController.BASE_URL)
public class AanbiedingController {
    public static final String BASE_URL = "/api/aanbieding";

    private final AanbiedingService aanbiedingService;

    public AanbiedingController(AanbiedingService aanbiedingService) {
        this.aanbiedingService = aanbiedingService;
    }

    @GetMapping
    public List<Aanbieding> getAanbiedingen(){return aanbiedingService.getAanbiedingen();}
}
