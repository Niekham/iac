package nl.hu.iac.webshop.user;

import nl.hu.iac.webshop.DTO.RegistreerDTO;
import nl.hu.iac.webshop.domain.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceInterface extends UserDetailsService {

    Account findByUsername(String username);

    void save(RegistreerDTO registreerDTO);

}
