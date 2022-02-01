package nl.novi.fsdbe.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {

    @Test
    @DisplayName("Geeft De Vries terug als lastName")
    public void setClientFirstNameEqualsGetClientFirstName() {
        Client client = new Client();
        client.setLastName("De Vries");
        assertEquals("De Vries", client.getLastName());
    }
}
