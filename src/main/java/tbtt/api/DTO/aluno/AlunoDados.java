package tbtt.api.DTO.aluno;

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
