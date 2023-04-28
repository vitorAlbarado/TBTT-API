package tbtt.api.domain.model.aluno;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tbtt.api.domain.DTO.aluno.AlunoDados;

@Entity(name = "aluno")
@Table(name = "alunos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String matricula;
    private String turma;

    public Aluno(AlunoDados dados){
        this.matricula = dados.matricula();
        this.nome = dados.nome();
        this.turma = dados.turma();
    }

}
