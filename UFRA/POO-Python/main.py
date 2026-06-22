from rpg import Personagem, Monstro, Item, Guerreiro, Mago, Arqueiro, Goblin, Dragao, Esqueleto, Combate, RpgError, InventarioCheioError, PersonagemMortoError

print("=== 1. Batalha normal ===")
guerreiro = Guerreiro("Boromir", 100, 20)

Combate(guerreiro, Goblin()).lutar()


print("\n=== 2. Inventário cheio ===")
try:
    mochila = guerreiro.inventario

    for i in range(11):
        novo_item = Item(nome=f"Poção {i}", tipo="pocao", valor=20)
        mochila.adicionar(novo_item)
except InventarioCheioError as e:
    print(f"Mochila lotada! {e}")


print("\n=== 3. Personagem morto tenta atacar ===")
guerreiro.receber_dano(999)

try:
    guerreiro.atacar(Esqueleto())
except PersonagemMortoError as e:
    print(f"Ataque cancelado: {e}")


print("\n=== 4. Captura genérica com RpgError ===")
try:
    guerreiro.atacar(Dragao())
    
except RpgError as e:
    print(f"Alguma regra do jogo impediu a ação: {e}")

print("\nFim da demonstração.")
