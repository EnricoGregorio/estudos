from rpg.monstro import Monstro
from rpg.item import Item

class Goblin(Monstro):
    """Monstro fraco. Herda tudo da base - categorização pura."""

    def __init__(self, nome: str = "Goblin", vida: int = 30, forca: int = 5, nivel: int = 1) -> None:
        super().__init__(nome, vida, forca, tipo="humanoide", nivel=nivel)

class Dragao(Monstro):
    """Monstro poderioso com baforada de fogo."""

    tipo_dano: str = "fogo"

    def __init__(self, nome: str = "Dragão Vermelho", vida: int = 150, forca: int = 25, nivel: int = 5) -> None:
        super().__init__(nome, vida, forca, tipo="besta", nivel=nivel)

    def _calcular_dano(self, alvo) -> int:
        return self.forca + 10
    
class Esqueleto(Monstro):
    """Morto-vivo resistente a dano físico."""

    def __init__(self, nome: str = "Esqueleto", vida: int = 60, forca: int = 12, nivel: int = 1) -> None:
        super().__init__(nome, vida, forca, tipo="morto-vivo", nivel=nivel)

    def receber_dano(self, dano: int, tipo_dano: str = "fisico") -> None:
        if tipo_dano == "fisico":
            dano = dano // 2
        super().receber_dano(dano, tipo_dano)

def gerar_loot(monstro):
    yield Item("Poção menor", "pocao", 20)

    # Se o monstro for de nível 3 ou mais, larga uma poção extra.
    if monstro.nivel >= 3:
        yield Item("Poção Maior", "pocao", 50)

    # Se o monstro for um Dragão, larga uma arma.
    if monstro.tipo == "besta" or monstro.tipo == "dragao":
        yield Item("Presa de Dragão", "arma", 80)
