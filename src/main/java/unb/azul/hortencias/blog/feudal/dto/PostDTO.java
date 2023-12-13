package unb.azul.hortencias.blog.feudal.dto;

import lombok.*;
import unb.azul.hortencias.blog.feudal.model.enumerator.ForumIndicator;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class PostDTO {
    String title;
    String content;
    ForumIndicator forum;
}
