package nl.hu.iac.webshop.controllers;
        import nl.hu.iac.webshop.DTO.AccountDTO;
        import nl.hu.iac.webshop.DTO.BestellingDTO;
        import nl.hu.iac.webshop.domain.*;
        import nl.hu.iac.webshop.services.AccountService;
        import nl.hu.iac.webshop.services.BestellingService;
        import nl.hu.iac.webshop.services.ProductService;
        import org.springframework.web.bind.annotation.*;

        import javax.ws.rs.Path;

@RestController
@RequestMapping(AccountController.BASE_URL)
public class AccountController {
    static final String BASE_URL = "/api/account";
    private final AccountService accountService;


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

// yo niek ik weet niet wat hier mee moet gebeuren dan want deze shit is niet zzoals die getmapping
//    public Klant getKlant( Long id){
//        Account account = accountService.getAccountById(id);
//        return account.getKlant();
//    }
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @PostMapping
    public Account addAccount(@RequestBody AccountDTO accountDTO){
            Account account = new Account();
            account.setUsername(accountDTO.getUsername());
            account.setPassword(accountDTO.getPassword());
            account.setKlant(accountDTO.getKlant());
            account.setOpenDatum(accountDTO.getOpenDatum());
            return accountService.saveAccount(account);
    }

    @GetMapping("/delete/{id}")
    public void deleteAccount(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        accountService.deleteAccount(account);
    }

    @GetMapping("/klant/{id}")
    public Klant getKlant(@PathVariable Long id){
        return accountService.getKlantById(id);
    }

    @GetMapping("/adres/{id}")
    public Adres getAdres(@PathVariable Long id){
        return accountService.getAdresById(id);
    }
}
