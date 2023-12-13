package unb.azul.hortencias.blog.feudal.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unb.azul.hortencias.blog.feudal.dto.CommentDTO;
import unb.azul.hortencias.blog.feudal.model.AccountEntity;
import unb.azul.hortencias.blog.feudal.model.CommentEntity;
import unb.azul.hortencias.blog.feudal.model.PostEntity;
import unb.azul.hortencias.blog.feudal.repository.CommentRepository;
import unb.azul.hortencias.blog.feudal.service.AccountService;
import unb.azul.hortencias.blog.feudal.service.CommentService;
import unb.azul.hortencias.blog.feudal.service.PostService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final PostService postService;

    private final AccountService accountService;

    private final CommentRepository repository;

    @Override
    public CommentEntity createComment(CommentDTO comment, Integer postId, Integer accountId) {
        PostEntity post = postService.getPostById(postId);
        AccountEntity account = accountService.getAccountById(accountId);
        return repository.save(new CommentEntity(comment, post, account));
    }

    @Override
    public CommentEntity getCommentById(Integer commentId) {
        return repository.findById(commentId).orElse(null);
    }

    @Override
    public CommentEntity updateComment(CommentDTO dto, Integer commentId) {
        CommentEntity commentEntity = getCommentById(commentId);

        if (commentEntity == null) {
            return null;
        }

        commentEntity.setContent(dto.getContent());
        return repository.save(commentEntity);
    }

    @Override
    public Integer deleteComment(Integer idComment) {
        CommentEntity commentEntity = getCommentById(idComment);

        if (commentEntity == null) {
            return null;
        }

        repository.deleteById(idComment);

        return idComment;
    }

    @Override
    public List<CommentEntity> getAllCommentsByPost(Integer postId) {
        PostEntity post = postService.getPostById(postId);
        return repository.findAllByPost(post);
    }

    @Override
    public List<CommentEntity> getAllCommentsByAccount(Integer accountId) {
        return repository.findAllByAccountId(accountId);
    }

    @Override
    public List<CommentEntity> getAllComments() {
        return repository.findAll();
    }
}
