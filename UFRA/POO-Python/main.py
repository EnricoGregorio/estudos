from rpg import Personagem, Monstro, Item, Guerreiro, Mago, Arqueiro, Goblin, Dragao, Esqueleto, Combate

print("=== Batalha 1: Guerreiro vs Goblin ===")
Combate(Guerreiro("Boromir", 100, 20), Goblin()).lutar()

print("\n=== Batalha 2: Guerreiro vs Esqueleto ===")
Combate(Guerreiro("Boromir", 100, 20), Esqueleto()).lutar()

print("\n=== Batalha 3: Mago vs Esqueleto ===")
Combate(Mago("Gandalf", 80, 15), Esqueleto()).lutar()

print("\n=== Batalha 4: Arqueiro vs Dragão ===")
Combate(Arqueiro("Legolas", 90, 18, flechas=2), Dragao()).lutar()
