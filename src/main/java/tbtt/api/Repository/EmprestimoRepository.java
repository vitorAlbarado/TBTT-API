package tbtt.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tbtt.api.model.aluno.Aluno;
import tbtt.api.model.emprestimo.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
