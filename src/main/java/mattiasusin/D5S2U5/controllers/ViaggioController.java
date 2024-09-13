package mattiasusin.D5S2U5.controllers;

import mattiasusin.D5S2U5.entities.Viaggio;
import mattiasusin.D5S2U5.exceptions.BadRequestException;
import mattiasusin.D5S2U5.payloads.NewResponsViaggioDTO;
import mattiasusin.D5S2U5.payloads.NewViaggioDTO;
import mattiasusin.D5S2U5.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/viaggio")
public class ViaggioController {
    @Autowired
    private ViaggioService viaggioService;

    //1 GET ALL
    @GetMapping
    public List<Viaggio> findAll() {
        return this.viaggioService.findAll();
    }

    //2 POST
    @PostMapping("/{viaggioid}")
    @ResponseStatus(HttpStatus.CREATED)
    public NewResponsViaggioDTO save(@RequestBody @Validated NewViaggioDTO body, BindingResult validationResult) {
        if (validationResult.hasErrors()) {

            String messages = validationResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.joining(". "));

            throw new BadRequestException("Ci sono stati errori nel payload. " + messages);
        } else {

            return new NewResponsViaggioDTO(this.viaggioService.save(body).getId());
        }
    }
    // Get ID
    @GetMapping("/{viaggioid}")

    public Viaggio findyById(@PathVariable UUID viaggioid) {
        return this.viaggioService.findById(viaggioid);
    }

    //PUT
    @PutMapping("/{viaggioid}")
    public Viaggio findByIdAndUpdate(@PathVariable UUID viaggioid, @RequestBody Viaggio body) {
        return this.viaggioService.findByIdAndUpdate(viaggioid,body);

    }

    //Delete
    @DeleteMapping("/{viaggioid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete (@PathVariable UUID viaggioId) {
        this.viaggioService.findByIdAndDelete(viaggioId);
    }

    }





