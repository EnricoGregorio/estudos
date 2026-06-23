from .exceptions import RpgError

class Combate: 
    """Gerencia uma batalha entre dois combatentes."""

    def __init__(self, atacante, defensor) -> None:
        self.atacante = atacante
        self.defensor = defensor

    def executar_turno(self, acao: str = "atacar") -> dict:
        """Executa um turno e devolve o mesmo."""
        dano_atk = self.atacante.atacar(self.defensor)

        if not self.defensor.esta_vivo():
            if hasattr(self.atacante, "ganhar_xp"):
                xp_recompensa = self.defensor.nivel * 50
                self.atacante.ganhar_xp(xp_recompensa)
                print(f"{self.atacante.nome} ganhou {xp_recompensa} XP por derrotar {self.defensor.nome}.")

        dano_def = 0
        if self.defensor.esta_vivo():
            dano_def = self.defensor.atacar(self.atacante)

            if not self.atacante.esta_vivo():
                if hasattr(self.defensor, "ganhar_xp"):
                    xp_recompensa = self.atacante.nivel * 50
                    self.defensor.ganhar_xp(xp_recompensa)
                    print(f"{self.defensor.nome} ganhou {xp_recompensa} XP por derrotar {self.atacante.nome}.")


        return {
            "dano_atacante": dano_atk,
            "dano_defensor": dano_def,
            "atacante_vivo": self.atacante.esta_vivo(),
            "defensor_vivo": self.defensor.esta_vivo()
        }
    
    def lutar(self):
        """Itera turnos até um lado morrer. Devolve o vencedor."""

        turno = 1
        while self.atacante.esta_vivo() and self.defensor.esta_vivo():
            try:
                resumo = self.executar_turno()
                print(f"Turno {turno}: "
                    f"{self.atacante.nome} causou {resumo['dano_atacante']} | "
                    f"{self.defensor.nome} causou {resumo['dano_defensor']}")
                turno += 1
            except RpgError as e:
                print(f"\n[FALHA NO COMBATE] Alguma regra do jogo impediu a ação: {e}")
                return None

        vencedor = self.atacante if self.atacante.esta_vivo() else self.defensor
        print(f"\nVencedor: {vencedor.nome}!")
        return vencedor
