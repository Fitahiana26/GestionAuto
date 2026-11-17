package mg.rkmadagascar.gestionautomobile.service;

import java.util.Locale;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.User;
import mg.rkmadagascar.gestionautomobile.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable"));
        String role = user.getRole().getLibelle().toUpperCase(Locale.ROOT);
        if (role.equals("ADMINISTRATEUR")) {
            role = "ADMIN";
        }

        return org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities("ROLE_" + role)
                .build();
    }
}
