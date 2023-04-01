package tbtt.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tbtt.api.model.aluno.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
