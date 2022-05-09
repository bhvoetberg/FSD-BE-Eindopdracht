package nl.novi.fsdbe.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanningTest {

    private Planning planning;

    @BeforeEach
    public void setup() {
        this.planning = new Planning();
        this.planning.setPlanDate("01-01-2022");
        this.planning.setPlanTime("10:00");
        this.planning.setEnabled(true);
        this.planning.setQuantity(5);
    }

    @Test
    void setQuantity() {
        assertEquals(5, planning.getQuantity());
    }

    @Test
    void setEnabled() {
        assertTrue(planning.isEnabled());
    }

    @Test
    void setPlanDate() {
        assertEquals("01-01-2022", planning.getPlanDate());
    }

    @Test
    void setPlanTime() {
        assertEquals("10:00", planning.getPlanTime());
    }

    @Test
    void setMedicine() {
        Medicine medicine = new Medicine();
        this.planning.setMedicine(medicine);
        assertEquals(medicine, planning.getMedicine());
    }

    @Test
    void setClient() {
        Client client = new Client();
        this.planning.setClient(client);
        assertEquals(client, planning.getClient());
    }
}