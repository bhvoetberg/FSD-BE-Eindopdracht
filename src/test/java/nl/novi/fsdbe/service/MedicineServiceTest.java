package nl.novi.fsdbe.service;

import nl.novi.fsdbe.model.Medicine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MedicineServiceTest {

    @Test
    @DisplayName("Should return a medicinename")
    void shouldReturnMedicineName() {
        Medicine medicine = new Medicine();
        medicine.setMedName("Paracetamol");
        assertEquals("Paracetamol",medicine.getMedName());
    }
}