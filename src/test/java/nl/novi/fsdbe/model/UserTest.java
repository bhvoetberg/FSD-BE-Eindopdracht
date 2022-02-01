package nl.novi.fsdbe.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    @DisplayName("Geeft user terug als username")
    public void setUsernameEqualsGetUsername() {
        User user = new User();
        user.setUsername("user");
        assertEquals("user", user.getUsername());
    }
}
