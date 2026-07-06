from rpg.personagem import Personagem

class Arqueiro(Personagem):
    """Herói focado em ataques à distância."""

    def __init__(self, nome: str, vida: int, forca: int, nivel: int = 1, xp: int = 0, flechas: int = 20) -> None:
        super().__init__(nome, vida, forca, nivel, xp)
        self.flechas = flechas

    def _calcular_dano(self, alvo) -> int:
        if self.flechas > 0:
            self.flechas -= 1
            dano = int(self.forca * 1.5)
        else:
            dano = self.forca // 2

        return dano
    
    def golpe_especial(self, alvo) -> int:
        if hasattr(self, 'flechas') and self.flechas >= 3:
            self.flechas -= 3
            dano = self.forca * 3
        else:
            dano = self.forca // 2

        alvo.receber_dano(dano, "fisico")
        return dano
