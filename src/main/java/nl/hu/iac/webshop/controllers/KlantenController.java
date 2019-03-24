package nl.hu.iac.webshop.controllers;

import nl.hu.iac.webshop.domain.Adres;
import nl.hu.iac.webshop.domain.Klant;
import nl.hu.iac.webshop.services.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class KlantenController {
    private AccountService accountService;

    @GetMapping("/klanten")
    public String alleKlantenPage(){return "/klanten";}

    @GetMapping("/klant")
    public String klantInfoPage(){return "/klant";}

    @GetMapping("/klant/{id}")
    public String klantOpId(@PathVariable Long id, Model model) {
        Klant klant = accountService.getKlantById(id);
        Adres adres = klant.getAdres();
        model.addAttribute("klant", klant);
        model.addAttribute("adres", adres);
        return "/klantOpId";
    }
}
