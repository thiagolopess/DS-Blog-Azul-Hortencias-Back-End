package unb.azul.hortencias.blog.feudal.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "tb_post", schema = "public")
@Entity
public class PostEntity {
    @Id
    @Column(name = "id_post")
    @SequenceGenerator(name = "postSequence", sequenceName = "sq_post", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postSequence")
    private Integer id;

    @Column(name = "title", nullable = false, length = 30)
    private String title;

    @Column(name = "tx_text", nullable = false)
    private String content;

    @Column(name = "dh_created", nullable = false)
    private LocalDateTime date;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;
}
