package pl.bednarczyk.FitForceBackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.bednarczyk.FitForceBackend.controller.TrainingsController;
import pl.bednarczyk.FitForceBackend.service.TrainingService;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//ToDo: Implement integrity tests for TrainingsController

@WebMvcTest(TrainingsController.class)
public class IntegrityTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TrainingService trainingsService;
    @Test
    public void getAllTrainings_ReturnsOk() throws Exception {
        mockMvc.perform(get("/trainings/getAllTrainings"))
                .andExpect(status().isOk());
        verify(trainingsService).getAllTrainings();
    }
    @Test
    public void getTrainingById_ReturnsOk() throws Exception {
        Long id = 1L;
        mockMvc.perform(get("/trainings/{id}", id))
                .andExpect(status().isOk());
        verify(trainingsService).getTrainingById(id);
    }


}
