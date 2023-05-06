package tbtt.api.domain.model.aluno;

import jakarta.validation.constraints.NotNull;

public record AlunoDadosAtualizados(
        @NotNull
        Long id,
        String nome,
        String matricula,
        String turma
) {
}
