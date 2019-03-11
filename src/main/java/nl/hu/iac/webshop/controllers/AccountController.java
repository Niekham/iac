//package nl.hu.iac.webshop.controllers;
//        import nl.hu.iac.webshop.domain.*;
//        import nl.hu.iac.webshop.services.AccountService;
//        import org.springframework.stereotype.Controller;
//        import org.springframework.web.bind.annotation.*;
//
//        import java.util.ArrayList;
//        import java.util.List;
//
//@Controller(AccountController.BASE_URL)
//public class AccountController {
//    public static final String BASE_URL = "/api/account";
//    private final AccountService accountService;
//
//    public AccountController(AccountService accountService) {
//        this.accountService = accountService;
//    }
//
//    @GetMapping
//    public List<Account> getAccounts(){
//        return accountService.findAllAccounts();
//    }
//
//    public Klant getKlant(Long id){
//        Account account = accountService.getAccountById(id);
//        return account.getKlant();
//    }
//
//
//    @PutMapping("/{id}")
//    public void newOrder(@PathVariable Long accountId, @RequestBody Bestellingsregel bestellingsregel){
//        Account account = accountService.getAccountById(accountId);
//        List<Bestelling> bestellingen = account.getBestellingen();
//        Bestelling newBestelling = new Bestelling("open", account);
//
//        for (Bestelling bestelling : bestellingen){
//            if (!bestelling.getStatus().equals("open")){
//                bestellingen.add(newBestelling);
//                List<Bestellingsregel> bestellingsregels = new ArrayList<>();
//                bestellingsregels.add(bestellingsregel);
//                newBestelling.setBestellingsregels(bestellingsregels);
//            }else if (bestelling.getStatus().equals("open")){
//                List<Bestellingsregel> oldBestellingsregel =  bestelling.getBestellingsregels();
//                oldBestellingsregel.add(bestellingsregel);
//                bestelling.setBestellingsregels(oldBestellingsregel);
//            }
//        }
//    }
//
//}
