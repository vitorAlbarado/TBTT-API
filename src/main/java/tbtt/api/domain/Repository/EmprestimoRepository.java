package tbtt.api.domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tbtt.api.domain.model.emprestimo.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
