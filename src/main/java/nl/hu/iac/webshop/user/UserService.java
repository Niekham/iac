package nl.hu.iac.webshop.user;

import nl.hu.iac.webshop.DTO.RegistreerDTO;
import nl.hu.iac.webshop.domain.*;
import nl.hu.iac.webshop.repositories.AccountRepository;
import nl.hu.iac.webshop.repositories.AdresRepository;
import nl.hu.iac.webshop.repositories.KlantRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
@Service
public class UserService implements UserServiceInterface {
    private final AccountRepository accountRepository;
    private final AdresRepository adresRepository;
    private final KlantRepository klantRepository;


    public UserService(AccountRepository accountRepository, AdresRepository adresRepository, KlantRepository klantRepository, BCryptPasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.adresRepository = adresRepository;
        this.klantRepository = klantRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public void save(RegistreerDTO registreerDTO) {
        Account account = new Account();
        Adres adres = new Adres();
        Klant klant = new Klant();

        account.setUsername(registreerDTO.getUsername());
        account.setPassword(passwordEncoder.encode(registreerDTO.getPassword()));
        account.setRollen(Arrays.asList(new Role("ROLE_USER")));

        adres.setPlaats(registreerDTO.getPlaats());
        adres.setPostcode(registreerDTO.getPostcode());
        adres.setStraat(registreerDTO.getStraat());

        klant.setEmail(registreerDTO.getEmail());
        klant.setNaam(registreerDTO.getNaam());

        accountRepository.save(account);
        adresRepository.save(adres);
        account.setKlant(klant);
        adres.setKlant(klant);
        klant.setAccount(account);
        klant.setAdres(adres);
        klantRepository.save(klant);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Verkeerde inloggegevens.");
        }
        return new org.springframework.security.core.userdetails.User(account.getUsername(),
                account.getPassword(),
                mapRolesToAuthorities(account.getRollen()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> rollen) {
        return rollen.stream()
                .map(Role -> new SimpleGrantedAuthority(Role.getName()))
                        .collect(Collectors.toList());
    }


}
