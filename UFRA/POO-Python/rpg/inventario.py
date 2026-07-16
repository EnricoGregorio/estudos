from rpg.item import Item
from .exceptions import InventarioCheioError
from typing import Optional

class Inventario:
    """Representa o inventário dos nossos personagens e permite gerenciar os itens de um personagem com limite de slots."""

    LIMITE = 10

    def __init__(self) -> None:
        self._itens: list[Item] = []

    @classmethod
    def criar_inicial(cls) -> "Inventario":
        """Cria e devolve um inventário já populado com itens iniciais padrão."""

        novo_inv = cls()
        novo_inv.adicionar(Item.padrao())
        novo_inv.adicionar(Item.padrao())
        return novo_inv

    def adicionar(self, item: Item) -> bool:
        if not Item.tipo_valido(item.tipo):
            return False
        if len(self._itens) >= self.LIMITE:
            raise InventarioCheioError(f"Inventário cheio ({self.LIMITE} slots) - não coube: {item.nome}.")
        self._itens.append(item)
        return True

    def retirar(self, nome: str) -> Optional[Item]:
        for indice, item in enumerate(self._itens):
            if item.nome == nome:
                return self._itens.pop(indice)
        return None
    
    def listar(self) -> list[Item]:
        return list(self._itens)
    
    def filtrar(self, regra) -> list[Item]:
        return list(filter(regra, self._itens))
