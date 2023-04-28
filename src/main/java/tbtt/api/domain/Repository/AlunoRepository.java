package tbtt.api.domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tbtt.api.domain.DTO.emprestimo.EmprestimoDados;
import tbtt.api.domain.model.aluno.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    boolean AlunoSemPendencia(Long idAluno);
}
