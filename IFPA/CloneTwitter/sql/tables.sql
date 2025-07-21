CREATE DATABASE dbsite;

USE dbsite;

CREATE TABLE Usuarios(
    id INT AUTO_INCREMENT,
    nome_usuario VARCHAR(16) NOT NULL UNIQUE,
    email VARCHAR(64) NOT NULL UNIQUE,
    senha VARCHAR(16) NOT NULL,
    dt_usuario DATE NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Perfis(
    id INT AUTO_INCREMENT,
    nome VARCHAR(16) NOT NULL,
    sobrenome VARCHAR(32) NOT NULL,
    data_nascimento DATE NOT NULL,
    telefone VARCHAR(16) UNIQUE,
    bio VARCHAR(160),
    id_usuario INT NOT NULL UNIQUE,
    FOREIGN KEY(id_usuario) REFERENCES Usuarios(id),
    PRIMARY KEY(id)
);

CREATE TABLE Publicacoes(
    id INT AUTO_INCREMENT,
    texto VARCHAR(280) NOT NULL,
    dt_publicacao DATE NOT NULL,
    id_usuario INT NOT NULL,
    FOREIGN KEY(id_usuario) REFERENCES Usuarios(id),
    PRIMARY KEY(id)
);

CREATE TABLE Comentarios(
    id INT AUTO_INCREMENT,
    texto VARCHAR(128) NOT NULL,
    id_usuario INT NOT NULL,
    id_publicacao INT NOT NULL,
    FOREIGN KEY(id_usuario) REFERENCES Usuarios(id),
    FOREIGN KEY(id_publicacao) REFERENCES Publicacoes(id),
    PRIMARY KEY(id)
);

CREATE TABLE Seguidores(
    id INT AUTO_INCREMENT,
    id_seguidor INT NOT NULL,
    id_seguindo INT NOT NULL,
    data_registro DATE NOT NULL,
    FOREIGN KEY(id_seguidor) REFERENCES Usuarios(id),
    FOREIGN KEY(id_seguindo) REFERENCES Usuarios(id),
    PRIMARY KEY(id)
);