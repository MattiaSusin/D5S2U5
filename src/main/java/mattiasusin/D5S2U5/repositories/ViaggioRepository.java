package mattiasusin.D5S2U5.repositories;

import mattiasusin.D5S2U5.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ViaggioRepository extends JpaRepository <Viaggio, UUID> {

}
