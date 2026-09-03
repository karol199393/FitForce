package pl.bednarczyk.FitForceBackend.dto;

import pl.bednarczyk.FitForceBackend.entity.User;

public record UserResponse(Long id, String username, String email, String role,
                           String firstName, String lastName, String phoneNumber,
                           String city, String country, String instagram) {
    public static UserResponse from(User user) {
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getRole(),
                user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getCity(),
                user.getCountry(), user.getInstagram());
    }
}
