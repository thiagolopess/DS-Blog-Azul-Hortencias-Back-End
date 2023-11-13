package unb.azul.hortencias.blog.feudal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unb.azul.hortencias.blog.feudal.model.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
}
