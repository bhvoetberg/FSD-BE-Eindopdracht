package nl.novi.fsdbe.dto.request;

import nl.novi.fsdbe.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationRequestTest {

    private User user;

    @BeforeEach
    public void setup() {
        this.user = new User();
    }

    @Test
    void setUsernameEqualsGetClientFirstName() {
        user.setUsername("Test_user");
        assertEquals("Test_user", user.getUsername());
    }

}