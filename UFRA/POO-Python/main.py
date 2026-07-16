from rpg import Inventario, Item, Mago, Goblin, Dragao, gerar_loot

def main():
    print("Passo 1 - Filtrar Inventário com Lambda:")
    inv = Inventario()
    inv.adicionar(Item("Espada Longa", "arma", 15))
    inv.adicionar(Item("Poção de Cura", "pocao", 20))
    inv.adicionar(Item("Adaga", "arma", 8))
    
    # Filtra usando lambda: apenas itens em que o tipo seja "arma".
    armas = inv.filtrar(lambda it: it.tipo == "arma")
    print(f"Armas encontradas: {[it.nome for it in armas]}") #

    print("\n\nPasso 2 - Mago usando Grimório:")
    gandalf = Mago("Gandalf", 100, 15)
    goblin = Goblin("Trevor", 80, 10)

    # Lança a primeira magia do grimório.
    dano = gandalf.golpe_especial(goblin)
    print(f"{gandalf.nome} causou {dano} de dano! Vida do Goblin: {goblin.vida}")

    # Consulta o inventário com for in, e com acesso ao inventario[0].
    print("\n\nPasso 3 - Inventário como Coleção:")
    print("Percorrendo os itens com for:")
    for item in inv:
        print(f" - {item.nome}")
    print(f"Acessando via índice [0]: {inv[0].nome}") #

    print("\n\nPasso 4 - Gerador de Loot com yield:")
    dragao = Dragao("Bronc", 500, 50)
    print(f"Loot gerado pelo {dragao.nome}:")

    # Consumindo o gerador num for.
    for item_loot in gerar_loot(dragao): #
        print(f" Caiu: {item_loot.nome}")

if __name__ == "__main__":
    main()
