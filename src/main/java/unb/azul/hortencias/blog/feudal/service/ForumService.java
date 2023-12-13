package unb.azul.hortencias.blog.feudal.service;

import unb.azul.hortencias.blog.feudal.model.ForumEntity;
import unb.azul.hortencias.blog.feudal.model.enumerator.ForumIndicator;

public interface ForumService {
    ForumEntity getForumByType(ForumIndicator type);
}
