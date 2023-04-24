package tbtt.api.DTO.emprestimo;

import java.time.LocalDateTime;

public record EmprestimoDetalhes(
        Long id,
        Long idAluno,
        Long idLivro,
        LocalDateTime data
) {
}
