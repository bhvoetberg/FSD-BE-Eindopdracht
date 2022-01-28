package nl.novi.fsdbe.repository;

import nl.novi.fsdbe.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
