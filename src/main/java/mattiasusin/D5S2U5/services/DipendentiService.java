package mattiasusin.D5S2U5.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import io.micrometer.observation.Observation;
import mattiasusin.D5S2U5.entities.Dipendente;
import mattiasusin.D5S2U5.exceptions.NotFoundException;
import mattiasusin.D5S2U5.payloads.NewDipendenteDTO;
import mattiasusin.D5S2U5.repositories.DipendentiRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        this.dipendentiRepository.findByEmail(body.email()).ifPresent(
                dipendente -> {
                    try {
                        throw new BadRequestException("L'email " + body.email() + "è già in uso!");
                    } catch (BadRequestException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        // 2 -->
        Dipendente newDipendente = new Dipendente(body.name(), body.cognome(), body.email(), body.username());

        // 3 -->
        return this.dipendentiRepository.save(newDipendente);
    }

    private List<Dipendente> dipendenteList = new ArrayList<>();

    // 2 --> GET TUTTI
    public List<Dipendente> findAll(){
        return this.dipendenteList;
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
        this.dipendentiRepository.findByEmail(newDipendenteData.getEmail()).ifPresent(
        dipendente -> {
            try {
                throw new BadRequestException("L'email " + newDipendenteData.getEmail() + "è già in uso");
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        }
        );
     Dipendente found = this.findByUsername(dipendenteUsername);
     found.setNome(newDipendenteData.getNome());
     found.setCognome(newDipendenteData.getCognome());
     found.setUsername(newDipendenteData.getUsername());
     found.setEmail(newDipendenteData.getEmail());
     return this.dipendentiRepository.save(found);
    }
    // 5 --> IMG CLOUDINARY
    public void uploadImg(MultipartFile file) throws IOException{
        String url = (String) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
        System.out.println("URL: " + url);
    }

}
