from .exceptions import MonstroMorteError

class Monstro:
    """
    Representa um monstro genérico do RPG, com atributos de nome, vida e forca, mas sem inventário. 
    Além disso realiza funções de atacar, receber dano, verificação da vida e status.
    """

    tipo_dano: str = "fisico"

    def __init__(self, nome: str, vida: int, forca: int, tipo: str, nivel: int = 1) -> None:
        self.nome = nome
        self.vida = vida
        self.forca = forca
        self.tipo = tipo
        self.nivel = nivel
        self.efeitos_ativos = []

    def _calcular_dano(self, alvo):
        return self.forca

    def atacar(self, alvo) -> int:
        if not self.esta_vivo():
            raise MonstroMorteError(f"{self.nome} está morto e não pode atacar.")

        dano_calculado = self._calcular_dano(alvo)
        
        alvo.receber_dano(dano_calculado, self.tipo_dano)
        return dano_calculado

    def receber_dano(self, dano: int, tipo_dano: str = "fisico") -> None:
        self.vida = max(0, self.vida - dano)

    def esta_vivo(self) -> bool:
        return self.vida > 0

    def mostrar_status(self) -> None:
        print(f"[{self.nome}] Tipo: {self.tipo} | Nível: {self.nivel} | Vida: {self.vida}")

    def adicionar_efeito(self, efeito) -> None:
        self.efeitos_ativos.append(efeito)
