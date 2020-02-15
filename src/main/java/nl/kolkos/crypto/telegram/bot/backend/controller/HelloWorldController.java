package nl.kolkos.crypto.telegram.bot.backend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping({"/hello"})
    public String firstPage() {
        return "Hello World";
    }
}
