class Item:
    """Representa qualquer item do jogo, podendo ser uma poção, uma arma ou um escudo."""

    def __init__(self, nome: str, descricao: str, valor: int):
        self.nome = nome.capitalize()
        self.descricao = descricao
        self.valor = valor
