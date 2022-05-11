package nl.novi.fsdbe.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    private User user;

    @BeforeEach
    public void setup() {
        this.user = new User();
    }

    @Test
    @DisplayName("Geeft user terug als username")
    public void setUsernameEqualsGetUsername() {
        user.setUsername("user");
        assertEquals("user", user.getUsername());
    }

    @Test
    void setPassword() {
        user.setPassword("P@ssw0rd");
        assertEquals("P@ssw0rd", user.getPassword());
    }


    @Test
    void setEnabled() {
        user.setEnabled(true);
        assertTrue(user.isEnabled());
    }

    @Test
    void setEmail() {
       user.setEmail("test@test.com");
       assertEquals("test@test.com", user.getEmail());
    }

}
