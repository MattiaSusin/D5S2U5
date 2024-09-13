package mattiasusin.D5S2U5.controllers;

import mattiasusin.D5S2U5.entities.Dipendente;
import mattiasusin.D5S2U5.services.DipendentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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

    // 3 --> PUT
    @PutMapping("/{dipendenteUsername}")
    public Dipendente findByUsernameAndUpdate(@PathVariable String dipendenteUsername, @RequestBody Dipendente body){
    return this.dipendentiService.findByUsernameAndUpdate(dipendenteUsername, body);
    }

    // 4 --> DELETE
    @DeleteMapping("/{dipendenteUsername}")
    public void findByUsernameAndDelete(@PathVariable String dipendenteUsername){
        this.dipendentiService.findByUsernameAndDelete(dipendenteUsername);
    }

    // 5 --> UPLOAD
    @PostMapping("/{dipendenteUsername/img}")
    public void uploadImg(@RequestParam("img")MultipartFile image) throws IOException{
        this.dipendentiService.uploadImg(image);
    }

}
