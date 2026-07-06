from rpg import Efeito, Mago, Goblin

def main():
    print("=== 1. Efeito é dataclass ===")
    e1 = Efeito(nome='queimadura', valor_por_turno=-5, duracao=3)
    e2 = Efeito(nome='queimadura', valor_por_turno=-5, duracao=3)

    print(f"repr: {repr(e1)}")
    print(f"igualdade: {e1 == e2}")

    print("\n=== 2. Mago aplica queimadura ao atacar ===")
    mago = Mago("Gandalf", 100, 20)
    goblin = Goblin(vida=80)
    
    mago.atacar(goblin)

    print(f"Efeitos no Goblin: {goblin.efeitos_ativos}")

    print("\n=== 3. aplicar() e a regra do morto ===")
    vida_antes = goblin.vida
    queimadura = goblin.efeitos_ativos[0]
    
    queimadura.aplicar(goblin)
    print(f"vida do goblin: {vida_antes} -> {goblin.vida} (queimou {abs(queimadura.valor_por_turno)})")

    goblin.vida = 0
    regeneracao = Efeito("regeneracao", 5, 4)
    regeneracao.aplicar(goblin)
    print(f"Goblin morto (vida 0) após regeneração: vida {goblin.vida}, vivo? {goblin.esta_vivo()}")

if __name__ == "__main__":
    main()
