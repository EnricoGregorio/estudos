from rpg import Personagem, Monstro, Item, Guerreiro, Mago, Arqueiro, Goblin, Dragao, Esqueleto, Combate, RpgError, InventarioCheioError, PersonagemMortoError, XPInvalidoError

print("1. Demonstração do Clamp na Vida")
# Atribuição fora do intervalo demonstrando o grampeamento no piso e no teto
heroi = Guerreiro(nome="Boromir", vida=100, forca=20)
heroi.vida = -50
print(f"Vida após atribuir -50: {heroi.vida}")
heroi.vida = 999
print(f"Vida após atribuir 999: {heroi.vida}")

print("\n2. Demonstração de Rejeição no Nível")
# Tentativa de nível inválido capturando o ValueError
try:
    heroi.nivel = 0
except ValueError as e:
    print(f"Erro capturado: {e}")

print("\n3. Demonstração de Rejeição no XP")
# Tentativa de regredir o XP capturando a XPInvalidoError
heroi.ganhar_xp(120)
try:
    heroi.xp = 50
except XPInvalidoError as e:
    print(f"Erro capturado: {e}")

print("\n4. Demonstração de Combate com Recompensa de XP")
# Combate em que o herói vence, ganha XP e sobe de nível
heroi = Guerreiro(nome="Aragorn", vida=100, forca=15)
goblin = Goblin()

print("Status antes do combate:")
heroi.mostrar_status()
print("-" * 40)

batalha = Combate(heroi, goblin)
batalha.lutar()

print("-" * 40)
print("Status depois do combate:")
heroi.mostrar_status()
