package pl.bednarczyk.FitForceBackend.unitTest;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.bednarczyk.FitForceBackend.controller.RegisterController;
import pl.bednarczyk.FitForceBackend.dto.RegisterRequest;
import pl.bednarczyk.FitForceBackend.service.RegisterService;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RegisterController.class)
public class RegisterControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RegisterService registerService;



@Test
public void testRegisterUser() throws Exception {
    RegisterRequest newUser = new RegisterRequest("testUser", "testPassword", "test@Email");
    when(registerService.registerUser(newUser)).thenReturn(newUser);

    mockMvc.perform(post("/api/v1/register")
                    .with(csrf())
                    .with(user("username").password("password"))
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{ \"username\": \"testUser\", \"password\": \"testPassword\", \"email\": \"test@Email\" }"))
            .andExpect(status().isCreated());
}
    @Test
    public void testRegisterUserWithInvalidData() throws Exception {
        // Nie próbujemy rzucać wyjątku, tylko oczekujemy statusu BadRequest
        mockMvc.perform(post("/api/v1/register")
                        .with(csrf())
                        .with(user("username").password("password"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"username\": \"\", \"password\": \"\", \"email\": \"\" }"))
                .andExpect(status().isBadRequest());
    }

}
