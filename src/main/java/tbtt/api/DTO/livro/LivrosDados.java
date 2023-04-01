package tbtt.api.DTO.livro;

import jakarta.validation.constraints.NotBlank;
import tbtt.api.model.livro.Genero;

public record LivrosDados(
        @NotBlank
        String titulo,
        @NotBlank
        String autor,

        Genero genero
) {
}
