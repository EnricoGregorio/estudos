
from __future__ import annotations

class Item:
    """Representa qualquer item do jogo, podendo ser uma poção, uma arma ou um escudo, que pode ser guardado no inventário."""

    def __init__(self, nome: str, tipo: str, valor: int) -> None:
        self.nome = nome
        self.tipo = tipo
        self.valor = valor

    @staticmethod
    def tipo_valido(tipo: str) -> bool:
        return tipo in ("arma", "pocao")
    
    @classmethod
    def padrao(cls) -> "Item":
        return cls("Poção", "pocao", 20)
