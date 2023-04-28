package tbtt.api.domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tbtt.api.domain.model.livro.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
