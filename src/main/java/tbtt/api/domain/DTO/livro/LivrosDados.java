package tbtt.api.domain.DTO.livro;

import jakarta.validation.constraints.NotBlank;
import tbtt.api.domain.model.livro.Genero;

public record LivrosDados(
        @NotBlank
        String titulo,
        @NotBlank
        String autor,

        Genero genero
) {
}
