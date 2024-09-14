package mattiasusin.D5S2U5.controllers;

import mattiasusin.D5S2U5.entities.Prenotazione;
import mattiasusin.D5S2U5.exceptions.BadRequestException;
import mattiasusin.D5S2U5.payloads.NewPrenotazioneDTO;
import mattiasusin.D5S2U5.payloads.NewRespPrenotazioniDTO;
import mattiasusin.D5S2U5.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {
    @Autowired
    private PrenotazioneService prenotazioneService;

    // 1 --> GET TUTTI
    @GetMapping
    public List<Prenotazione> findAllPrenotazione() {
        return prenotazioneService.findAllPrenotazione();
    }

    // 2 --> POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewRespPrenotazioniDTO save(@RequestBody @Validated NewPrenotazioneDTO body, BindingResult validResultPrenot) {
        if (validResultPrenot.hasErrors()) {
            String messages = validResultPrenot.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.joining(". "));
            throw new BadRequestException("Ci sono errori nel payload " + messages);
        }
        return new NewRespPrenotazioniDTO(this.prenotazioneService.save(body).getId());
    }

    // 3 --> GET ID
    @GetMapping("/{prenotazioneId}")
    public Prenotazione findByIdPrenotazione(@PathVariable UUID prenotazioneId) {
        return this.prenotazioneService.findByIdPrenotazione(prenotazioneId);
    }

    // 4 --> PUT
    @PutMapping("/{prenotazioneId}")
    public Prenotazione findByIdAndUpdatePrenotazione(@PathVariable UUID prenotazioneId, @RequestBody Prenotazione body) {
        return this.prenotazioneService.findByIdAndUpdatePrenotazione(prenotazioneId, body);
    }

    // 5 --> DELETE
    @DeleteMapping("/{prenotazioniId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void ffindByIdAndDeletePrenotazione(@PathVariable UUID prenotazioneId) {
        this.prenotazioneService.findByIdAndDeletePrenotazione(prenotazioneId);
    }
}
