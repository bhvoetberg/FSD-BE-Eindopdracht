package nl.novi.fsdbe.repository;

import nl.novi.fsdbe.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
