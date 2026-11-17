package mg.rkmadagascar.gestionautomobile.service;

import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.dto.LoginRequest;
import mg.rkmadagascar.gestionautomobile.dto.RegisterRequest;
import mg.rkmadagascar.gestionautomobile.entity.Role;
import mg.rkmadagascar.gestionautomobile.entity.User;
import mg.rkmadagascar.gestionautomobile.repository.RoleRepository;
import mg.rkmadagascar.gestionautomobile.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthService {

    private static final String ROLE_CLIENT = "CLIENT";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User register(RegisterRequest req) {
        if (isBlank(req.email()) || isBlank(req.password()) || isBlank(req.name())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nom, email et mot de passe obligatoires");
        }
        String email = req.email().trim().toLowerCase();
        if (userRepository.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email déjà utilisé");
        }

        // Rôle automatique : CLIENT (créé s'il n'existe pas encore)
        Role client = roleRepository.findByLibelle(ROLE_CLIENT).orElseGet(() -> {
            Role r = new Role();
            r.setLibelle(ROLE_CLIENT);
            return roleRepository.save(r);
        });

        User user = new User();
        user.setName(req.name().trim());
        user.setFirstName(req.firstName());
        user.setEmail(email);
        user.setContact(req.contact());
        user.setPassword(passwordEncoder.encode(req.password()));
        user.setRole(client);
        return userRepository.save(user);
    }

    @Transactional
    public User login(LoginRequest req) {
        if (isBlank(req.email()) || isBlank(req.password())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email et mot de passe obligatoires");
        }
        User user = userRepository.findByEmail(req.email().trim().toLowerCase())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ou mot de passe incorrect"));
        if (!passwordEncoder.matches(req.password(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ou mot de passe incorrect");
        }
        if (passwordEncoder.upgradeEncoding(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(req.password()));
            userRepository.save(user);
        }
        return user;
    }

    private boolean isBlank(String s) {
        return s == null || s.isBlank();
    }
}