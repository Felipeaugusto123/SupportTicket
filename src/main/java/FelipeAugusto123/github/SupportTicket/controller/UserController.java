package FelipeAugusto123.github.SupportTicket.controller;

import FelipeAugusto123.github.SupportTicket.Domain.User;
import FelipeAugusto123.github.SupportTicket.Service.TecTiService;
import FelipeAugusto123.github.SupportTicket.Service.UserService;
import FelipeAugusto123.github.SupportTicket.request.TecTIRequest;
import FelipeAugusto123.github.SupportTicket.request.UserRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService service;
    private final TecTiService tecTIService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/cpf")
    public ResponseEntity<User> getUserByCPF(String CPF) {
        return ResponseEntity.ok(service.findByCPF(CPF));
    }

    @PostMapping("/CreateUser")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserRequest user) {
        return ResponseEntity.ok(service.createUser(user));
    }

    @PostMapping("/CreateTecTI")
    public ResponseEntity<User> createTecTI(@RequestBody @Valid TecTIRequest tecTI) {
        return ResponseEntity.ok(tecTIService.createTecTI(tecTI));
    }

    @PutMapping("UpdateUser/{id}")
    public ResponseEntity<User> updateUser(@RequestParam Long id, @RequestBody @Valid UserRequest user) {
        return ResponseEntity.ok(service.updateUser(id, user));
    }

    @PutMapping("UpdateTecTI/{id}")
    public ResponseEntity<User> updateTecTI(@RequestParam Long id, @RequestBody @Valid TecTIRequest tecTI) {
        return ResponseEntity.ok(tecTIService.updateTecTi(id, tecTI));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestParam Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
