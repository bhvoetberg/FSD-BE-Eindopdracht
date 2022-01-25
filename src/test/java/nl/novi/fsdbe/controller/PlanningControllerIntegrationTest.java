package nl.novi.fsdbe.controller;

import nl.novi.fsdbe.model.Planning;
import nl.novi.fsdbe.security.JwtUtil;
import nl.novi.fsdbe.service.*;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration
@EnableConfigurationProperties
@WithMockUser(username = "admin", roles = {"ADMIN"})
public class PlanningControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MedicineService medicineService;

    @MockBean
    private UserAuthenticateService userAuthenticateService;

    @MockBean
    private ClientService clientService;

    @MockBean
    private ClientPlanningService clientPlanningService;

    @MockBean
    private DeviationService deviationService;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private MedicinePlanningService medicinePlanningService;

    @MockBean
    private PlanningService planningService;

    @MockBean
    private UserService userService;

    @MockBean
    DataSource dataSource;

    @MockBean
    JwtUtil jwtUtil;


    @Test
    public void testEndpointMedicines() throws Exception {
        Planning planning = new Planning();
        planning.setEnabled(true);
        List<Planning> allPlanning = Arrays.asList(planning);

        BDDMockito.given(planningService.getPlanning()).willReturn(allPlanning);

        mvc.perform(get("/planning")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
//                    .andExpect(jsonPath("$[0].medName", is(medicine.getMedName())));
    }
}
