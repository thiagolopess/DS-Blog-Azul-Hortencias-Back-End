package unb.azul.hortencias.blog.feudal.model.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ForumIndicator {
    LIVRE("Livre"),
    ESTUDOS("Estudos"),
    PAINEL_ESCRIBAS("Painel dos Escribas"),
    AVISOS("Avisos");

    private final String forum;
}
