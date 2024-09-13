package mattiasusin.D5S2U5.controllers;

import mattiasusin.D5S2U5.entities.Dipendente;
import mattiasusin.D5S2U5.services.DipendentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {
    @Autowired
    private DipendentiService dipendentiService;

    // 1 --> GET TUTTI
    @GetMapping
    public List<Dipendente> findAllDipendenti(){
        return dipendentiService.findAll();
    }

    // 2 --> GET USERNAME
    @GetMapping("/{dipendenteUsername}")
    public Dipendente findByUsername(@PathVariable String dipendenteUsername){
        return this.dipendentiService.findByUsername(dipendenteUsername);
    }

    // 3 --> 

}
