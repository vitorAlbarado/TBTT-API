package tbtt.api.domain.model.emprestimo;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EmprestimoDados(
        @NotNull
        Long idAluno,
        @NotNull
        Long idLivro,
        @NotNull
        LocalDateTime data,
        int prazo
) {
}
