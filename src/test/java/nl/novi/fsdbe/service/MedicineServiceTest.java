package nl.novi.fsdbe.service;

import nl.novi.fsdbe.model.Medicine;
import nl.novi.fsdbe.repository.MedicineRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MedicineServiceTest {

    @Mock
    private MedicineRepository medicineRepository;
    private MedicineService underTestMedicineService;

    @Test
    @DisplayName("Should return provided medicine name")
    void shouldReturnMedicineName() {
        Medicine medicine = new Medicine();
        medicine.setMedName("Paracetamol");
        assertEquals("Paracetamol", medicine.getMedName());
    }

}