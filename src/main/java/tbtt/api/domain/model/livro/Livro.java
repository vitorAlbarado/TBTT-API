package tbtt.api.domain.model.livro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tbtt.api.domain.DTO.livro.LivrosDados;


@Entity(name = "livro")
@Table(name = "livros")
@Getter
@AllArgsConstructor
@NoArgsConstructor
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

}
