package mg.rkmadagascar.gestionautomobile.config;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Locale;
import java.util.regex.Pattern;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MigratingPasswordEncoder implements PasswordEncoder {

    private static final Pattern LEGACY_SHA1 = Pattern.compile("[0-9a-fA-F]{40}");
    private final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    @Override
    public String encode(CharSequence rawPassword) {
        return bcrypt.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword == null || encodedPassword == null) return false;
        if (!LEGACY_SHA1.matcher(encodedPassword).matches()) {
            return bcrypt.matches(rawPassword, encodedPassword);
        }

        return MessageDigest.isEqual(
                sha1(rawPassword).getBytes(StandardCharsets.UTF_8),
                encodedPassword.toLowerCase(Locale.ROOT).getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public boolean upgradeEncoding(String encodedPassword) {
        return encodedPassword != null && (LEGACY_SHA1.matcher(encodedPassword).matches()
                || bcrypt.upgradeEncoding(encodedPassword));
    }

    private String sha1(CharSequence rawPassword) {
        try {
            byte[] hash = MessageDigest.getInstance("SHA-1")
                    .digest(rawPassword.toString().getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-1 indisponible pour vérifier les anciens mots de passe", e);
        }
    }
}