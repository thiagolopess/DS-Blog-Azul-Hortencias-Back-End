package unb.azul.hortencias.blog.feudal.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class LoginDTO {
    String email;
    String password;
}
