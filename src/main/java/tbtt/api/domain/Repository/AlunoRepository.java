package tbtt.api.domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tbtt.api.domain.model.aluno.Aluno;

import java.util.List;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long>{

}
