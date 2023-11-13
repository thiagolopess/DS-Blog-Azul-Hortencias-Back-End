package unb.azul.hortencias.blog.feudal.model;

import lombok.Getter;
import lombok.Setter;

import unb.azul.hortencias.blog.feudal.model.enumerator.RoleIndicator;

import javax.persistence.*;


@Entity
@Table(name = "tb_account", schema = "public")
@Getter
@Setter
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

    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_role", nullable = false)
    private RoleIndicator role;
}
