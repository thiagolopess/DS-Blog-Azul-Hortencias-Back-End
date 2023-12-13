package unb.azul.hortencias.blog.feudal.service;

import unb.azul.hortencias.blog.feudal.dto.PostDTO;
import unb.azul.hortencias.blog.feudal.model.AccountEntity;
import unb.azul.hortencias.blog.feudal.model.PostEntity;
import unb.azul.hortencias.blog.feudal.model.enumerator.ForumIndicator;

import java.util.List;

public interface PostService {
    PostEntity createPost(PostDTO post, AccountEntity account);

    PostEntity getPostById(Integer id);

    PostEntity updatePost(PostDTO post, Integer idPost);

    Integer deletePost(Integer id);

    List<PostEntity> getAllPosts();

    List<PostEntity> getAllPostsByAccount(Integer accountId);

    List<PostEntity> getAllPostsByForum(ForumIndicator forumType);
}
