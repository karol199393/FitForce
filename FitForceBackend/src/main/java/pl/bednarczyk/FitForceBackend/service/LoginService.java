package pl.bednarczyk.FitForceBackend.service;


import org.springframework.stereotype.Service;
import pl.bednarczyk.FitForceBackend.entity.User;
import pl.bednarczyk.FitForceBackend.repository.UserRepository;

@Service
public class LoginService {
    public UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
