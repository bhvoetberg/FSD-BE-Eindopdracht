package nl.novi.fsdbe.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {

    @Test
    public void setClientFirstNameEqualsGetClientFirstName() {
        Client client = new Client();
        client.setFirstName("De Vries");
        assertEquals("De Vries", client.getFirstName());
    }
}
