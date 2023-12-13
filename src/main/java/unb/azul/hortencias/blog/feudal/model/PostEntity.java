package unb.azul.hortencias.blog.feudal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import unb.azul.hortencias.blog.feudal.dto.PostDTO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "tb_post", schema = "public")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_account", referencedColumnName = "id_account")
    private AccountEntity account;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_forum", referencedColumnName = "id_forum")
    private ForumEntity forum;

    public PostEntity(PostDTO dto, AccountEntity account, ForumEntity forum) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.account = account;
        this.forum = forum;
    }

    @PrePersist
    public void prePersist() {
        this.date = LocalDateTime.now();
    }
}
