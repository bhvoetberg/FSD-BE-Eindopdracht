package nl.novi.fsdbe.controller;

import nl.novi.fsdbe.model.Deviation;
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
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@ContextConfiguration
@EnableConfigurationProperties
@WithMockUser(username = "user")
public class DeviationControllerIntegrationTest {

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
    public void testEndpointDeviations() throws Exception {
        Deviation deviation = new Deviation();
        deviation.setResolution("Opgelost");
        deviation.setFinding("Dat ging niet OK");
        deviation.setEnabled(true);
        List<Deviation> allDeviations = List.of(deviation);

        BDDMockito.given(deviationService.getDeviations()).willReturn(allDeviations);

        mvc.perform(get("/deviations")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].finding", is(deviation.getFinding())))
                .andExpect(jsonPath("$[0].enabled", is(deviation.isEnabled())))
                .andExpect(jsonPath("$[0].resolution", is(deviation.getResolution())));
    }
}


