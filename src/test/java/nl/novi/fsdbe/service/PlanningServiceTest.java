package nl.novi.fsdbe.service;

import nl.novi.fsdbe.model.Planning;
import nl.novi.fsdbe.repository.PlanningRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PlanningServiceTest {

    @Mock
    private PlanningRepository planningRepository;

    @InjectMocks
    private PlanningService planningService;

    private Planning planning;

    @BeforeEach
    public void setUp() {
        this.planning = new Planning();
        planning.setId(123L);
        planning.setPlanTime("10:00");
        planning.setPlanDate("01-06-2022");
    }

    @Test
    @DisplayName("Should return provided planning date & time")
    void shouldReturnPlanningDateAndTime() {
        assertEquals("10:00", planning.getPlanTime());
        assertEquals("01-06-2022", planning.getPlanDate());
    }

    @Test
    @DisplayName("Should save Planning")
    public void givenPlanningObject_whenSavePlanning_thenReturnPlanningObject() {

        given(planningRepository.save(planning)).willReturn(planning);

        Long savedPlanning = planningService.addPlanning(planning);

        assertThat(savedPlanning).isNotNull();
    }

    @Test
    @DisplayName("Should return planning by ID")
    public void givenPlanningId_thenReturnPlanningObject() {
        given(planningRepository.findById(123L)).willReturn(Optional.of(planning));
        Planning savedPlanning = planningService.getPlanning(planning.getId());
        assertThat(savedPlanning).isNotNull();
    }

}