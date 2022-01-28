package nl.novi.fsdbe.repository;

import nl.novi.fsdbe.model.Deviation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DeviationRepository extends JpaRepository<Deviation, Long> {
}
