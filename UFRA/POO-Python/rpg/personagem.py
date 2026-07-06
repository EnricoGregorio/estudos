from rpg.inventario import Inventario
from .exceptions import PersonagemMortoError, XPInvalidoError
from abc import ABC, abstractmethod

class Personagem(ABC):
    """
    Representa um herói genérico do RPG, com atributos de nome, vida e forca. 
    Além disso realiza funções de atacar, receber dano, verificação da vida e status.
    """

    tipo_dano: str = "fisico"
    _contador_id = 0

    def __init__(self, nome: str, vida: int, forca: int, nivel: int = 1, xp: int = 0) -> None:
        self.nome = nome
        self.vida_maxima = vida
        self.vida = vida
        self.forca = forca
        self.nivel = nivel
        self._xp = 0
        self.xp = xp
        self.inventario = Inventario.criar_inicial()
        Personagem._contador_id += 1
        self._id = Personagem._contador_id
        self.efeitos_ativos = []

    @property
    def vida(self) -> int:
        return self._vida
    
    @vida.setter
    def vida(self, valor: int) -> None:
        self._vida = max(0, min(valor, self.vida_maxima))

    @property
    def nivel(self) -> int:
        return self._nivel
    
    @nivel.setter
    def nivel(self, valor: int) -> None:
        if valor < 1:
            raise ValueError(f"Nível deve ser >= 1, recebido {valor}.")
        self._nivel = valor

    @property
    def xp(self) -> int:
        return self._xp
    
    @xp.setter
    def xp(self, valor: int) -> None:
        if valor < self.xp:
            raise XPInvalidoError(f"XP não pode regredir: atual {self._xp}, recebido {valor}.")
        self._xp = valor

    def ganhar_xp(self, quantidade: int) -> None:
        if quantidade <= 0:
            return
        
        self.xp += quantidade

        while self.xp >= self.nivel * 100:
            self._nivel += 1
            print(f"{self.nome} subiu para o nível {self.nivel}!")
            
            # Implementação da Atividade Extra:
            self.vida_maxima += 10
            self.vida = self.vida_maxima
            """
            Justificativa:
            A ordem deve obrigatoriamente ajustar o teto primeiro e só depois 
            atribuir a cura à property 'vida'. Se tentássemos curar antes de 
            expandir o teto, a validação do setter (clamp) cortaria o valor 
            no limite antigo.
            """


    def _calcular_dano(self, alvo) -> int:
        return self.forca

    def atacar(self, alvo) -> int:
        if not self.esta_vivo():
            raise PersonagemMortoError(f"{self.nome} está morto e não pode atacar.")
        
        dano_calculado = self._calcular_dano(alvo)

        alvo.receber_dano(dano_calculado, self.tipo_dano)
        return dano_calculado

    def receber_dano(self, dano: int, tipo_dano: str = "fisico") -> None:
        self.vida -= dano

    def esta_vivo(self) -> bool:
        return self.vida > 0

    def usar_item(self, nome_item: str) -> bool:
        item = self.inventario.retirar(nome_item)
        if item is None:
            return False
        if item.tipo == "pocao":
            self.vida += item.valor
            print(f"\n{self.nome} usou {item.nome} e recuperou {item.valor} pontos de vida.\nHP atual: {self.vida}.")
            return True
        return False
    
    def mostrar_status(self) -> None:
        print(f"[{self.nome}] Nível: {self.nivel} | Vida: {self.vida}/{self.vida_maxima} | XP: {self.xp}")

    def adicionar_efeito(self, efeito) -> None:
        self.efeitos_ativos.append(efeito)

    @abstractmethod
    def golpe_especial(self, alvo) -> int:
        pass

    def  __str__(self) -> str:
        classe = self.__class__.__name__
        return f"{self.nome} ({classe} - Nível {self.nivel})."
    
    def __repr__(self) -> str:
        classe = self.__class__.__name__
        return (f"{classe}(id={self._id}, nome='{self.nome}', vida={self.vida}/{self.vida_maxima}, nivel={self.nivel}, xp={self.xp})")
    
    def __eq__(self, outro) -> bool:
        if not isinstance(outro, Personagem):
            return NotImplemented
        
        return self._id == outro._id
    
    def __hash__(self) -> int:
        return hash(self._id)
