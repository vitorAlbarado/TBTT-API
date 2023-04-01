package tbtt.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tbtt.api.model.livro.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
