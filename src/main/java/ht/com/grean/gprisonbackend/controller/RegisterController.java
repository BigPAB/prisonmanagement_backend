package ht.com.grean.gprisonbackend.controller;

import ht.com.grean.gprisonbackend.model.Gestionneur;
import ht.com.grean.gprisonbackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserService service;

    public RegisterController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> registerUser (@RequestBody Gestionneur user) {

        try {
            return new ResponseEntity(service.saveUser(user), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
