package mattiasusin.D5S2U5.repositories;

import mattiasusin.D5S2U5.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DipendentiRepository extends JpaRepository<Dipendente, UUID> {
    Optional<Dipendente> findByEmail(String email);
}
