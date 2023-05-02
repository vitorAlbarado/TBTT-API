package tbtt.api.domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tbtt.api.domain.model.livro.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long>{
}
