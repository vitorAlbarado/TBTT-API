package tbtt.api.domain.DTO.emprestimo;

import tbtt.api.domain.model.emprestimo.Emprestimo;

public record EmprestimoDetalhes(
        Long id
//        Long idAluno,
//        Long idLivro,
//        LocalDateTime data
) {
    public EmprestimoDetalhes(Emprestimo dados){
    this(dados.getId());

    }

}
