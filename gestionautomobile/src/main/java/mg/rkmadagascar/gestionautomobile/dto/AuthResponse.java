package mg.rkmadagascar.gestionautomobile.dto;

public record AuthResponse(String accessToken, String tokenType, long expiresIn, AuthUser user) {

    public record AuthUser(
            String id,
            String name,
            String firstName,
            String email,
            String contact,
            RoleInfo role) {}

    public record RoleInfo(String id, String libelle) {}
}
