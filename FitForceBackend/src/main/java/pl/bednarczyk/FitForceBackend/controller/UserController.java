package pl.bednarczyk.FitForceBackend.controller;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.bednarczyk.FitForceBackend.dto.UpdateProfileRequest;
import pl.bednarczyk.FitForceBackend.dto.UserResponse;
import pl.bednarczyk.FitForceBackend.exception.ConflictException;
import pl.bednarczyk.FitForceBackend.exception.NotFoundException;
import pl.bednarczyk.FitForceBackend.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserRepository users;
    public UserController(UserRepository users) { this.users = users; }

    @GetMapping("/me")
    UserResponse me(Authentication authentication) { return UserResponse.from(current(authentication)); }

    @PatchMapping("/me")
    UserResponse update(@Valid @RequestBody UpdateProfileRequest request, Authentication authentication) {
        var user = current(authentication);
        if (request.email() != null && !request.email().equalsIgnoreCase(user.getEmail()) && users.existsByEmail(request.email()))
            throw new ConflictException("Adres e-mail jest zajęty");
        if (request.email() != null) user.setEmail(request.email().toLowerCase());
        if (request.firstName() != null) user.setFirstName(request.firstName());
        if (request.lastName() != null) user.setLastName(request.lastName());
        if (request.phoneNumber() != null) user.setPhoneNumber(request.phoneNumber());
        if (request.city() != null) user.setCity(request.city());
        if (request.country() != null) user.setCountry(request.country());
        if (request.instagram() != null) user.setInstagram(request.instagram());
        return UserResponse.from(users.save(user));
    }

    private pl.bednarczyk.FitForceBackend.entity.User current(Authentication authentication) {
        var user = users.findByUsername(authentication.getName());
        if (user == null) throw new NotFoundException("Nie znaleziono użytkownika");
        return user;
    }
}
