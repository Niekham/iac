package nl.hu.iac.webshop.restControllers;

import nl.hu.iac.webshop.DTO.BestellingDTO;
import nl.hu.iac.webshop.domain.Account;
import nl.hu.iac.webshop.domain.Bestellingsregel;
import nl.hu.iac.webshop.domain.Product;
import nl.hu.iac.webshop.services.AccountService;
import nl.hu.iac.webshop.services.BestellingService;
import nl.hu.iac.webshop.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(BestellingRestController.BASE_URL)
public class BestellingRestController {
    static final String BASE_URL = "/api/bestelling";

    private final BestellingService bestellingService;
    private final AccountService accountService;
    private final ProductService productService;

    public BestellingRestController(BestellingService bestellingService, AccountService accountService, ProductService productService) {
        this.bestellingService = bestellingService;
        this.accountService = accountService;
        this.productService = productService;
    }

    @PostMapping("/add/{id}")
    public void newOrder(@RequestBody List<BestellingDTO> bestellingDTO, @PathVariable Long id){
        Account account = accountService.getAccountById(id);
        List<Bestellingsregel> regels = new ArrayList<>();
        for (BestellingDTO dto : bestellingDTO) {
            Product product = (productService.findById(dto.getProduct_id()));
            Bestellingsregel regel = new Bestellingsregel();
            regel.setAantal(dto.getAantal());

            if (product.getAanbiedingprijs() == null) {
                regel.setPrijs(product.getPrijs());
            }else{
                regel.setPrijs(Double.parseDouble(product.getAanbiedingprijs()));
            }
            regel.setProduct(product);
            regels.add(regel);
        }
        bestellingService.saveBestelling(account, regels);
    }
}
