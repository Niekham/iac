package nl.hu.iac.webshop.restControllers;

import nl.hu.iac.webshop.domain.Account;
import nl.hu.iac.webshop.domain.Bestelling;
import nl.hu.iac.webshop.domain.Klant;
import nl.hu.iac.webshop.services.AccountService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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
    public Klant getUserDetails(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return accountService.getAccountByUsername(principal.getName()).getKlant();
    }

    @RequestMapping(value = "/alleKlanten", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Klant> getAllUsersDetails(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();

        if(principal == null) {
            return null;
        }

        Account account = accountService.getAccountByUsername(principal.getName());

        if(account == null) {
            return null;
        }

        if(account.isAdmin()) {
            return accountService.getAlleKlanten();
        }

        return null;
    }

    @RequestMapping(value = "/bestellingen", method = RequestMethod.GET)
    @ResponseBody
    public List<Bestelling> getUserBestellingen(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return accountService.getAccountByUsername(principal.getName()).getBestellingen();
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    @ResponseBody
    public String getUsername(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return accountService.getAccountByUsername(principal.getName()).getKlant().getNaam();
    }
}
