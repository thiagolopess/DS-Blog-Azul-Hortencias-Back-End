package unb.azul.hortencias.blog.feudal.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unb.azul.hortencias.blog.feudal.model.ForumEntity;
import unb.azul.hortencias.blog.feudal.model.enumerator.ForumIndicator;
import unb.azul.hortencias.blog.feudal.repository.ForumRepository;
import unb.azul.hortencias.blog.feudal.service.ForumService;



@Service
@RequiredArgsConstructor
public class ForumServiceImpl implements ForumService {

    private final ForumRepository repository;

    @Override
    public ForumEntity getForumByType(ForumIndicator type) {
        return repository.findByType(type.name());
    }

}
