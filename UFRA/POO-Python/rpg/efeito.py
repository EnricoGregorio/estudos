from dataclasses import dataclass

@dataclass
class Efeito:
    nome: str
    valor_por_turno: int
    duracao: int

    def aplicar(self, combatente) -> None:
        if not combatente.esta_vivo():
            return
        
        combatente.vida += self.valor_por_turno
