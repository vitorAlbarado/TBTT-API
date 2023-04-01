create table emprestimos(
    id bigint not null auto_increment,
    idLivro bigint not null,
    nomeAluno varchar(100) not null,
    matriculaAluno varchar(10) not null unique,
    tituloLivro varchar(100) not null,
    turmaAluno varchar(100) not null,



    primary key(id)

);