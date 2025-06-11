package com.example.eventureapp.Controller;

import com.example.eventureapp.DTO.ConfirmationDTO;
import com.example.eventureapp.Mapper.ConfirmationMapper;
import com.example.eventureapp.Model.Confirmation;
import com.example.eventureapp.Repository.BookingRepository;
import com.example.eventureapp.Service.ConfirmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/confirmations")
public class ConfirmationController {

    private final ConfirmationService confirmationService;
    private final BookingRepository bookingRepository;

    @Autowired
    public ConfirmationController(ConfirmationService confirmationService, BookingRepository bookingRepository) {
        this.confirmationService = confirmationService;
        this.bookingRepository = bookingRepository;
    }

    @GetMapping
    public List<ConfirmationDTO> hentAlle() {
        return confirmationService.hentAlleConfirmations().stream()
                .map(ConfirmationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ConfirmationDTO hentEn(@PathVariable int id) {
        Optional<Confirmation> confirmation = confirmationService.hentConfirmationVedId(id);
        return confirmation.map(ConfirmationMapper::toDTO).orElse(null);
    }

    @PostMapping
    public int lagConfirmation(@RequestBody ConfirmationDTO dto) {
        Confirmation confirmation = ConfirmationMapper.toEntity(dto, bookingRepository);
        return confirmationService.lagNyConfirmation(confirmation).getConfirmationId();
    }

    @PutMapping("/{id}")
    public boolean oppdater(@PathVariable int id, @RequestBody ConfirmationDTO dto) {
        dto.setConfirmationId(id);
        Confirmation confirmation = ConfirmationMapper.toEntity(dto, bookingRepository);
        return confirmationService.oppdaterConfirmation(confirmation);
    }

    @DeleteMapping("/{id}")
    public boolean slett(@PathVariable int id) {
        return confirmationService.slettConfirmation(id);
    }
}
