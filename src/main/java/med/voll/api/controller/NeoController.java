package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/neo")
public class NeoController {

    @GetMapping
    public String neo(){
        return "Another brick in the wall";
    }
}
