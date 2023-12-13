package unb.azul.hortencias.blog.feudal.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import unb.azul.hortencias.blog.feudal.dto.CommentDTO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_comment", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {

    @Id
    @Column(name = "id_comment")
    @SequenceGenerator(name = "commentSequence", sequenceName = "sq_comment", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentSequence")
    private Integer id;

    @Column(name = "text", nullable = false)
    private String content;

    @Column(name = "dh_created", nullable = false)
    private LocalDateTime date;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_post", referencedColumnName = "id_post")
    private PostEntity post;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_account", referencedColumnName = "id_account")
    private AccountEntity account;

    public CommentEntity(CommentDTO dto, PostEntity post, AccountEntity account) {
        this.content = dto.getContent();
        this.post = post;
        this.account = account;
    }
    @PrePersist
    public void prePersist() {
        this.date = LocalDateTime.now();
    }

}
