package nl.novi.fsdbe.service;

import nl.novi.fsdbe.model.Client;
import nl.novi.fsdbe.repository.ClientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {
    @Mock
    ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

//    @Captor
//    ArgumentCaptor<Client> argumentCaptor;

    @Test
    @DisplayName("Should find 3 clients, 1 lastname Jansen")
    void getClients() {
        List<Client> clientList = new ArrayList<>();
        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        client1.setLastName("Jansen");
        client2.setLastName("De Vries");
        client3.setLastName("Boer");
        clientList.add(client1);
        clientList.add(client2);
        clientList.add(client3);

        when(clientRepository.findAll()).thenReturn(clientList);

        clientService.getClients();

        verify(clientRepository, times(1)).findAll();
        assertThat(clientList.size()).isEqualTo(3);
        assertThat(clientList.get(0).getLastName()).isEqualTo("Jansen");
    }

    @Test
    public void shouldSaveNewClient() {
        Client client = new Client();

    }

}