package nl.hu.iac.webshop.user;

import nl.hu.iac.webshop.DTO.RegistreerDTO;
import nl.hu.iac.webshop.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistreerController {

    private final UserServiceInterface userServiceInterface;

    public RegistreerController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @GetMapping("/registreren")
    public String registreerForm(Model model){
        return "registreren";
    }


    @ModelAttribute("registratie")
    public RegistreerDTO registreerDTO() {
        return new RegistreerDTO();
    }


    @PostMapping("registreren")
    public String registerUser(@ModelAttribute("registratie") @Valid RegistreerDTO registreerDTO,
                               BindingResult result) {
        Account existing = userServiceInterface.findByUsername(registreerDTO.getUsername());
        if (existing != null) {
            return "redirect:/registreren?exists";
        }

        if (result.hasErrors()) {
            return "redirect:/registreren?error";
        }
        userServiceInterface.save(registreerDTO);
        return "redirect:/registreren?success";
    }
}

