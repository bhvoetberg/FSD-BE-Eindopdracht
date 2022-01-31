package nl.novi.fsdbe.end_to_end;

import nl.novi.fsdbe.MedPlanApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

    @SpringBootTest(classes = MedPlanApplication.class)
    @AutoConfigureMockMvc
    @EnableConfigurationProperties
    @WithMockUser(username = "admin", roles = {"ADMIN"})

    public class UserTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        void shouldReturn200() throws Exception {
            mockMvc.perform(get("/users"))
                    .andExpect(status().isOk());
        }

        @Test
        void shouldReturnJson() throws Exception {

            mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        }

        @Test
        void shouldReturnRecords() throws Exception {

            mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(5)))
                    .andExpect(jsonPath("$[1].username", startsWith("a")));
        }
    }

