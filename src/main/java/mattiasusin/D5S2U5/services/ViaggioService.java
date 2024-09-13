package mattiasusin.D5S2U5.services;

import mattiasusin.D5S2U5.entities.Viaggio;
import mattiasusin.D5S2U5.enums.StatoViaggio;
import mattiasusin.D5S2U5.exceptions.NotFoundException;
import mattiasusin.D5S2U5.payloads.NewViaggioDTO;
import mattiasusin.D5S2U5.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ViaggioService {
    @Autowired
    private ViaggioRepository viaggioRepository;

    //GET ID
    public Viaggio findById(UUID viaggioId) {
        return this.viaggioRepository.findById(viaggioId).orElseThrow(() -> new NotFoundException(viaggioId));
    }

    //GET ALL
    public List<Viaggio> findAll() {
        return this.viaggioRepository.findAll();
    }

    //POST
    public Viaggio save(NewViaggioDTO body) {
        Viaggio newViaggio = new Viaggio(
                LocalDate.parse(body.data()),
                body.destinazione(),
                StatoViaggio.valueOf(body.statoViaggio().toUpperCase())
        );
        return this.viaggioRepository.save(newViaggio);

    }

    //DELETE
    public void findByIdAndDelete(UUID viaggioId) {
        Viaggio found = this.findById(viaggioId);
        this.viaggioRepository.delete(found);
    }

    //PUT
    public Viaggio findByIdAndUpdate(UUID viaggioId, Viaggio newViaggioData){
        Viaggio found = this.findById(viaggioId);
        found.setData(newViaggioData.getData());
        found.setStatoViaggio(newViaggioData.getStatoViaggio());
        found.setDestinazione(newViaggioData.getDestinazione());
        return this.viaggioRepository.save(found);
    }

}





