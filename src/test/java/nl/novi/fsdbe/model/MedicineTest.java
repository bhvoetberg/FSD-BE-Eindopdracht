package nl.novi.fsdbe.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicineTest {

    private Medicine medicine;

    @BeforeEach
    public void setup() {
        this.medicine = new Medicine();
        this.medicine.setMedName("Paracetamol");
        this.medicine.setInstructions("Geen instructies");
        this.medicine.setPerilous(true);
        this.medicine.setUrlExternalInfo("www.google.com");
        this.medicine.setDosageForm("Tablet");
    }

    @Test
    void getMedName() {
        assertEquals("Paracetamol", medicine.getMedName());
    }

    @Test
    void isPerilous() {
        assertTrue(medicine.isPerilous());
    }

    @Test
    void getUrlExternalInfo() {
        assertEquals("www.google.com", medicine.getUrlExternalInfo());
    }

    @Test
    void getDosageForm() {
        assertEquals("Tablet", medicine.getDosageForm());
    }

    @Test
    void getInstructions() {
        assertEquals("Geen instructies", medicine.getInstructions());
    }
}