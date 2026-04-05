package FelipeAugusto123.github.SupportTicket.controller;

import FelipeAugusto123.github.SupportTicket.Domain.User;
import FelipeAugusto123.github.SupportTicket.Service.TecTiService;
import FelipeAugusto123.github.SupportTicket.Service.UserService;
import FelipeAugusto123.github.SupportTicket.infra.security.TokenService;
import FelipeAugusto123.github.SupportTicket.request.AuthDTO;
import FelipeAugusto123.github.SupportTicket.request.TecTIRequest;
import FelipeAugusto123.github.SupportTicket.request.UserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final TecTiService tiService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserRequest user) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encryptedPassword);

        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/createTecTI")
    public ResponseEntity<User> createTecTI(@RequestBody @Valid TecTIRequest tecTI) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(tecTI.getPassword());
        tecTI.setPassword(encryptedPassword);

        return ResponseEntity.ok(tiService.createTecTI(tecTI));
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody @Valid AuthDTO dto) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
        var auth = authenticationManager.authenticate(usernamePassword);

        User user = (User) auth.getPrincipal();
        String token = tokenService.generateToken(user);

        return ResponseEntity.ok(token);
    }
}