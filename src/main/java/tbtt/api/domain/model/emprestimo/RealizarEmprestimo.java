package tbtt.api.domain.model.emprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tbtt.api.domain.Repository.AlunoRepository;
import tbtt.api.domain.Repository.EmprestimoRepository;
import tbtt.api.domain.Repository.LivroRepository;
import tbtt.api.domain.model.aluno.Aluno;
import tbtt.api.infra.exception.ValidacaoException;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Optional;

@Service
public class RealizarEmprestimo {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public void emprestar(EmprestimoDados dados) {


        var alunoComEmprestimoAtivo = emprestimoRepository.alunoComPendencia(dados.idAluno());

        if (!livroRepository.existsById(dados.idLivro())) {
            throw new ValidacaoException("Livro não encontrado");
        }if (!alunoRepository.existsById(dados.idAluno())) {
            throw new ValidacaoException("Aluno não encontrado");
        }
        if (emprestimoRepository.LivroEmprestado(dados.idLivro()) != null){
            throw new ValidacaoException("Livro com emprestimo ativo");
        }
        if (!alunoComEmprestimoAtivo.isEmpty()){
            alunoComEmprestimoAtivo.forEach(e -> verificaEmprestimoAtivo(e));
            System.out.println(alunoComEmprestimoAtivo);
        }



        var aluno = alunoRepository.findById(dados.idAluno()).get();
        var livro = livroRepository.findById(dados.idLivro()).get();
        var emprestimo = new Emprestimo(null,aluno,livro,dados.data(),true, dados.prazo());
        emprestimoRepository.save(emprestimo);
   }

    private void verificaEmprestimoAtivo(Long e) {
        var emprestimo = emprestimoRepository.getReferenceById(e);
        var dataEmprestimo = emprestimo.getData();
        var prazo = emprestimo.getPrazo();
        var dataAtual = LocalDateTime.now();
        if (dataAtual.isAfter(dataEmprestimo.plusDays(prazo))){
            throw new ValidacaoException("Aluno com emprestimo ativo");
        }
    }


}