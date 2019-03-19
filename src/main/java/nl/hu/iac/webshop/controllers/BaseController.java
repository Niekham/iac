package nl.hu.iac.webshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class BaseController{
        @GetMapping("/")
        public String homePage() {
            return "Index";
        }
}
