USE dbsite;

INSERT INTO
    Usuarios(nome_usuario, email, senha, dt_usuario)
VALUES
    (
        "@greg",
        "greg@gmail.com",
        "Show123casa",
        "2022-11-07"
    ),
    (
        "@fabs",
        "degenerado@gmail.com",
        "123Jordan",
        "2022-11-08"
    );

INSERT INTO
    Perfis(
        nome,
        sobrenome,
        data_nascimento,
        telefone,
        bio,
        id_usuario
    )
VALUES
    (
        "Enrico",
        "Sobrinho Gregório",
        "2000-01-01",
        "(91) 90000-0000",
        "Olá, eu sou o Enrico, mas podem me chamar de Greg!",
        1
    ),
    (
        "Fabricio",
        "Cesar Capistrano Moura",
        "2000-02-02",
        "(91) 91111-1111",
        "Olá, eu sou o Fabricio, mas podem me chamar de Fabs. É um prazer conhecê-los my manos!",
        2
    );

INSERT INTO
    Publicacoes(texto, dt_publicacao, id_usuario)
VALUES
    (
        "copiaru o twetter mermão!!!!! Xiqes de duer",
        "2022-11-07",
        1
    ),
    (
        "Ai minha voida",
        "2022-11-07",
        1
    ),
    (
        "E aí meus queridos",
        "2022-11-08",
        2
    );

INSERT INTO
    Comentarios(texto, id_usuario, id_publicacao)
VALUES
    ("É vdd manos", 2, 1),
    ("Se é loko, mó onda bixo", 2, 1),
    ("Olokinho meu", 2, 3);

INSERT INTO
    Seguidores(id_seguindo, id_seguidor, data_registro)
VALUES
    (1, 2, "2022-11-07");