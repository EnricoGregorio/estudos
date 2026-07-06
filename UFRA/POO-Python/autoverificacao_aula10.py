from rpg import Personagem, Guerreiro, Goblin

# Frente 1 — golpe_especial aplica dano ao alvo e devolve o valor
heroi = Guerreiro("Aragorn", 100, 20)
alvo = Goblin(vida=1000) # vida alta para o dano não ser limitado
vida_antes = alvo.vida
dano = heroi.golpe_especial(alvo)
assert isinstance(dano, int) and dano > 0, "golpe_especial deve devolver o dano (int > 0)"
assert alvo.vida == vida_antes - dano, "golpe_especial deve aplicar o dano ao alvo"
print("OK Frente 1 golpe_especial aplica dano e devolve o valor")

# Frente 1 (cont.) — Personagem é abstrato: instanciar direto falha
try:
    Personagem("Genérico", 100, 10)
    print("FALHOU Personagem não deveria ser instanciável diretamente")
except TypeError:
    print("OK Frente 1 Personagem abstrato recusa instanciação")

# Frentes 2 e 3 — __eq__ pelo id de domínio
a = Guerreiro("Boromir", 100, 20)
b = Guerreiro("Boromir", 100, 20) # mesmo nome e classe, herói diferente
assert a == a, "um personagem deve ser igual a si mesmo"
assert a != b, "dois personagens distintos não são iguais, mesmo com nome igual"
print("OK Frentes 2/3 __eq__ baseado no id de domínio")

# Frente 3 — set/hash coerentes com __eq__
equipe = {a, a, b} # 'a' repetido + 'b'
assert len(equipe) == 2, "o set deve descartar a repetição de 'a' e manter 'b'"
print("OK Frente 3 __hash__ coerente: o set não funde personagens distintos")

# Frente 3 — __repr__ mostra o estado
r = repr(a)
for campo in ("nome=", "vida=", "nivel=", "xp="):
    assert campo in r, f"__repr__ deveria mostrar {campo}"
print("OK Frente 3 __repr__ mostra o estado completo")

print("\nTudo certo: as quatro frentes passaram.")