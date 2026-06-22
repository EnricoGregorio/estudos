from rpg.item import Item

class Inventario:
    """Representa o inventário dos nossos personagens."""

    def __init__(self):
        self._itens: list[Item] = []

    def adicionar(self, item: Item) -> None:
        self._itens.append(item)
        print(f"- O item {item.nome} que {item.descricao} foi adicionado ao inventário.")

    def remover(self, nome: str) -> Item:
        for indice, item in enumerate(self._itens):
            if item.nome == nome.capitalize():
                self._itens.pop(indice)
                return item
        print(f"O item '{nome}' não existe no inventário.")
        return None
    
    def listar(self) -> None:
        if len(self._itens) == 0:
            print("Inventário vazio.")
        else:
            print("--- Inventário ---")
            for indice, item in enumerate(self._itens, 1):
                print(f"{indice} - {item.nome} de {item.descricao} que possui {item.valor} de pontos.")
            print(f"Total de itens: {len(self._itens)}")

    @classmethod
    def criarInicial(cls):
        """Cria e devolve um inventário já populado com itens iniciais padrão."""

        _novoInventario = cls()
        
        pocao = Item("Poção", "restaura pontos de vida", 30)
        adaga = Item("Adaga", "causa dano perfurante", 70)

        _novoInventario.adicionar(pocao)
        _novoInventario.adicionar(adaga)

        return _novoInventario
