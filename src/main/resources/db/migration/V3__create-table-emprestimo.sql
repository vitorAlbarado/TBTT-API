create table emprestimos(

    id bigint not null auto_increment,
    aluno_id bigint not null,
    livro_id bigint not null,
    data datetime not null,

    primary key(id),
    constraint fk_emprestimos_aluno_id foreign key(aluno_id) references alunos(id),
    constraint fk_emprestimos_livro_id foreign key(livro_id) references livros(id)

);