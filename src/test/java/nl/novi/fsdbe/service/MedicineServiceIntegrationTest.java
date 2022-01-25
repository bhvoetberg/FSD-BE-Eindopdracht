package nl.novi.fsdbe.service;

import nl.novi.fsdbe.model.Medicine;
import nl.novi.fsdbe.repository.MedicineRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class MedicineServiceIntegrationTest {

    @Autowired
    private MedicineService medicineService;

    @MockBean
    private MedicineRepository medicineRepository;

    @Mock
    Medicine medicine;

//    @Test
//    public void simpleReturnBehaviour() {
//        // given
//        Medicine medicineMock = Mockito.mock(Medicine.class);
//        when(medicineMock.setMedName()).thenReturn(true);
//
//        // when
//        medicineMock.setPerilous(true);
//
//        // then
//        assertTrue(medicineMock.isPerilous());
//    }

}
