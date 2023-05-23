package tbtt.api.domain.model.emprestimo;

import tbtt.api.domain.model.aluno.Aluno;
import tbtt.api.domain.model.emprestimo.Emprestimo;
import tbtt.api.domain.model.livro.Livro;

import java.time.LocalDateTime;

public record EmprestimoDetalhes(
        Long id,
        Long idAluno,
        String nome,
        String matricula,
        String turma,
        Long idLivro,
        String titulo,
        LocalDateTime data,
        int prazo,
        boolean ativo

) {
    public EmprestimoDetalhes(Emprestimo dados){
    this(dados.getId(), dados.getAluno().getId(),dados.getAluno().getNome(),dados.getAluno().getMatricula(),dados.getAluno().getTurma(),dados.getLivro().getId(),dados.getLivro().getTitulo(),dados.getData(), dados.getPrazo(), dados.getAtivo());

    }

}
