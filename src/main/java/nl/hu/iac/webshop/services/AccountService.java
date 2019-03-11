package nl.hu.iac.webshop.services;

import nl.hu.iac.webshop.domain.Account;
import nl.hu.iac.webshop.exceptions.AccountNotFoundException;
import nl.hu.iac.webshop.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private static AccountRepository accountRepository;

    public Account getAccountById(Long id){
        return accountRepository.findById(id).orElseThrow(()-> new AccountNotFoundException(id));
    }

    public List<Account> findAllAccounts(){
        return accountRepository.findAll();
    }
}
