package nl.novi.fsdbe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MedPlanApplicationTest {

    @Test
    @DisplayName("Testing if context is correctly set")
    void contextLoads(ApplicationContext context) {
        assertNotNull(context);
    }

}