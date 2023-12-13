package unb.azul.hortencias.blog.feudal.model.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleIndicator {
    CAVALEIRO("Cavaleiro"),
    DUQUE("Duque"),
    CONSELHEIRO("Conselheiro"),
    MONARCA("Monarca");

    private final String role;

}
