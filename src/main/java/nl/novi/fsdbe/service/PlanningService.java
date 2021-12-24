package nl.novi.fsdbe.service;

import nl.novi.fsdbe.exception.RecordNotFoundException;
import nl.novi.fsdbe.model.Employee;
import nl.novi.fsdbe.model.Planning;
import nl.novi.fsdbe.repository.PlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class PlanningService {

    @Autowired
    private PlanningRepository planningRepository;

    public Iterable<Planning> getPlanning() {
        return planningRepository.findAll();
    }

    public Planning getPlanning(Long id) {
        Optional<Planning> optionalPlanning = planningRepository.findById(id);

        if (optionalPlanning.isPresent()) {
            return optionalPlanning.get();
        } else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public void deletePlanning(Long id) {
        if (planningRepository.existsById(id)) {
            planningRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public Long addPlanning(Planning planning) {
        Planning newPlanning = planningRepository.save(planning);
        return newPlanning.getId();
    }

    public void updatePlanning(Long id, Planning planning) {
        Optional<Planning> optionalPlanning = planningRepository.findById(id);

        if (optionalPlanning.isPresent()) {
            Planning storedPlanning = optionalPlanning.get();

            planning.setId(storedPlanning.getId());
            planningRepository.save(planning);
        } else {
            throw new RecordNotFoundException("ID does not exist!");
        }
    }

    public void partialUpdatePlanning(Long id, Planning planning) {
        Optional<Planning> optionalPlanning = planningRepository.findById(id);

        if (optionalPlanning.isPresent()) {
            Planning storedPlanning = planningRepository.findById(id).orElse(null);
            System.out.println("ID is: " + storedPlanning.getId());
            System.out.println(planning.isEnabled());
            System.out.println(planning.getPlanDate());
            System.out.println(planning.getPlanTime());


            if (planning.getPlanDate() != null && !planning.getPlanDate().isEmpty()) {
                System.out.println("Hallo");
                storedPlanning.setPlanDate(planning.getPlanDate());
                System.out.println(storedPlanning.getPlanDate());
            }
            if (planning.getPlanTime() != null && !planning.getPlanTime().isEmpty()) {
                storedPlanning.setPlanTime(planning.getPlanTime());
            }
            if (planning.getMedName() != null && !planning.getMedName().isEmpty()) {
                storedPlanning.setMedName(planning.getMedName());
            }
            if (planning.getQuantity() != null) {
                storedPlanning.setQuantity(planning.getQuantity());
            }
            if (planning.isEnabled() == true || planning.isEnabled() == false ) {
                System.out.println("Planning " + planning.isEnabled());
                storedPlanning.setEnabled(planning.isEnabled());
            }
            planningRepository.save(storedPlanning);
        } else {
            throw new RecordNotFoundException("No valid update data present!");
        }

    }
}
