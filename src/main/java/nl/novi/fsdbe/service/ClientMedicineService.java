package nl.novi.fsdbe.service;

import nl.novi.fsdbe.exception.RecordNotFoundException;
import nl.novi.fsdbe.model.Client;
import nl.novi.fsdbe.model.Medicine;
import nl.novi.fsdbe.repository.ClientRepository;
import nl.novi.fsdbe.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientMedicineService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    public void addClientMedicine(Long clientId, Long medicineId) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        Optional<Medicine> optionalMedicine = medicineRepository.findById(medicineId);

        if (optionalClient.isPresent() && optionalMedicine.isPresent()) {
            Client client = optionalClient.get();
            Medicine medicine = optionalMedicine.get();
            medicine.setClient(client);
            List<Medicine> medicines = client.getMedicines();
            medicines.add(medicine);
            medicineRepository.save(medicine);
        }
        else {
            throw new RecordNotFoundException("ID does not exist!");
        }
    }


}
