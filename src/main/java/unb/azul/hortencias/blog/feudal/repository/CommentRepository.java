package unb.azul.hortencias.blog.feudal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import unb.azul.hortencias.blog.feudal.model.AccountEntity;
import unb.azul.hortencias.blog.feudal.model.CommentEntity;
import unb.azul.hortencias.blog.feudal.model.PostEntity;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    List<CommentEntity> findAllByPost(PostEntity post);

    @Query(value =
            "select " +
            "   tc.* " +
            "from " +
            "   tb_comment tc " +
            "inner join tb_post tp on " +
            "   tp.id_post = tc.id_post " +
            "inner join tb_account ta on " +
            "   ta.id_account = tp.id_account " +
            "where ta.id_account = :idAccount " +
            "order by dh_created", nativeQuery = true)
    List<CommentEntity> findAllByAccountId(Integer idAccount);
}
