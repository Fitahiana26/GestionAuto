package mg.rkmadagascar.gestionautomobile.controller;

import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.dto.AuthResponse;
import mg.rkmadagascar.gestionautomobile.dto.LoginRequest;
import mg.rkmadagascar.gestionautomobile.dto.RegisterRequest;
import mg.rkmadagascar.gestionautomobile.entity.User;
import mg.rkmadagascar.gestionautomobile.service.AuthService;
import mg.rkmadagascar.gestionautomobile.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createResponse(service.register(req)));
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest req) {
        return createResponse(service.login(req));
    }

    private AuthResponse createResponse(User user) {
        return jwtService.createAuthResponse(user);
    }
}