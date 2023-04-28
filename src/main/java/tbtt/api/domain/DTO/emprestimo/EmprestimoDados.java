package tbtt.api.domain.DTO.emprestimo;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EmprestimoDados(
        @NotNull
        Long idAluno,
        @NotNull
        Long idLivro,
        @NotNull
//        @Future
        LocalDateTime data,
        int prazo
) {
}
