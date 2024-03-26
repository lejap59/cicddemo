package com.studi.democicd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWolrdController {

    @GetMapping("/")
    public String Hello(@RequestParam(name="nom", required=false, defaultValue = "Vince")String nom) {
        return "Hello " + nom + ", bienvenue dans ce live demo CICD";
    }
}
