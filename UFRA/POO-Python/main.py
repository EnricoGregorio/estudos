from rpg import Personagem, Guerreiro

def main():
    print("1. Personagem abstrato")
    try:
        p = Personagem("Herói Genérico", 100, 20)
    except TypeError as e:
        # Captura o TypeError e imprime a mensagem.
        print(f"não dá para instanciar Personagem: {e}")

    print("\n2. Igualdade e identidade")
    g1 = Guerreiro("Boromir", 100, 20)
    g2 = Guerreiro("Boromir", 100, 20)

    print(f"g1 == g2 ? {g1 == g2}   (heróis distintos, ids diferentes)")
    print(f"g1 == g1 ? {g1 == g1}")
    
    print(f"repr(g1): {repr(g1)}")

    print("\n3. set de personagens")
    equipe = {g1, g1, g2}
    print(f"{{g1, g1, g2}} tem {len(equipe)} personagens (g1 repetido conta uma vez)")

if __name__ == "__main__":
    main()
