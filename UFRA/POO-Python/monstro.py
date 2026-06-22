import random as rand

class Monstro:
    """Representa um monstro do RPG, com atributos de nome, vida, ataque e defesa. Além disso realiza funções de atacar, receber dano, verificação da vida e status."""

    def __init__(self, nome: str, vida: int = 80, ataque: int = 30, defesa: int = 8):
        self.nome = nome
        self.vida = vida
        self.ataque = ataque
        self.defesa = defesa

    def estaVivo(self) -> bool:
        if self.vida > 0:
            return True
        else:
            return False
        
    def receberDano(self, dano: int) -> None:
        self.vida -= dano

        # Verificação para garantir que a vida não fique abaixo de zero.
        if self.vida < 0:
            self.vida = 0

        print(f"{self.nome} recebeu {dano} de dano!"
              f"\nHP atual: {self.vida}.")
        
        if self.vida == 0:
            print(f"{self.nome} foi derrotado!")
    
    def atacar(self, alvo: Monstro) -> None:
        # Calculo o dano com a variação aleatória.
        variacao = rand.randint(-3, 3)
        dano = (self.ataque - alvo.defesa) + variacao

        print(f"{self.nome} atacou o {alvo.nome} e causou {dano} de dano!")
        alvo.receberDano(max(0, dano))

    def info(self) -> None:
        print(f"[{self.nome}] Vida: {self.vida} | ATK: {self.ataque} | DEF: {self.defesa}")