

package com.example.eventureapp.Controller;

import com.example.eventureapp.Model.Payment;
import com.example.eventureapp.DTO.PaymentDTO;
import com.example.eventureapp.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<PaymentDTO> getAllPayments() {
        return paymentService.getAllPaymentsDTO(); // ENDRING: Bruker DTO metode
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentByIdDTO(id) // ENDRING: Bruker DTO metode
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody Payment payment) {
        try {
            return ResponseEntity.ok(paymentService.createPaymentDTO(payment)); // ENDRING: Bruker DTO metode
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDTO> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        try {
            return ResponseEntity.ok(paymentService.updatePaymentDTO(id, payment)); // ENDRING: Bruker DTO metode
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        try {
            paymentService.deletePayment(id); // UENDRET: Ingen DTO nødvendig for delete
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/book/{bookId}")
    public Optional<PaymentDTO> getPaymentsByBookId(@PathVariable int bookId) {
        return paymentService.getPaymentsByBookIdDTO(bookId); // ENDRING: Bruker DTO metode
    }
}