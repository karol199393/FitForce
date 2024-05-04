package pl.bednarczyk.FitForceBackend.service;


import org.springframework.stereotype.Service;
import pl.bednarczyk.FitForceBackend.dto.RegisterRequest;
import pl.bednarczyk.FitForceBackend.entity.User;
import pl.bednarczyk.FitForceBackend.repository.UserRepository;

import java.util.Optional;

@Service
public class RegisterService {
    public UserRepository userRepository;

    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public User registerUser(RegisterRequest registerRequest) {
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByUsername(registerRequest.getUsername()));
        if (existingUser.isPresent()) {
            throw new RuntimeException("User already exists");
        }
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());
        return userRepository.save(user);
    }


}
