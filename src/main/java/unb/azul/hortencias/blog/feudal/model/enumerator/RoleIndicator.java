package unb.azul.hortencias.blog.feudal.model.enumerator;

import lombok.Getter;

@Getter
public enum RoleIndicator {
    CAVALEIRO("Cavaleiro"),
    DUQUE("Duque"),
    CONSELHEIRO("Conselheiro"),
    MONARCA("Monarca");

    private final String role;

    RoleIndicator(String role) {
        this.role = role;
    }
}
