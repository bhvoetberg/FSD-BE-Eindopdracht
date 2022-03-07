package nl.novi.fsdbe.repository;

import nl.novi.fsdbe.model.Deviation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviationRepository extends JpaRepository<Deviation, Long> {
}
