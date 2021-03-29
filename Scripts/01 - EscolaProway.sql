 
create database EscolaProway;

use EscolaProway;

--drop table Perfil 
CREATE TABLE Perfil (
    IdPerfil int IDENTITY(1,1) NOT NULL,
    Nome varchar(50) NULL, 
    PRIMARY KEY (IdPerfil) 
);


  
--drop table Usuario
CREATE TABLE Usuario (
    IdUsuario int IDENTITY(1,1) NOT NULL,
    PerfilId int,
    Nome varchar(50),
    Email varchar(50),
    Logon varchar(50),
    Senha varchar(50),
    PRIMARY KEY (IdUsuario),
    FOREIGN KEY (PerfilId) REFERENCES Perfil(IdPerfil)
);


--drop table Disciplina 
CREATE TABLE Disciplina (
    IdDisciplina int IDENTITY(1,1) NOT NULL,
    Nome varchar(50) NULL, 
    PRIMARY KEY (IdDisciplina) 
);

--drop table Professor
CREATE TABLE Professor (
    IdProfessor int IDENTITY(1,1) NOT NULL,
    UsuarioId int,
    DisciplinaId int,
    PRIMARY KEY (IdProfessor),
    FOREIGN KEY (UsuarioId) REFERENCES Usuario(IdUsuario),
    FOREIGN KEY (DisciplinaId) REFERENCES Disciplina(IdDisciplina)
);

--drop table Aluno
CREATE TABLE Aluno (
    IdAluno int IDENTITY(1,1) NOT NULL,
    UsuarioId int,
    DisciplinaId int,
    PRIMARY KEY (IdAluno),
    FOREIGN KEY (UsuarioId) REFERENCES Usuario(IdUsuario),
    FOREIGN KEY (DisciplinaId) REFERENCES Disciplina(IdDisciplina)
);

--drop table Nota
CREATE TABLE Nota (
    IdNota int IDENTITY(1,1) NOT NULL,
    AlunoId int,
    Valor float,
    PRIMARY KEY (IdNota),
    FOREIGN KEY (AlunoId) REFERENCES Aluno(IdAluno)
);
  

---------------------------------------

 
 
 
 
INSERT Perfil (nome) VALUES ('Administrador'); 
INSERT Perfil (nome) VALUES ('Usuário'); 



INSERT Disciplina (nome) VALUES ('C# Fundamentos'); 
INSERT Disciplina (nome) VALUES ('Java Fundamentos'); 
INSERT Disciplina (nome) VALUES ('Linguagem de programação java'); 


select a.idaluno,u.*,p.nome perfil,d.iddisciplina,d.nome disciplina from aluno a
				inner join usuario u on u.IdUsuario= a.UsuarioId 
				inner join perfil p on p.IdPerfil= u.PerfilId 
				inner join disciplina d on d.IdDisciplina = a.DisciplinaId

 
 
 
 


