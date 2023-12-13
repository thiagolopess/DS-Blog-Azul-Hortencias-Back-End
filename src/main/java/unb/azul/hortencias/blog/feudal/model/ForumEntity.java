package unb.azul.hortencias.blog.feudal.model;

import lombok.Getter;
import lombok.Setter;
import unb.azul.hortencias.blog.feudal.model.enumerator.ForumIndicator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_forum", schema = "public")
@Getter
@Setter
public class ForumEntity {
    @Id
    @Column(name = "id_forum")
    @SequenceGenerator(name = "forumSequence", sequenceName = "sq_forum", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forumSequence")
    private Integer id;

    @Column(name = "type", nullable = false)
    private ForumIndicator type;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<PostEntity> posts;
}
