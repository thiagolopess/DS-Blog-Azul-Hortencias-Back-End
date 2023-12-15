package unb.azul.hortencias.blog.feudal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import unb.azul.hortencias.blog.feudal.dto.CommentDTO;
import unb.azul.hortencias.blog.feudal.model.AccountEntity;
import unb.azul.hortencias.blog.feudal.model.CommentEntity;
import unb.azul.hortencias.blog.feudal.service.AccountService;
import unb.azul.hortencias.blog.feudal.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final Integer ID_USER = 2;

    private final CommentService commentService;

    private final AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<CommentEntity> getCommentById(@PathVariable Integer id) {
        CommentEntity comment = commentService.getCommentById(id);

        if (comment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentEntity> updateComment(@RequestBody CommentDTO comment, @PathVariable("id") Integer idComment) {

        CommentEntity commentEntity = commentService.updateComment(comment, idComment);

        if (commentEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(commentEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteComment(@PathVariable("id") Integer idComment) {

        if (commentService.deleteComment(idComment) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(idComment, HttpStatus.OK);
    }

    @PostMapping("/{idPost}")
    public ResponseEntity<CommentEntity> createComment(@RequestBody CommentDTO comment, @PathVariable Integer idPost, @ApiIgnore Authentication authentication) {
        AccountEntity account = accountService.getAccountByEmail(authentication.getName());

        try {
            CommentEntity commentEntity = commentService.createComment(comment, idPost, account.getId());

            return new ResponseEntity<>(commentEntity, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<CommentEntity>> getAllComments() {
        List<CommentEntity> comments = commentService.getAllComments();

        HttpStatus status = comments.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return new ResponseEntity<>(comments, status);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<List<CommentEntity>> getAllCommentsByPost(@PathVariable Integer id) {
        List<CommentEntity> comments = commentService.getAllCommentsByPost(id);

        HttpStatus status = comments.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return new ResponseEntity<>(comments, status);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<List<CommentEntity>> getAllCommentsByAccount(@PathVariable Integer id) {
        List<CommentEntity> comments = commentService.getAllCommentsByAccount(id);

        HttpStatus status = comments.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return new ResponseEntity<>(comments, status);
    }
}
