create table alunos(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    matricula varchar(10) not null unique,
    turma varchar(100) not null,



    primary key(id)

);