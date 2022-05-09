package nl.novi.fsdbe.service;

import nl.novi.fsdbe.model.Medicine;
import nl.novi.fsdbe.repository.MedicineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaTypeEditor;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MedicineServiceTest {

    @Mock
    private MedicineRepository medicineRepository;

    @InjectMocks
    private MedicineService medicineService;

    private Medicine medicine;

    @BeforeEach
    public void setup() {
        this.medicine = new Medicine();
        medicine.setId(123L);
        medicine.setMedName("Paracetamol");
    }

    @Test
    @DisplayName("Should return provided medicine name")
    void shouldReturnMedicineName() {
        assertEquals("Paracetamol", medicine.getMedName());
    }

    @Test
    @DisplayName("Should save Medicine")
    public void givenMedicineObject_whenSaveMedicine_thenReturnMedicineObject() {

        given(medicineRepository.save(medicine)).willReturn(medicine);

        Long savedMedicine = medicineService.addMedicine(medicine);

        assertThat(savedMedicine).isNotNull();
    }

    @Test
    @DisplayName("Should return medicine by ID")
    public void givenMedicineId_thenReturnMedicineObject() {
        given(medicineRepository.findById(123L)).willReturn(Optional.of(medicine));
        Medicine savedMedicine = medicineService.getMedicine(medicine.getId());
        assertThat(savedMedicine).isNotNull();
    }

    @Test
    @DisplayName("Should update medicine")
    public void givenMedicineObject_whenUpdate_thenReturnUpdatedMedicine() {
        given(medicineRepository.save(medicine)).willReturn(medicine);

        medicine.setMedName("Updated");
//        System.out.println(medicine.getMedName());
        System.out.println(medicine.getId());

//        Medicine updatedMedicine = medicineService.updateMedicine(medicine.getId(), medicine);


//        assertThat(updatedMedicine.getMedName()).isEqualTo("Updated");
    }

}