package mattiasusin.D5S2U5.services;

import com.cloudinary.Cloudinary;
import mattiasusin.D5S2U5.entities.Prenotazione;
import mattiasusin.D5S2U5.exceptions.NotFoundException;
import mattiasusin.D5S2U5.payloads.NewPrenotazioneDTO;
import mattiasusin.D5S2U5.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private Cloudinary cloudinaryUp;
    private List<Prenotazione> prenotazioneList = new ArrayList<>();

    // 1 --> SALVA E CREA
    public Prenotazione save(NewPrenotazioneDTO body) {
        return this.prenotazioneRepository.save(new Prenotazione());
    }

    // 2 --> GET TUTTI
    public List<Prenotazione> findAllPrenotazione() {
        return this.prenotazioneList;
    }

    // 2 --> GET ID
    public Prenotazione findByIdPrenotazione(UUID prenotazioneId) {
        return this.prenotazioneRepository.findById(prenotazioneId).orElseThrow(() -> new NotFoundException(prenotazioneId));
    }

    // 3 --> PUT
    public Prenotazione findByIdAndUpdatePrenotazione(UUID prenotazioneId, Prenotazione newPrenotazioneData) {
        Prenotazione found = this.findByIdPrenotazione(prenotazioneId);
        found.setDipendente(newPrenotazioneData.getDipendente());
        found.setViaggio(newPrenotazioneData.getViaggio());
        return this.prenotazioneRepository.save(found);
    }

    // 4 --> DELETE
    public void findByIdAndDeletePrenotazione(UUID prenotazioneId) {
        Prenotazione found = this.findByIdPrenotazione(prenotazioneId);
        this.prenotazioneRepository.delete(found);
    }


}
