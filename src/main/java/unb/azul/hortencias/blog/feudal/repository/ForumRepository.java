package unb.azul.hortencias.blog.feudal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import unb.azul.hortencias.blog.feudal.model.ForumEntity;

@Repository
public interface ForumRepository extends JpaRepository<ForumEntity, Integer> {
    @Query(value = "select * from tb_forum where tp_forum = cast(:forumType as tp_forum)", nativeQuery = true)
    ForumEntity findByType(@Param("forumType") String forumType);
}
