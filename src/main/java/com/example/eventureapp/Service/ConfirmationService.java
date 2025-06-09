package com.example.eventureapp.Service;

import com.example.eventureapp.Model.Confirmation;
import com.example.eventureapp.Repository.ConfirmationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfirmationService {

    private final ConfirmationRepository confirmationRepository;

    @Autowired
    public ConfirmationService(ConfirmationRepository confirmationRepository) {
        this.confirmationRepository = confirmationRepository;
    }

    public List<Confirmation> hentAlleConfirmations() {
        return (List<Confirmation>) confirmationRepository.findAll();
    }

    public Optional<Confirmation> hentConfirmationVedId(int id) {
        return confirmationRepository.findById(id);
    }

    public Confirmation lagNyConfirmation(Confirmation confirmation) {
        return confirmationRepository.save(confirmation);
    }

    public boolean oppdaterConfirmation(Confirmation confirmation) {
        if (confirmationRepository.existsById(confirmation.getConfirmationId())) {
            confirmationRepository.save(confirmation);
            return true;
        }
        return false;
    }

    public boolean slettConfirmation(int id) {
        if (confirmationRepository.existsById(id)) {
            confirmationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
