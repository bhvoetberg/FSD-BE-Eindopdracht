package nl.novi.fsdbe.service;

import nl.novi.fsdbe.model.Deviation;
import nl.novi.fsdbe.repository.DeviationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeviationServiceTest {

    @Mock
    DeviationRepository deviationRepository;

    @InjectMocks
    private DeviationService deviationService;

    private final List<Deviation> deviationList = new ArrayList<>();

    @BeforeEach
    public void setup() {
        Deviation deviation1 = new Deviation();
        Deviation deviation2 = new Deviation();

        deviation1.setFinding("Finding1");
        deviation1.setResolution("Resolution1");
        deviation2.setFinding("Finding2");
        deviation2.setResolution("Resolution2");

        this.deviationList.add(deviation1);
        this.deviationList.add(deviation2);
    }

    @Test
    @DisplayName("Should return list of deviations of which second with resolution name 'Resolution2'")
    public void shouldReturnListOf2Deviations() {
        when(deviationRepository.findAll()).thenReturn(deviationList);

        deviationService.getDeviations();

        verify(deviationRepository, times(1)).findAll();
        assertThat(deviationList.get(1).getResolution()).isEqualTo("Resolution2");

    }

    @Test
    @DisplayName("Should add third deviation")
    public void shouldAddNewDeviationAndReturnLengthThree() {
        when(deviationRepository.findAll()).thenReturn(deviationList);

        deviationService.getDeviations();
        Deviation deviation3 = new Deviation();
        deviationList.add(deviation3);

        verify(deviationRepository, times(1)).findAll();
        assertThat(deviationList.size()).isEqualTo(3);
    }


}


