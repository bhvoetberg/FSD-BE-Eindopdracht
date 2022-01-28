package nl.novi.fsdbe.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorityTest {

    @Test
    public void setUsernameEqualsGetUsername() {
        Authority authority = new Authority();
        authority.setUsername("Frits");
        assertEquals("Frits", authority.getUsername());
    }

    @Test
    void setAuthorityEqualsGetAuthority() {
        Authority authority = new Authority();
        authority.setAuthority("ROLE_USER");
        assertEquals("ROLE_USER", authority.getAuthority());
    }
}