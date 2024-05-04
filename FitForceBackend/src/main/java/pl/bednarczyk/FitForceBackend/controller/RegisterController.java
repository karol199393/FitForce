package pl.bednarczyk.FitForceBackend.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bednarczyk.FitForceBackend.dto.RegisterRequest;
import pl.bednarczyk.FitForceBackend.entity.User;
import pl.bednarczyk.FitForceBackend.service.RegisterService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterController {
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterRequest registerRequest) {
        User registeredUser = registerService.registerUser(registerRequest);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

}
