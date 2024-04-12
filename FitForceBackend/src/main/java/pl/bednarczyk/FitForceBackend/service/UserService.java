package pl.bednarczyk.FitForceBackend.service;

import org.springframework.stereotype.Service;
import pl.bednarczyk.FitForceBackend.entity.User;
import pl.bednarczyk.FitForceBackend.repository.UserRepository;

    @Service
    public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User addUser(User user) {
        return userRepository.save(user);
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public Object getAllUsers() {
        return userRepository.findAll();
    }
    public User updateUser(Long id, User userDetails) {
        return userRepository.save(userDetails);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
