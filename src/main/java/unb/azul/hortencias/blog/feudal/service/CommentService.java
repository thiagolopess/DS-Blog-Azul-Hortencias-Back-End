package unb.azul.hortencias.blog.feudal.service;

import unb.azul.hortencias.blog.feudal.dto.CommentDTO;
import unb.azul.hortencias.blog.feudal.model.CommentEntity;

import java.util.List;

public interface CommentService {
    CommentEntity createComment(CommentDTO comment, Integer postId, Integer accountId);

    CommentEntity getCommentById(Integer id);

    CommentEntity updateComment(CommentDTO dto, Integer commentId);

    Integer deleteComment(Integer id);

    List<CommentEntity> getAllCommentsByPost(Integer postId);

    List<CommentEntity> getAllCommentsByAccount(Integer accountId);

    List<CommentEntity> getAllComments();
}
