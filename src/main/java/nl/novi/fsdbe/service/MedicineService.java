package nl.novi.fsdbe.service;

import nl.novi.fsdbe.exception.RecordNotFoundException;
import nl.novi.fsdbe.model.Medicine;
import nl.novi.fsdbe.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    public Iterable<Medicine> getMedicines() {
        return medicineRepository.findAll();
    }

    public Medicine getMedicine(Long id) {
        Optional<Medicine> optionalMedicine = medicineRepository.findById(id);
        if (optionalMedicine.isPresent()) {
            return optionalMedicine.get();
        } else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public void deleteMedicine(Long id) {
        if (medicineRepository.existsById(id)) {
            medicineRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public Long addMedicine(Medicine medicine) {
        Medicine newMedicine = medicineRepository.save(medicine);
        return newMedicine.getId();
    }

    public void updateMedicine(Long id, Medicine medicine) {
        Optional<Medicine> optionalMedicine = medicineRepository.findById(id);

        if (optionalMedicine.isPresent()) {
            Medicine storedMedicine = optionalMedicine.get();

            medicine.setId(storedMedicine.getId());
            medicineRepository.save(medicine);
        }
        else {
            throw new RecordNotFoundException("ID does not exist!");
        }
    }

    public void partialUpdateMedicine(Long id, Medicine medicine) {
        Optional<Medicine> optionalMedicine = medicineRepository.findById(id);

        if (optionalMedicine.isPresent()) {
            Medicine storedMedicine = medicineRepository.findById(id).orElse(null);

            if (medicine.getMedName() != null && !medicine.getMedName().isEmpty()) {
                storedMedicine.setMedName(medicine.getMedName());
            }
            if (medicine.getAdministerMethod() != null && !medicine.getAdministerMethod().isEmpty()) {
                storedMedicine.setAdministerMethod(medicine.getAdministerMethod());
            }
            if (medicine.getDosageForm() != null && !medicine.getDosageForm().isEmpty()) {
                storedMedicine.setDosageForm(medicine.getDosageForm());
            }
            if (medicine.getInstructions() != null && !medicine.getInstructions().isEmpty()) {
                storedMedicine.setInstructions(medicine.getInstructions());
            }
            if (medicine.getUrlExternalInfo() != null && !medicine.getUrlExternalInfo().isEmpty()) {
                storedMedicine.setUrlExternalInfo(medicine.getUrlExternalInfo());
            }
            if (medicine.isPerilous() == true  || medicine.isPerilous() == false) {
                storedMedicine.setPerilous(medicine.isPerilous());
            }

            medicineRepository.save(storedMedicine);
        } else {
            throw new RecordNotFoundException("ID does not exist!");
        }
    }

}
