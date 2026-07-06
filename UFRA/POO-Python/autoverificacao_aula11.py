import inspect
from dataclasses import is_dataclass
from rpg.efeito import Efeito
from rpg.personagem import Personagem
from rpg.mago import Mago
from rpg.monstros import Goblin

# Parte B (a) — Efeito é uma dataclass: repr e eq automáticos
assert is_dataclass(Efeito), "Efeito precisa ser decorada com @dataclass"
e = Efeito("Teste", -5, 3)
assert repr(e).startswith("Efeito("), "o @dataclass deve gerar __repr__"
assert Efeito("Teste", -5, 3) == e, "o @dataclass deve gerar __eq__"
print("OK Parte B (a) Efeito é uma @dataclass (repr e eq automáticos)")

# Parte B (b) — aplicar soma o valor por turno à vida de quem está vivo
vivo = Goblin(vida=100)
Efeito("Queima", -5, 1).aplicar(vivo)
assert vivo.vida == 95, "aplicar deve somar valor_por_turno à vida"
print("OK Parte B (b) aplicar() aplica o valor por turno a quem está vivo")

# Parte B (c) — combatente morto não é afetado (não ressuscita)
morto = Goblin(vida=5)
morto.receber_dano(5) # vida vai a 0
Efeito("Regen", +10, 2).aplicar(morto)
assert morto.vida == 0 and not morto.esta_vivo(), "morto não deve ser afetado"
print("OK Parte B (c) combatente morto não é afetado")

# Parte B (d) — o ataque do Mago adiciona a queimadura ao alvo
mago = Mago("Gandalf", 80, 15)
alvo = Goblin(vida=100)
mago.atacar(alvo)
assert len(alvo.efeitos_ativos) == 1, "o Mago deve adicionar 1 efeito ao alvo"
assert isinstance(alvo.efeitos_ativos[0], Efeito), "o efeito deve ser um Efeito"
print("OK Parte B (d) o ataque do Mago adiciona queimadura ao alvo")

# Parte A — métodos públicos de Personagem e Monstro têm anotação de retorno
from rpg.monstro import Monstro
faltando = []
for cls in (Personagem, Monstro):
    for nome, metodo in inspect.getmembers(cls, predicate=inspect.isfunction):
        if nome.startswith("_"): # pula dunders e métodos internos (_)
            continue
        if inspect.signature(metodo).return_annotation is inspect.Signature.empty:
            faltando.append(f"{cls.__name__}.{nome}")
assert not faltando, f"sem anotação de retorno: {faltando}"
print("OK Parte A métodos públicos de Personagem e Monstro anotados")
print("\nTudo certo: as duas partes passaram.")