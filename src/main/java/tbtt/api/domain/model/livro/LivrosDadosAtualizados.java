package tbtt.api.domain.model.livro;

import jakarta.validation.constraints.NotNull;

public record LivrosDadosAtualizados(@NotNull Long id, String titulo, String autor) {

}
