package mg.rkmadagascar.gestionautomobile.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import javax.crypto.SecretKey;
import lombok.Getter;
import mg.rkmadagascar.gestionautomobile.dto.AuthResponse;
import mg.rkmadagascar.gestionautomobile.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final SecretKey signingKey;
    private final String issuer;

    @Getter
    private final long expirationMillis;

    public JwtService(
            @Value("${app.jwt.secret}") String encodedSecret,
            @Value("${app.jwt.issuer}") String issuer,
            @Value("${app.jwt.expiration-ms}") long expirationMillis) {
        if (encodedSecret == null || encodedSecret.isBlank()) {
            throw new IllegalStateException("JWT_SECRET doit contenir une clé Base64 d'au moins 32 octets");
        }
        if (expirationMillis <= 0) {
            throw new IllegalStateException("app.jwt.expiration-ms doit être supérieur à zéro");
        }

        byte[] keyBytes;
        try {
            keyBytes = Base64.getDecoder().decode(encodedSecret);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("JWT_SECRET doit être encodé en Base64", e);
        }
        if (keyBytes.length < 32) {
            throw new IllegalStateException("JWT_SECRET doit décoder en au moins 32 octets");
        }

        this.signingKey = Keys.hmacShaKeyFor(keyBytes);
        this.issuer = issuer;
        this.expirationMillis = expirationMillis;
    }

    public String generateToken(User user) {
        Instant now = Instant.now();
        return Jwts.builder()
                .issuer(issuer)
                .subject(user.getEmail())
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plusMillis(expirationMillis)))
                .signWith(signingKey, Jwts.SIG.HS256)
                .compact();
    }

    public String extractSubject(String token) {
        return parseClaims(token).getSubject();
    }

    public boolean isTokenValid(String token, String expectedSubject) {
        Claims claims = parseClaims(token);
        return expectedSubject.equals(claims.getSubject())
                && claims.getExpiration() != null
                && claims.getExpiration().after(new Date());
    }

    public AuthResponse createAuthResponse(User user) {
        return new AuthResponse(
                generateToken(user),
                "Bearer",
                expirationMillis / 1000,
                new AuthResponse.AuthUser(
                        user.getId(),
                        user.getName(),
                        user.getFirstName(),
                        user.getEmail(),
                        user.getContact(),
                        new AuthResponse.RoleInfo(user.getRole().getId(), user.getRole().getLibelle())));
    }

    private Claims parseClaims(String token) {
        Jws<Claims> parsed = Jwts.parser()
                .verifyWith(signingKey)
                .requireIssuer(issuer)
                .build()
                .parseSignedClaims(token);
        if (!Jwts.SIG.HS256.getId().equals(parsed.getHeader().getAlgorithm())) {
            throw new IllegalArgumentException("Seuls les JWT signés en HS256 sont acceptés");
        }
        return parsed.getPayload();
    }
}
