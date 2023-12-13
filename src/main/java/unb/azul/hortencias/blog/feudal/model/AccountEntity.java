package unb.azul.hortencias.blog.feudal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import unb.azul.hortencias.blog.feudal.dto.AccountDTO;
import unb.azul.hortencias.blog.feudal.model.enumerator.RoleIndicator;

import javax.persistence.*;


@Entity
@Table(name = "tb_account", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {

    @Id
    @Column(name = "id_account")
    @SequenceGenerator(name = "accountSequence", sequenceName = "sq_account", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountSequence")
    private Integer id;

    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @Column(name = "registration", nullable = false, length = 9)
    private String registration;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "fiefdom", nullable = false, length = 30)
    private String fiefdom;

    @JsonIgnore
    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_role", nullable = false)
    private RoleIndicator role;

   public AccountEntity(AccountDTO account) {
        this.username = account.getUsername();
        this.registration = account.getRegistration();
        this.fiefdom = account.getFiefdom();
        this.email = account.getEmail();
        this.password = account.getPassword();
        this.role = account.getRole();
    }
}
