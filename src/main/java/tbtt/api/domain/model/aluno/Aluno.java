package tbtt.api.domain.model.aluno;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "aluno")
@Table(name = "alunos")
@Getter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String matricula;
    private String turma;

    public Aluno(AlunoDados dados){
        this.nome = dados.nome();
        this.matricula = dados.matricula();
        this.turma = dados.turma();

    }
    public Aluno(){}

    public void atualizarDados(AlunoDadosAtualizados dados){
        if (dados.nome() != null){this.nome = dados.nome();}
        if (dados.matricula() != null){this.matricula = dados.matricula();}
        if (dados.turma() != null){this.turma = dados.turma();}

    }


}
