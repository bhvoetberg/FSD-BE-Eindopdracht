//package nl.novi.fsdbe.integrationTests;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.core.StringContains.containsString;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest(classes = LibraryApplication.class)
//@AutoConfigureMockMvc
//@EnableConfigurationProperties
////@WithMockUser(username = "admin", roles = {"ADMIN"})
//public class IntegrationTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    void shouldReturn200ForEndpointBase() throws Exception {
//        mockMvc.perform(get("/api/v1").with(user("user").roles("USER")))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
//                .andExpect(content().string(containsString("Welcome")));
//
//    }
//
//}