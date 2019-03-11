package nl.hu.iac.webshop.repositories;

import nl.hu.iac.webshop.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
