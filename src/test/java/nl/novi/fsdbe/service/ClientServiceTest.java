package nl.novi.fsdbe.service;

import nl.novi.fsdbe.model.Client;
import nl.novi.fsdbe.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {
    @Mock
    ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    private Client client1;
    private Client client2;
    private Client client3;
    private List<Client> clientList;

    @BeforeEach
    public void setup() {
        this.client1 = new Client();
        this.client2 = new Client();
        this.client3 = new Client();

        client1.setId(123L);
        client1.setLastName("Jansen");

        client2.setFirstName("Mark");
        client2.setLastName("De Vries");
        client2.setRoomNumber("123");

        client3.setSeeOwnMedication(true);

        this.clientList = new ArrayList<>();
        clientList.add(client1);
        clientList.add(client2);
        clientList.add(client3);
    }

    @Test
    @DisplayName("Should return client2 & client3 details")
    public void shouldReturnClient2Arguments() {
        assertEquals("Mark",client2.getFirstName());
        assertEquals("De Vries", client2.getLastName());
        assertEquals("123", client2.getRoomNumber());
        assertTrue(client3.isSeeOwnMedication());
    }


    @Test
    @DisplayName("Should find 3 clients, first lastname Jansen")
    void getClients() {

        when(clientRepository.findAll()).thenReturn(clientList);

        clientService.getClients();

        verify(clientRepository, times(1)).findAll();
        assertThat(clientList.size()).isEqualTo(3);
        assertThat(clientList.get(0).getLastName()).isEqualTo("Jansen");
    }

    @Test
    @DisplayName("Should save client1 with ID 123L")
    public void shouldSaveClients() {
        given(clientRepository.findById(123L)).willReturn(Optional.of(client1));
        Client savedClient = clientService.getClient(client1.getId());
        assertThat(savedClient).isNotNull();
        assertThat(savedClient.getId()).isEqualTo(client1.getId());
    }

}