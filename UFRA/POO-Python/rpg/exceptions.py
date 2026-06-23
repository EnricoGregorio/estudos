class RpgError(Exception):
    """
    Exceção base para todos os erros de domínio do RPG. 
    
    Esta classe serve como raiz para a hierarquia de exceções personalizadas do sistema.
    """
    pass

class InventarioCheioError(RpgError):
    """
    Lançada quando há uma tentativa de adicionar um item a um invetário sem espaço.

    Acionada pelo método de adicionar itens quando a lista interna
    do inventário já atingiu o seu limite máximo de capacidade estabelecido.
    """
    pass

class PersonagemMortoError(RpgError):
    """
    Lançada quando um personagem com zero de vida tenta realizar uma ação ativa.

    Usada especificamente para impedir que personagens que já foram derrotados
    executem ações no turno, como tentar atacar um alvo durante o loop de combate.
    """
    pass

class XPInvalidoError(RpgError):
    """
    Lançada quando alguém tentar fazer o XP regredir.

    Ela será levantada pelo setter de xp quando alguém tentar fazer o XP regredir.
    """
    pass

class MonstroMorteError(RpgError):
    """
    Lançada quando um monstro com zero de vida tenta realizar uma ação ativa.

    Usada especificamente para impedir que monstros que já foram derrotados
    executem ações no turno, como tentar atacar um alvo durante o loop de combate.
    """
    pass