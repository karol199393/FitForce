package pl.bednarczyk.FitForceBackend.service;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import pl.bednarczyk.FitForceBackend.entity.User;
import pl.bednarczyk.FitForceBackend.exception.NotFoundException;
import pl.bednarczyk.FitForceBackend.repository.UserRepository;
@Service
public class CurrentUserService {
    private final UserRepository users;
    public CurrentUserService(UserRepository users) { this.users = users; }
    public User require(Authentication authentication) {
        User user = users.findByUsername(authentication.getName());
        if (user == null) throw new NotFoundException("Nie znaleziono użytkownika");
        return user;
    }
}
