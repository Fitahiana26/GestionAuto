package mg.rkmadagascar.gestionautomobile;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HexFormat;
import org.junit.jupiter.api.Test;
import mg.rkmadagascar.gestionautomobile.config.MigratingPasswordEncoder;

class MigratingPasswordEncoderTests {

    private final MigratingPasswordEncoder encoder = new MigratingPasswordEncoder();

    @Test
    void legacySha1PasswordMatchesAndIsMarkedForUpgrade() throws Exception {
        String password = "legacy-password";
        String legacyHash = HexFormat.of().formatHex(
                MessageDigest.getInstance("SHA-1").digest(password.getBytes(StandardCharsets.UTF_8)));

        assertTrue(encoder.matches(password, legacyHash));
        assertTrue(encoder.upgradeEncoding(legacyHash));
        assertFalse(encoder.matches("wrong-password", legacyHash));

        String upgradedHash = encoder.encode(password);
        assertTrue(encoder.matches(password, upgradedHash));
        assertFalse(encoder.upgradeEncoding(upgradedHash));
    }
}
