package nl.novi.fsdbe.repository;

import nl.novi.fsdbe.model.Planning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanningRepository extends JpaRepository<Planning, Long> {
}
