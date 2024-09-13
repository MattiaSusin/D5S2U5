package mattiasusin.D5S2U5.controllers;

import mattiasusin.D5S2U5.entities.Dipendente;
import mattiasusin.D5S2U5.exceptions.BadRequestException;
import mattiasusin.D5S2U5.payloads.NewDipendenteDTO;
import mattiasusin.D5S2U5.services.DipendentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {
    @Autowired
    private DipendentiService dipendentiService;

    // 1 --> GET ALL
    @GetMapping
    public List<Dipendente> findAllDipendenti(){
        return dipendentiService.findAll();
    }

    // 2 --> GET USERNAME
    @GetMapping("/{dipendenteUsername}")
    public Dipendente findByUsername(@PathVariable String dipendenteUsername){
        return this.dipendentiService.findByUsername(dipendenteUsername);
    }

    // 3 --> POST
    @PostMapping("/{dipendenteid}")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveD(@RequestBody @Validated NewDipendenteDTO body, BindingResult validationRisultato) {
        if (validationRisultato.hasErrors()) {
            String messages = validationRisultato.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.joining(". "));
            throw new BadRequestException("Ci sono errori nel payload: " + messages);
        } else {
            this.dipendentiService.save(body);

        }
    }

    // 4 --> PUT
    @PutMapping("/{dipendenteUsername}")
    public Dipendente findByUsernameAndUpdate(@PathVariable String dipendenteUsername, @RequestBody Dipendente body){
    return this.dipendentiService.findByUsernameAndUpdate(dipendenteUsername, body);
    }

    // 5 --> DELETE
    @DeleteMapping("/{dipendenteUsername}")
    public void findByUsernameAndDelete(@PathVariable String dipendenteUsername){
        this.dipendentiService.findByUsernameAndDelete(dipendenteUsername);
    }

   /* // 6 --> UPLOAD
    @PostMapping("/{dipendenteUsername}/img")
    public void uploadImg(@RequestParam("img")MultipartFile image) throws IOException{
        this.dipendentiService.uploadImg(image);
    }*/


}
