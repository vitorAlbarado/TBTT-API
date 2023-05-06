package tbtt.api.domain.model.emprestimo;

import tbtt.api.domain.model.aluno.Aluno;
import tbtt.api.domain.model.emprestimo.Emprestimo;
import tbtt.api.domain.model.livro.Livro;

import java.time.LocalDateTime;

public record EmprestimoDetalhes(
        Long id,
        Aluno aluno,
        Livro livro,
        LocalDateTime data
) {
    public EmprestimoDetalhes(Emprestimo dados){
    this(dados.getId(),dados.getAluno(),dados.getLivro(),dados.getData());

    }

}
