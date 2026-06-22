from rpg.personagem import Personagem

class Mago(Personagem):
    """Herói focado em magia."""

    tipo_dano: str = "magico"

    def __init__(self, nome: str, vida: int, forca: int, nivel: int = 1, xp: int = 0, mana: int = 100) -> None:
        super().__init__(nome, vida, forca, nivel, xp)
        self.mana = mana

    def atacar(self, alvo) -> int:
        dano_base = super().atacar(alvo)
        dano_magico = 5
        
        alvo.receber_dano(dano_magico, self.tipo_dano)
        return dano_base + dano_magico
