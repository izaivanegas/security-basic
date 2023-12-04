package com.example.security.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/index")
    public String home(){
        log.info("Estamos en index");

        return "index";
    }


}
