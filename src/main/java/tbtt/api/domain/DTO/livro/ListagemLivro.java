package tbtt.api.domain.DTO.livro;

import tbtt.api.domain.model.livro.Genero;
import tbtt.api.domain.model.livro.Livro;

public record ListagemLivro(String titulo, String autor, Genero genero) {

    public ListagemLivro(Livro dados){
        this(dados.getTitulo(), dados.getAutor(), dados.getGenero());
    }
}
