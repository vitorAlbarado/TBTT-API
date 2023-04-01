package tbtt.api.model.livro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tbtt.api.DTO.livro.LivrosDados;


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
