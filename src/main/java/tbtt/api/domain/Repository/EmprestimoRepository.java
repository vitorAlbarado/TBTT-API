package tbtt.api.domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tbtt.api.domain.model.emprestimo.Emprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo,Long>{
}
