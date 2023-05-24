package tbtt.api.domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tbtt.api.domain.model.aluno.Aluno;
import tbtt.api.domain.model.emprestimo.Emprestimo;
import tbtt.api.domain.model.emprestimo.EmprestimoDados;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo,Long>{
    @Query(
           """
           select e.id
           from Emprestimo e
           where
           e.aluno.id = :idAluno
           and
           e.aluno.id is not null
           and
           e.ativo != 0
           """
    )
    List<Long> alunoComPendencia(Long idAluno);

    @Query(
            """
            select e.id
            from Emprestimo e
            where
            e.livro.id = :idLivro
            and
            e.livro.id is not null
            and
            e.ativo != 0
            """
    )
    Long LivroEmprestado(Long idLivro);

    @Query("""
            select e
            from Emprestimo e 
            where
            e.livro.id = :idLivro
            and
            e.ativo != 0
            
            """)
    Emprestimo findByLivro(Long idLivro);




}
