package unb.azul.hortencias.blog.feudal.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_comment", schema = "public")
@Getter
@Setter
public class CommentEntity {

    @Id
    @Column(name = "id_comment")
    @SequenceGenerator(name = "commentSequence", sequenceName = "sq_comment", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentSequence")
    private Integer id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "dh_created", nullable = false)
    private LocalDateTime date;
}
