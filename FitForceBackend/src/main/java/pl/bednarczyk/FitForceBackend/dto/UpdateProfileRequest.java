package pl.bednarczyk.FitForceBackend.dto;

import jakarta.validation.constraints.Email;

public record UpdateProfileRequest(@Email String email, String firstName, String lastName,
                                   String phoneNumber, String city, String country, String instagram) {}
