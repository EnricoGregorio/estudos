import types
from rpg.inventario import Inventario
from rpg.item import Item
from rpg.mago import Mago
from rpg.magia import Magia
from rpg.monstros import Goblin, gerar_loot

# Passo 1 — filtro de ordem superior (recebe a regra como função)
inv = Inventario()
inv.adicionar(Item("Espada", "arma", 10))
inv.adicionar(Item("Poção", "pocao", 20))
armas = inv.filtrar(lambda it: it.tipo == "arma")
assert [i.nome for i in armas] == ["Espada"], "filtrar deve aplicar a regra recebida"
print("OK Passo 1 Inventario.filtrar (ordem superior + lambda)")

# Passo 2 — Magia callable + grimório do Mago
bola = Magia("Bola de Fogo", 30)
assert callable(bola), "Magia precisa ser callable (definir __call__)"
alvo = Goblin(vida=100)
assert bola(alvo) == 30 and alvo.vida == 70, "a Magia aplica dano ao alvo e devolve o dano"
mago = Mago("Gandalf", 80, 15)
assert len(mago.grimorio) >= 1, "o Mago precisa de um grimório (lista de Magia)"
alvo2 = Goblin(vida=100)
mago.golpe_especial(alvo2)
assert alvo2.vida < 100, "golpe_especial deve lançar a primeira magia do grimório"
print("OK Passo 2 Magia callable + grimório do Mago (__call__)")

# Passo 3 — Inventario como coleção (for e índice)
inv2 = Inventario()
inv2.adicionar(Item("Espada", "arma", 10))
inv2.adicionar(Item("Escudo", "arma", 8))
assert [it.nome for it in inv2] == ["Espada", "Escudo"], "for deve percorrer (__iter__)"
assert inv2[0].nome == "Espada", "acesso por índice deve funcionar (__getitem__)"
assert len(inv2) == 2, "__len__ continua valendo"
print("OK Passo 3 Inventario percorrível e indexável (__iter__, __getitem__)")

# Passo 4 — gerador de loot com yield
g = gerar_loot(Goblin())
assert isinstance(g, types.GeneratorType), "gerar_loot deve ser um gerador (usar yield)"
itens = list(g)
assert itens and all(isinstance(x, Item) for x in itens), "o loot são objetos Item"
print("OK Passo 4 gerador de loot com yield")
print("\nTudo certo: os quatro passos passaram.")