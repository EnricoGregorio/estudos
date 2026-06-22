from rpg.monstro import Monstro

class Goblin(Monstro):
    """Monstro fraco. Herda tudo da base - categorização pura."""

    def __init__(self, nome: str = "Goblin", vida: int = 30, forca: int = 5, nivel: int = 1) -> None:
        super().__init__(nome, vida, forca, tipo="humanoide", nivel=nivel)

class Dragao(Monstro):
    """Monstro poderioso com baforada de fogo."""

    tipo_dano: str = "fogo"

    def __init__(self, nome: str = "Dragão Vermelho", vida: int = 150, forca: int = 25, nivel: int = 5) -> None:
        super().__init__(nome, vida, forca, tipo="besta", nivel=nivel)

    def atacar(self, alvo) -> int:
        dano = self.forca + 10

        alvo.receber_dano(dano, self.tipo_dano)
        return dano
    
class Esqueleto(Monstro):
    """Morto-vivo resistente a dano físico."""

    def __init__(self, nome: str = "Esqueleto", vida: int = 60, forca: int = 12, nivel: int = 1) -> None:
        super().__init__(nome, vida, forca, tipo="morto-vivo", nivel=nivel)

    def receber_dano(self, dano: int, tipo_dano: str = "fisico") -> None:
        if tipo_dano == "fisico":
            dano = dano // 2
        super().receber_dano(dano, tipo_dano)
