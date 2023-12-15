package unb.azul.hortencias.blog.feudal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import unb.azul.hortencias.blog.feudal.dto.PostDTO;
import unb.azul.hortencias.blog.feudal.model.AccountEntity;
import unb.azul.hortencias.blog.feudal.model.PostEntity;
import unb.azul.hortencias.blog.feudal.model.enumerator.ForumIndicator;
import unb.azul.hortencias.blog.feudal.service.AccountService;
import unb.azul.hortencias.blog.feudal.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final Integer ID_USER = 2;

    private final PostService service;

    private final AccountService accountService;

    @PostMapping
    ResponseEntity<PostEntity> createPost(@RequestBody PostDTO post, @ApiIgnore Authentication authentication) {

        AccountEntity account = accountService.getAccountByEmail(authentication.getName());

        try {
            return new ResponseEntity<>(service.createPost(post, account), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<PostEntity> getPostById(@PathVariable Integer id) {

        PostEntity post = service.getPostById(id);

        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<PostEntity> updatePost(@RequestBody PostDTO post, @PathVariable("id") Integer idPost) {

        PostEntity postEntity = service.updatePost(post, idPost);

        if (postEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(postEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Integer> deletePost(@PathVariable("id") Integer idPost) {

        if (service.deletePost(idPost) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(idPost, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<PostEntity>> getAllPosts() {
        List<PostEntity> posts = service.getAllPosts();

        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    ResponseEntity<List<PostEntity>> getAllPostsByAccount(@PathVariable("id") Integer idAccount) {

        List<PostEntity> posts = service.getAllPostsByAccount(idAccount);

        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/forum/{forumType}")
    ResponseEntity<List<PostEntity>> getAllPostsByForum(@PathVariable("forumType") ForumIndicator forumType) {

        List<PostEntity> posts = service.getAllPostsByForum(forumType);

        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
