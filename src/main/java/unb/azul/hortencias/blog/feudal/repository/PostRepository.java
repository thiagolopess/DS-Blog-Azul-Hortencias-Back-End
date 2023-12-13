package unb.azul.hortencias.blog.feudal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unb.azul.hortencias.blog.feudal.model.AccountEntity;
import unb.azul.hortencias.blog.feudal.model.ForumEntity;
import unb.azul.hortencias.blog.feudal.model.PostEntity;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {

    List<PostEntity> findAllByAccount(AccountEntity account);

    List<PostEntity> findAllByForum(ForumEntity forum);
}
