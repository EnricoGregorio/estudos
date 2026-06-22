from rpg import Personagem, Monstro

heroi = Personagem("Enrico", 100, 45, 15)
monstro = Monstro("Goblin", 80, 35, 10)

print("=" * 40 + f"\nBATALHA: {heroi.nome} vs. {monstro.nome}\n" + "=" * 40)

turno = 0

while heroi.estaVivo() and monstro.estaVivo():
    turno += 1

    print(f"\n--- Turno {turno} ---")

    heroi.atacar(monstro)
    if not monstro.estaVivo():
        continue

    monstro.atacar(heroi)
    if not heroi.estaVivo():
        continue
        
    heroi.info()
    monstro.info()

print("\n" + "=" * 50)
if not heroi.estaVivo():
    print(f"DERROTA: {heroi.nome} perdeu para {monstro.nome} em {turno} turnos.")
else:
    print(f"VITÓRIA: {heroi.nome} ganhou do {monstro.nome} em {turno} turnos.")
print("=" * 50)
