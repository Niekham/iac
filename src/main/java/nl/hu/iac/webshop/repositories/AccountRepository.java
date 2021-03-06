package nl.hu.iac.webshop.repositories;

import nl.hu.iac.webshop.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
    Account findAccountByUsernameAndPassword(String user,String pass);
}
