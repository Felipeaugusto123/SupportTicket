package FelipeAugusto123.github.SupportTicket.controller;

import FelipeAugusto123.github.SupportTicket.Domain.SupportTicket;
import FelipeAugusto123.github.SupportTicket.Service.SupportTicketService;
import FelipeAugusto123.github.SupportTicket.request.SupportTicketRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/support-tickets")
@RequiredArgsConstructor
public class SupportTicketController {

    private final SupportTicketService service;

    @GetMapping
    public ResponseEntity<Page<SupportTicket>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupportTicket> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<SupportTicket> createSupportTicket(@RequestBody @Valid SupportTicketRequest supportTicket) {
        return ResponseEntity.ok(service.createSupportTicket(supportTicket));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupportTicket> updateSupportTicket(@PathVariable Long id, @RequestBody @Valid SupportTicketRequest supportTicket) {
        return ResponseEntity.ok(service.updateSupportTicket(id, supportTicket));
    }

    @PutMapping("/{id}/close")
    public ResponseEntity<SupportTicket> closeSupportTicket(@PathVariable Long id) {
        service.closeSupportTicket(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSupportTicket(@PathVariable Long id) {
        service.deleteSupportTicket(id);
        return ResponseEntity.noContent().build();
    }


}
