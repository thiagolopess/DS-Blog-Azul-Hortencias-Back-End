package unb.azul.hortencias.blog.feudal.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unb.azul.hortencias.blog.feudal.dto.PostDTO;
import unb.azul.hortencias.blog.feudal.model.AccountEntity;
import unb.azul.hortencias.blog.feudal.model.ForumEntity;
import unb.azul.hortencias.blog.feudal.model.PostEntity;
import unb.azul.hortencias.blog.feudal.model.enumerator.ForumIndicator;
import unb.azul.hortencias.blog.feudal.repository.PostRepository;
import unb.azul.hortencias.blog.feudal.service.AccountService;
import unb.azul.hortencias.blog.feudal.service.ForumService;
import unb.azul.hortencias.blog.feudal.service.PostService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final ForumService forumService;

    private final AccountService accountService;

    private final PostRepository repository;

    @Override
    public PostEntity createPost(PostDTO post, AccountEntity account) {
        ForumEntity forum = forumService.getForumByType(post.getForum());
        return repository.save(new PostEntity(post, account, forum));
    }

    @Override
    public PostEntity getPostById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public PostEntity updatePost(PostDTO dto, Integer idPost) {

        PostEntity post = getPostById(idPost);

        if (post == null) {
            return null;
        }

        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());

        return repository.save(post);
    }

    @Override
    public Integer deletePost(Integer id) {
        if (getPostById(id) == null) {
            return null;
        }
        repository.deleteById(id);
        return id;
    }

    @Override
    public List<PostEntity> getAllPosts() {
        return repository.findAll();
    }

    @Override
    public List<PostEntity> getAllPostsByAccount(Integer accountId) {
        return repository.findAllByAccount(accountService.getAccountById(accountId));
    }

    @Override
    public List<PostEntity> getAllPostsByForum(ForumIndicator forumType) {
        return repository.findAllByForum(forumService.getForumByType(forumType));
    }
}
