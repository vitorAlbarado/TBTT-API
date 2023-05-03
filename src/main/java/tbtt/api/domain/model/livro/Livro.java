package tbtt.api.domain.model.livro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Entity(name = "livro")
@Table(name = "livros")
@Getter
@AllArgsConstructor

@EqualsAndHashCode(of = "id")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Genero genero;

    public Livro(LivrosDados dados){
        this.titulo = dados.titulo();
        this.autor = dados.autor();
        this.genero = dados.genero();
    }
    public Livro(){

    }

}
