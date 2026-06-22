from rpg.personagem import Personagem

class Guerreiro(Personagem):
    """Herói focado em dano físico bruto, com armas brancas."""

    def __init__(self, nome: str, vida: int, forca: int, nivel: int = 1, xp: int = 0, arma: str = "Espada") -> None:
        super().__init__(nome, vida, forca, nivel, xp)
        self.arma = arma
        
    def _calcular_dano(self, alvo) -> int:
        return self.forca + 5
