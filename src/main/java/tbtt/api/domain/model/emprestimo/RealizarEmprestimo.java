package tbtt.api.domain.model.emprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tbtt.api.domain.DTO.emprestimo.EmprestimoDados;
import tbtt.api.domain.Repository.AlunoRepository;
import tbtt.api.domain.Repository.EmprestimoRepository;
import tbtt.api.domain.Repository.LivroRepository;
import tbtt.api.domain.model.aluno.Aluno;
import tbtt.api.infra.exception.ValidacaoException;

import java.time.LocalDateTime;

@Service
public class RealizarEmprestimo {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public void emprestar(EmprestimoDados dados) {

        if (!livroRepository.existsById(dados.idLivro())) {
            throw new ValidacaoException("Livro não encontrado");
        }
        var aluno = validaAluno(dados);
        var livro = livroRepository.getReferenceById(dados.idLivro());
        var emprestimo = new Emprestimo(null, aluno, livro, dados.data(), dados.prazo(),true);
        emprestimoRepository.save(emprestimo);
    }

    private Aluno validaAluno(EmprestimoDados dados) {
        var dataAtual = LocalDateTime.now();
        var dataEmprestimo = dados.data();

        if (!alunoRepository.existsById(dados.idAluno())) {
            throw new ValidacaoException("Aluno não encontrado");
        }
        var alunoApto = alunoRepository.AlunoSemPendencia(dados.idAluno());



        return alunoRepository.getReferenceById(dados.idAluno());
    }
}