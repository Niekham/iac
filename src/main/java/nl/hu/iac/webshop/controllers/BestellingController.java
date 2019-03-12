package nl.hu.iac.webshop.controllers;

import nl.hu.iac.webshop.DTO.BestellingDTO;
import nl.hu.iac.webshop.domain.Account;
import nl.hu.iac.webshop.domain.Bestellingsregel;
import nl.hu.iac.webshop.domain.Product;
import nl.hu.iac.webshop.services.AccountService;
import nl.hu.iac.webshop.services.BestellingService;
import nl.hu.iac.webshop.services.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BestellingController.BASE_URL)
public class BestellingController {
    static final String BASE_URL = "/api/bestelling";

    private final BestellingService bestellingService;
    private final AccountService accountService;
    private final ProductService productService;

    public BestellingController(BestellingService bestellingService, AccountService accountService, ProductService productService) {
        this.bestellingService = bestellingService;
        this.accountService = accountService;
        this.productService = productService;
    }

    @PostMapping("/add")
    public void newOrder(@RequestBody BestellingDTO bestellingDTO){
        Account account = accountService.getAccountById(bestellingDTO.getAccount_id());
        Product product = productService.findById(bestellingDTO.getProduct_id());
        Bestellingsregel bestellingsregel = new Bestellingsregel();
        bestellingsregel.setPrijs(bestellingDTO.getPrijs());
        bestellingsregel.setAantal(bestellingDTO.getAantal());
        bestellingsregel.setProduct(product);
        bestellingService.saveBestelling(account, bestellingsregel);
    }
}
