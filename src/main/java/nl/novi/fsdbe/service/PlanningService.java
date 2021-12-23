package nl.novi.fsdbe.service;

import nl.novi.fsdbe.model.Planning;
import nl.novi.fsdbe.repository.PlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanningService {

    @Autowired
    private PlanningRepository planningRepository;

    public Iterable<Planning> getPlanning() {
        return planningRepository.findAll();
    }


}
