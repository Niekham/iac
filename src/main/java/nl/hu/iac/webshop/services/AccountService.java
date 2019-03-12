package nl.hu.iac.webshop.services;

import nl.hu.iac.webshop.domain.Account;
import nl.hu.iac.webshop.exceptions.AccountNotFoundException;
import nl.hu.iac.webshop.repositories.AccountRepository;
import org.springframework.stereotype.Service;



@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccountById(Long id){
        return accountRepository.findById(id).orElseThrow(()-> new AccountNotFoundException(id));
    }

 }
