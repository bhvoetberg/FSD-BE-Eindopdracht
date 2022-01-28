package nl.novi.fsdbe.service;

import nl.novi.fsdbe.exception.RecordNotFoundException;
import nl.novi.fsdbe.model.Client;
import nl.novi.fsdbe.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Iterable<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client getClient(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);

        if (optionalClient.isPresent()) {
            return optionalClient.get();
        } else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public void deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public void deleteClientPhoto(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client storedClient = clientRepository.findById(id).orElse(null);
            storedClient.setPhoto(null);
            clientRepository.save(storedClient);
            }
         else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public Long addClient(Client client) {
        Client newClient = clientRepository.save(client);
        return newClient.getId();
    }

    public void updateClient(Long id, Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);

        if (optionalClient.isPresent()) {
            Client storedClient = optionalClient.get();

            client.setId(storedClient.getId());
            clientRepository.save(client);
        } else {
            throw new RecordNotFoundException("ID does not exist!");
        }
    }

    public void partialUpdateClient(Long id, Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);

        if (optionalClient.isPresent()) {
            Client storedClient = clientRepository.findById(id).orElse(null);

            if (client.getFirstName() != null && !client.getFirstName().isEmpty()) {
                storedClient.setFirstName(client.getFirstName());
            }
            if (client.getLastName() != null && !client.getLastName().isEmpty()) {
                storedClient.setLastName(client.getLastName());
            }
            if (client.isEnabled() == true || client.isEnabled() == false ) {
                storedClient.setEnabled(client.isEnabled());
            }

            if (client.getDateOfBirth() != null && !client.getDateOfBirth().isEmpty()) {
                storedClient.setDateOfBirth(client.getDateOfBirth());
            }

            if (client.getRoomNumber() != null && !client.getRoomNumber().isEmpty()) {
                storedClient.setRoomNumber(client.getRoomNumber());
            }

            if (client.isSeeOwnMedication() == true || client.isSeeOwnMedication() == false ) {
                storedClient.setSeeOwnMedication(client.isSeeOwnMedication());
            }

            if (client.getTelGeneralPractitioner() != null && !client.getTelGeneralPractitioner().isEmpty()) {
                storedClient.setTelGeneralPractitioner(client.getTelGeneralPractitioner());
            }

            if (client.getTelPharmacy() != null && !client.getTelPharmacy().isEmpty()) {
                storedClient.setTelPharmacy(client.getTelPharmacy());
            }

            if (client.getPhoto() != null && !client.getPhoto().isEmpty()) {
                storedClient.setPhoto(client.getPhoto());
            }

            clientRepository.save(storedClient);
        } else {
            throw new RecordNotFoundException("No valid update data present!");
        }
    }

}
