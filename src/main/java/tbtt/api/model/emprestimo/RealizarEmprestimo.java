package tbtt.api.model.emprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tbtt.api.DTO.emprestimo.EmprestimoDados;
import tbtt.api.Repository.AlunoRepository;
import tbtt.api.Repository.EmprestimoRepository;
import tbtt.api.Repository.LivroRepository;
import tbtt.api.controller.EmprestimoController;

@Service
public class RealizarEmprestimo {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public void emprestar(EmprestimoDados dados) {
        var aluno = alunoRepository.getReferenceById(dados.idAluno());
        var livro = livroRepository.getReferenceById(dados.idLivro());
        var emprestimo = new Emprestimo(null,aluno,livro,dados.data());
        emprestimoRepository.save(emprestimo);
    }
}
