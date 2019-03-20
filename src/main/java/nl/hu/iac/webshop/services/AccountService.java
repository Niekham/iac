package nl.hu.iac.webshop.services;

import nl.hu.iac.webshop.domain.Account;
import nl.hu.iac.webshop.domain.Adres;
import nl.hu.iac.webshop.domain.Klant;
import nl.hu.iac.webshop.exceptions.AccountNotFoundException;
import nl.hu.iac.webshop.exceptions.AdresNotFoundException;
import nl.hu.iac.webshop.exceptions.KlantNotFoundException;
import nl.hu.iac.webshop.repositories.AccountRepository;
import nl.hu.iac.webshop.repositories.AdresRepository;
import nl.hu.iac.webshop.repositories.KlantRepository;
import org.springframework.stereotype.Service;



@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final KlantRepository klantRepository;
    private final AdresRepository adresRepository;

    public AccountService(AccountRepository accountRepository, KlantRepository klantRepository , AdresRepository adresRepository) {
        this.accountRepository = accountRepository;
        this.klantRepository =klantRepository;
        this.adresRepository = adresRepository;
    }

    public Account getAccountById(Long id){
        return accountRepository.findById(id).orElseThrow(()-> new AccountNotFoundException(id));
    }

    public Account getAccountByUsername(String user) {
        Account account = accountRepository.findByUsername(user);
        if(account == null) {
            throw new AccountNotFoundException(user);
        }
        return account;

    }

//    public void saveAccount(Account account, Klant klant, Adres adres){
//        account.setKlant(klant);
//        adres.setKlant(klant);
//        accountRepository.save(account);
//        adresRepository.save(adres);
//        klant.setAccount(account);
//        klant.setAdres(adres);
//        klantRepository.save(klant);
//    }


    public void deleteAccount(Account account) {
        accountRepository.delete(account);
    }

    public Klant getKlantById(Long id){
        return klantRepository.findById(id).orElseThrow(()-> new KlantNotFoundException(id));
    }

    public Adres getAdresById(Long id) {
        return adresRepository.findById(id).orElseThrow(() -> new AdresNotFoundException(id));
    }

    public Account getAccount(String username, String password){
        return accountRepository.findAccountByUsernameAndPassword(username, password);
    }

}
