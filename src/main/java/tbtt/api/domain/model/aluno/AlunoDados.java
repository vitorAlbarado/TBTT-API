package tbtt.api.domain.model.aluno;

import jakarta.validation.constraints.NotBlank;

public record AlunoDados(
        @NotBlank
        String nome,
        @NotBlank
        String turma,
        @NotBlank
        String matricula
        ) {
}
