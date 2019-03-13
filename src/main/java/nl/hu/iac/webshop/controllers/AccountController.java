package nl.hu.iac.webshop.controllers;
        import nl.hu.iac.webshop.DTO.AccountKlantDTO;
        import nl.hu.iac.webshop.domain.*;
        import nl.hu.iac.webshop.services.AccountService;
        import org.springframework.web.bind.annotation.*;

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
    public Account addAccount(@RequestBody AccountKlantDTO accountKlantDTO){
            Account account = new Account();
            Klant klant = new Klant();
            Adres adres = new Adres();
            account.setUsername(accountKlantDTO.getAccountUsername());
            account.setPassword(accountKlantDTO.getAccountPassword());
            account.setOpenDatum(accountKlantDTO.getAccountOpenDatum());

            adres.setStraat(accountKlantDTO.getAdresStraat());
            adres.setStraatNummer(accountKlantDTO.getAdresStraatNummer());

            klant.setNaam(accountKlantDTO.getKlantNaam());
            klant.setAfbeelding(accountKlantDTO.getKlantAfbeelding());



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
