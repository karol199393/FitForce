package pl.bednarczyk.FitForceBackend.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bednarczyk.FitForceBackend.dto.*;
import pl.bednarczyk.FitForceBackend.entity.User;
import pl.bednarczyk.FitForceBackend.exception.ConflictException;
import pl.bednarczyk.FitForceBackend.repository.UserRepository;
import pl.bednarczyk.FitForceBackend.security.JwtService;

@Service
public class AuthService {
    private final UserRepository users;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwt;

    public AuthService(UserRepository users, PasswordEncoder encoder, AuthenticationManager authenticationManager, JwtService jwt) {
        this.users = users; this.encoder = encoder; this.authenticationManager = authenticationManager; this.jwt = jwt;
    }

    @Transactional
    public AuthResponse register(RegisterRequest request) {
        if (users.existsByUsername(request.getUsername())) throw new ConflictException("Nazwa użytkownika jest zajęta");
        if (users.existsByEmail(request.getEmail())) throw new ConflictException("Adres e-mail jest zajęty");
        User user = new User();
        user.setUsername(request.getUsername().trim());
        user.setEmail(request.getEmail().trim().toLowerCase());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole("USER");
        user = users.save(user);
        return new AuthResponse(jwt.generate(user.getUsername()), UserResponse.from(user));
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        User user = users.findByUsername(request.username());
        return new AuthResponse(jwt.generate(user.getUsername()), UserResponse.from(user));
    }
}
