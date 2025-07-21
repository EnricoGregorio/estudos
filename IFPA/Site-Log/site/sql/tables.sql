CREATE DATABASE dbbateponto;

USE dbbateponto;

CREATE TABLE Projetos(
    id INT AUTO_INCREMENT,
    projeto VARCHAR(24) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Espera(
    id INT AUTO_INCREMENT,
    tagid VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY(id)
);

CREATE TABLE Discentes(
    id INT AUTO_INCREMENT,
    tagid VARCHAR(30) NOT NULL UNIQUE,
    nome VARCHAR(30) NOT NULL,
    projeto INT NOT NULL,
    FOREIGN KEY(projeto) REFERENCES Projetos(id),
    PRIMARY KEY(id)
);

CREATE TABLE Horario(
    id INT AUTO_INCREMENT,
    estudante INT NOT NULL,
    bateponto BOOLEAN NOT NULL,
    hora TIME NOT NULL,
    dia DATE NOT NULL,
    FOREIGN KEY(estudante) REFERENCES Discentes(id),
    PRIMARY KEY(id)
);