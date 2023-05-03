package tbtt.api.domain.model.emprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tbtt.api.domain.Repository.AlunoRepository;
import tbtt.api.domain.Repository.EmprestimoRepository;
import tbtt.api.domain.Repository.LivroRepository;
import tbtt.api.infra.exception.ValidacaoException;

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
        }if (!alunoRepository.existsById(dados.idAluno())) {
            throw new ValidacaoException("Aluno não encontrado");
        }

       // var aluno = validaAluno(dados);
        var livro = livroRepository.getReferenceById(dados.idLivro());
        //var emprestimo = new Emprestimo(null, aluno, livro, dados.data(), dados.prazo(),true);
        // emprestimoRepository.save(emprestimo);
    }


}