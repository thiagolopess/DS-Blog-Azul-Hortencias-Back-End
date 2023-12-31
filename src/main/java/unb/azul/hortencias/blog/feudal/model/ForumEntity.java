package unb.azul.hortencias.blog.feudal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import unb.azul.hortencias.blog.feudal.model.enumerator.ForumIndicator;

import javax.persistence.*;

@Entity
@Table(name = "tb_forum", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ForumEntity {
    @Id
    @Column(name = "id_forum")
    @SequenceGenerator(name = "forumSequence", sequenceName = "sq_forum", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forumSequence")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_forum", nullable = false)
    private ForumIndicator type;
}
