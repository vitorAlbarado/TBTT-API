package tbtt.api.domain.model.aluno;

import tbtt.api.domain.model.aluno.Aluno;

public record ListagemAluno(String nome, String matricula, String turma) {

    public ListagemAluno(Aluno aluno){

        this(aluno.getNome(), aluno.getMatricula(), aluno.getTurma());
    }
}
