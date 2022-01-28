package nl.novi.fsdbe.service;

import nl.novi.fsdbe.exception.RecordNotFoundException;
import nl.novi.fsdbe.model.Client;
import nl.novi.fsdbe.model.Medicine;
import nl.novi.fsdbe.model.Planning;
import nl.novi.fsdbe.repository.ClientRepository;
import nl.novi.fsdbe.repository.MedicineRepository;
import nl.novi.fsdbe.repository.PlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientPlanningService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PlanningRepository planningRepository;

    public void addClientPlanning(Long clientId, Long planningId) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        Optional<Planning> optionalPlanning = planningRepository.findById(planningId);

        if (optionalClient.isPresent() && optionalPlanning.isPresent()) {
            Client client = optionalClient.get();
            Planning planning = optionalPlanning.get();
            planning.setClient(client);
            List<Planning> plannings = client.getPlannings();
            plannings.add(planning);
            planningRepository.save(planning);
        }
        else {
            throw new RecordNotFoundException("ID does not exist!");
        }
    }


}
