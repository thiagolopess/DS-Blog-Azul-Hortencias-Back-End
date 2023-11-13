package unb.azul.hortencias.blog.feudal.dto;

import lombok.*;
import unb.azul.hortencias.blog.feudal.model.enumerator.RoleIndicator;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class AccountDTO {
    String username;
    String registration;
    String email;
    String password;
    RoleIndicator role;
}
