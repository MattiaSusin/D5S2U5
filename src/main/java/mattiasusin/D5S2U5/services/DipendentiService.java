package mattiasusin.D5S2U5.services;

import com.cloudinary.Cloudinary;
import io.micrometer.observation.Observation;
import mattiasusin.D5S2U5.entities.Dipendente;
import mattiasusin.D5S2U5.exceptions.NotFoundException;
import mattiasusin.D5S2U5.payloads.NewDipendenteDTO;
import mattiasusin.D5S2U5.repositories.DipendentiRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DipendentiService {

    //IMPORTIAMO CLASSI

    @Autowired
    private DipendentiRepository dipendentiRepository;

    @Autowired
    private Cloudinary cloudinary;

    //QUERY

    // 1 --> VEDIAMO SE LA MAIL E' PRESENTE
    public Dipendente save(NewDipendenteDTO body) {
        // 1 -->
        this.dipendentiRepository.

        // 2 -->

        // 3 -->
    }

    // 2 --> GET ID
    public Dipendente findByUsername(String dipendenteUsername){
        return this.dipendentiRepository.findById(UUID.fromString(dipendenteUsername)).orElseThrow(()-> new NotFoundException(dipendenteUsername));
    }
    // 3 --> DELETE
    public void findByUsernameAndDelete(String dipendenteUsername){
        Dipendente found = this.findByUsername(dipendenteUsername);
        this.dipendentiRepository.delete(found);
    }
    // 4 --> PUT
    public Dipendente findByUsernameAndUpdate(String dipendenteUsername, Dipendente newDipendenteData){
        // 4.1 --> Se la mail è già presente
        this.dipendentiRepository.f
        dipendente -> {
            throw new BadRequestException("L'email " + newDipendenteData.getEmail() + "è già in uso");
        }
    }

}
