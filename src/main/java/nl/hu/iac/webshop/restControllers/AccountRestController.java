package nl.hu.iac.webshop.restControllers;
import nl.hu.iac.webshop.domain.Account;
import nl.hu.iac.webshop.domain.Adres;
import nl.hu.iac.webshop.domain.Klant;
import nl.hu.iac.webshop.services.AccountService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping(AccountRestController.BASE_URL)
public class AccountRestController {
    static final String BASE_URL = "/api/account";
    private final AccountService accountService;


    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    @ResponseBody
    public Klant currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return accountService.getAccountByUsername(principal.getName()).getKlant();
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id){
        return accountService.getAccountById(id);
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
