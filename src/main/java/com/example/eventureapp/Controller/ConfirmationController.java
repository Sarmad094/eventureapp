package com.example.eventureapp.Controller;

import com.example.eventureapp.Model.Confirmation;
import com.example.eventureapp.Service.ConfirmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/confirmations")
public class ConfirmationController {

    private final ConfirmationService confirmationService;

    @Autowired
    public ConfirmationController(ConfirmationService confirmationService) {
        this.confirmationService = confirmationService;
    }

    @GetMapping
    public List<Confirmation> hentAlle() {
        return confirmationService.hentAlleConfirmations();
    }

    @GetMapping("/{id}")
    public Confirmation hentEn(@PathVariable int id) {
        Optional<Confirmation> confirmation = confirmationService.hentConfirmationVedId(id);
        return confirmation.orElse(null);
    }

    @PostMapping
    public int lagConfirmation(@RequestBody Confirmation confirmation) {
        return confirmationService.lagNyConfirmation(confirmation).getConfirmationId();
    }

    @PutMapping("/{id}")
    public boolean oppdater(@PathVariable int id, @RequestBody Confirmation confirmation) {
        confirmation.setConfirmationId(id);
        return confirmationService.oppdaterConfirmation(confirmation);
    }

    @DeleteMapping("/{id}")
    public boolean slett(@PathVariable int id) {
        return confirmationService.slettConfirmation(id);
    }
}
