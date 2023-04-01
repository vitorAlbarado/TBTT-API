package tbtt.api.DTO.livro;

import tbtt.api.DTO.aluno.ListagemAluno;
import tbtt.api.model.livro.Genero;
import tbtt.api.model.livro.Livro;

public record ListagemLivro(String titulo, String autor, Genero genero) {

    public ListagemLivro(Livro dados){
        this(dados.getTitulo(), dados.getAutor(), dados.getGenero());
    }
}
