package nl.novi.fsdbe.repository;

import nl.novi.fsdbe.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}