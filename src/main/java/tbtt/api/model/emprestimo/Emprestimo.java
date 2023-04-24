package tbtt.api.model.emprestimo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tbtt.api.model.aluno.Aluno;
import tbtt.api.model.livro.Livro;

import java.time.LocalDateTime;

@Entity(name = "Emprestimo")
@Table(name = "emprestimos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_id")
    private Livro livro;

    private LocalDateTime data;

}
