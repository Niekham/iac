package nl.hu.iac.webshop.restControllers;
        import nl.hu.iac.webshop.DTO.AccountKlantDTO;
        import nl.hu.iac.webshop.DTO.InlogDTO;
        import nl.hu.iac.webshop.domain.*;
        import nl.hu.iac.webshop.services.AccountService;
        import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(AccountRestController.BASE_URL)
public class AccountRestController {
    static final String BASE_URL = "/api/account";
    private final AccountService accountService;


    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @PostMapping
    public void addAccount(@RequestBody AccountKlantDTO accountKlantDTO){
            Account account = new Account();
            Klant klant = new Klant();
            Adres adres = new Adres();
            account.setUsername(accountKlantDTO.getUsername());
            account.setPassword(accountKlantDTO.getPassword());

            adres.setStraat(accountKlantDTO.getStraat());
            adres.setPostcode(accountKlantDTO.getPostcode());
            adres.setPlaats(accountKlantDTO.getPlaats());

            klant.setNaam(accountKlantDTO.getNaam());
            klant.setEmail(accountKlantDTO.getEmail());

            accountService.saveAccount(account, klant, adres);
    }

    @PostMapping("/login")
    public Long accountLogin(@RequestBody InlogDTO inlogDTO){
        Account account = accountService.getAccount(inlogDTO.getUsername(), inlogDTO.getPassword());
        return account.getId();
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
