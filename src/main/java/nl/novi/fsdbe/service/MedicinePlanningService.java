package nl.novi.fsdbe.service;

import nl.novi.fsdbe.exception.RecordNotFoundException;
import nl.novi.fsdbe.model.Medicine;
import nl.novi.fsdbe.model.Planning;
import nl.novi.fsdbe.repository.MedicineRepository;
import nl.novi.fsdbe.repository.PlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicinePlanningService {

    @Autowired
    MedicineRepository medicineRepository;

    @Autowired
    private PlanningRepository planningRepository;

    public void addMedicinePlanning(Long medicineId, Planning planning) {
        Optional<Medicine> optionalMedicine = medicineRepository.findById(medicineId);

        if (optionalMedicine.isPresent()) {
            Medicine medicine = optionalMedicine.get();
            planning.setMedicine(medicine);
            List<Planning> plannings = medicine.getPlannings();
            plannings.add(planning);
            planningRepository.save(planning);
        }
        else {
            throw new RecordNotFoundException("ID does not exist!");
        }
    }

}
