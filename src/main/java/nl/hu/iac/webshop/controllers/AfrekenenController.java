package nl.hu.iac.webshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AfrekenenController{

    @GetMapping("/afrekenen")
    public String afrekenenPage() {
        return "afrekenen";
    }

    @GetMapping("/success")
    public String successPage() {
        return "afrekenenSuccess";
    }
}
