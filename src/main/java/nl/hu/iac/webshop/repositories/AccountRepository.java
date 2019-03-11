package nl.hu.iac.webshop.repositories;

import nl.hu.iac.webshop.domain.Account;
import nl.hu.iac.webshop.domain.Klant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
