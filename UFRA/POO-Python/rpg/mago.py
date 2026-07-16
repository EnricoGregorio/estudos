from rpg.personagem import Personagem
from rpg.efeito import Efeito
from rpg.magia import Magia

class Mago(Personagem):
    """Herói focado em magia."""

    tipo_dano: str = "magico"

    def __init__(self, nome: str, vida: int, forca: int, nivel: int = 1, xp: int = 0, mana: int = 100) -> None:
        super().__init__(nome, vida, forca, nivel, xp)
        self.mana = mana
        self.grimorio = [
            Magia("Bola de Fogo", self.forca + 10),
            Magia("Raio Gélido", self.forca + 6)
        ]

    def _calcular_dano(self, alvo) -> int:
        dano_base = super()._calcular_dano(alvo)
        dano_magico = 5
        
        return dano_base + dano_magico
    
    def atacar(self, alvo) -> int:
        dano = self._calcular_dano(alvo)
        alvo.receber_dano(dano, "magico")

        queimadura = Efeito("queimadura", -5, 3)
        alvo.adicionar_efeito(queimadura)
        return dano

    def golpe_especial(self, alvo) -> int:
        if self.grimorio:
            magia_escolhida = self.grimorio[0]
            return magia_escolhida(alvo)
        return 0
