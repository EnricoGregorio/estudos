from rpg.inventario import Inventario
from .exceptions import PersonagemMortoError

class Personagem:
    """
    Representa um herói genérico do RPG, com atributos de nome, vida e forca. 
    Além disso realiza funções de atacar, receber dano, verificação da vida e status.
    """

    tipo_dano: str = "fisico"

    def __init__(self, nome: str, vida: int, forca: int, nivel: int = 1, xp: int = 0) -> None:
        self.nome = nome
        self.vida = vida
        self.forca = forca
        self.nivel = nivel
        self.xp = xp
        self.inventario = Inventario.criar_inicial()

    def _calcular_dano(self, alvo) -> int:
        return self.forca

    def atacar(self, alvo) -> int:
        if not self.esta_vivo():
            raise PersonagemMortoError(f"{self.nome} está morto e não pode atacar.")
        
        dano_calculado = self._calcular_dano(alvo)

        alvo.receber_dano(dano_calculado, self.tipo_dano)
        return dano_calculado

    def receber_dano(self, dano: int, tipo_dano: str = "fisico") -> None:
        self.vida = max(0, self.vida - dano)

    def esta_vivo(self) -> bool:
        return self.vida > 0

    def usar_item(self, nome_item: str) -> bool:
        item = self.inventario.retirar(nome_item)
        if item is None:
            return False
        if item.tipo == "pocao":
            self.vida += item.valor
            print(f"\n{self.nome} usou {item.nome} e recuperou {item.valor} pontos de vida.\nHP atual: {self.vida}.")
            return True
        return False
    
    def mostrar_status(self) -> None:
        print(f"[{self.nome}] Nível: {self.nivel} | Vida: {self.vida} | XP: {self.xp}")
