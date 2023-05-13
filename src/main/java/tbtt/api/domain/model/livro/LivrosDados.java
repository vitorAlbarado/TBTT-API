package tbtt.api.domain.model.livro;

import jakarta.validation.constraints.NotBlank;
import tbtt.api.domain.model.aluno.Aluno;
import tbtt.api.domain.model.aluno.AlunoDados;
import tbtt.api.domain.model.livro.Genero;

public record LivrosDados(
        @NotBlank
        String titulo,
        @NotBlank
        String autor,
        Genero genero
) {
        public LivrosDados (Livro dados){
                this(dados.getTitulo(), dados.getAutor(), dados.getGenero());
        }
}
