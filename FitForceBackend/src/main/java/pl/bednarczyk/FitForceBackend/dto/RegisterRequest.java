package pl.bednarczyk.FitForceBackend.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterRequest {
    @JsonAlias({"name", "login", "userName"})
    @NotBlank(message = "Podaj nazwe uzytkownika")
    @Size(min = 3, max = 50, message = "Nazwa uzytkownika musi miec od 3 do 50 znakow")
    private String username;
    @NotBlank(message = "Podaj haslo")
    @Size(min = 8, max = 100, message = "Haslo musi miec od 8 do 100 znakow")
    private String password;
    @NotBlank(message = "Podaj adres e-mail")
    @Email(message = "Podaj poprawny adres e-mail")
    private String email;

    public RegisterRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
