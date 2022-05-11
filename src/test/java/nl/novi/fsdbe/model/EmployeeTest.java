package nl.novi.fsdbe.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private User user;

    @BeforeEach
    public void setup() {
        this.user = new User();
    }

    @Test
    @DisplayName("Should set username to Testuser")
    public void setUserName() {
        user.setUsername("Testuser");
        assertEquals("Testuser", user.getUsername());
    }

}