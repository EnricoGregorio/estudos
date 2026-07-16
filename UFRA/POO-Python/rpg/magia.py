class Magia:
    """Representa uma magia que guarda estado e atua como função."""

    def __init__(self, nome: str, dano: int) -> None:
        self.nome = nome
        self.dano = dano

    def __call__(self, alvo) -> int:
        alvo.receber_dano(self.dano, "magico")
        # print(f"Magia '{self.nome}' lançada! Causou {self.dano} de dano.")
        return self.dano
