import tkinter as tk
from tkinter import messagebox

# 1. OS OBJETOS DO JOGO
from rpg import Mago, Dragao

# 1.1. Características iniciais dos seres (Heroi e Monstro) do jogo.
heroi_bp = {
    "nome": "Patolino, o Mago",
    "vida": 100,
    "forca": 35,
}

monstro_bp = {
    "nome": "Smaug, o Dragão Ancião",
    "vida": 200,
    "forca": 20,
}

heroi = Mago(heroi_bp["nome"], heroi_bp["vida"], heroi_bp["forca"])
monstro = Dragao(monstro_bp["nome"], monstro_bp["vida"], monstro_bp["forca"])

# 1.2. Paleta de cores:
cor_bg = "#1e1e1e"
cor_titulo = "#f4c430"
cor_heroi = "#4651E5"
cor_monstro = "#ff4444"
cor_mochila = "#88ff88"
cor_sistema = "#F3F3F3"

# 1.3. Fontes:
fonte_principal = "Menlo"


# 2. A JANELA e o PAINEL DE STATUS
janela = tk.Tk()
janela.title("RPG de Turnos")
janela.geometry("720x480")
janela.config(bg=cor_bg)

tk.Label(janela, text="RPG de Turnos em Python!", font=(fonte_principal, 18, "bold"), fg=cor_titulo).pack(pady=10)

# --- painel de status do herói ---
lbl_heroi = tk.Label(janela, font=(fonte_principal, 14), fg=cor_heroi)
lbl_heroi.pack(pady=6)

# --- painel de status do monstro ---
lbl_monstro = tk.Label(janela, font=(fonte_principal, 14), fg=cor_monstro)
lbl_monstro.pack(pady=6)

# --- linha de mensagens ("o herói causou X de dano...") ---
lbl_log = tk.Label(janela, font=(fonte_principal, 12), fg=cor_sistema, wraplength=520, justify="center")
lbl_log.pack(pady=14)

# --- painel do inventário ---
lbl_inventario = tk.Label(janela, font=(fonte_principal, 12), fg=cor_mochila, wraplength=520)
lbl_inventario.pack(pady=10)


# 3. ATUALIZAR A TELA
def atualizar_tela():
    lbl_heroi.config(
        text=f"{heroi.nome} ({type(heroi).__name__})   |   "
             f"vida {heroi.vida}/{heroi.vida_maxima}   |   "
             f"nível {heroi.nivel}   |   XP {heroi.xp}")
    lbl_monstro.config(
        text=f"{monstro.nome} ({monstro.tipo})   |   vida {monstro.vida}"
             f"   |   nível {monstro.nivel}")
    
    # Lê a lista de itens e extrai só os nomes.
    nomes_itens = [item.nome for item in heroi.inventario.listar()]
    
    # Se a lista tiver algo, junta com vírgulas, mas senão, avisa que está vazia.
    if nomes_itens:
        texto_inv = "Mochila: " + ", ".join(nomes_itens)
    else:
        texto_inv = "Mochila: (vazia)"
        
    lbl_inventario.config(text=texto_inv)


def registrar(mensagem):
    lbl_log.config(text=mensagem)


def jogo_acabou():
    return (not heroi.esta_vivo()) or (not monstro.esta_vivo())


def checar_fim():
    if not monstro.esta_vivo():
        messagebox.showinfo("Fim da batalha", f"{heroi.nome} venceu!")
    elif not heroi.esta_vivo():
        messagebox.showinfo("Fim da batalha", f"{monstro.nome} derrotou {heroi.nome}...")


# 4. AS AÇÕES.
cooldown_especial = 0

def acao_atacar():
    global cooldown_especial

    if jogo_acabou():
        return
    
    dano = heroi.atacar(monstro)

    # Se bater normal, reduz o cooldown do especial.
    if cooldown_especial > 0:
        cooldown_especial -= 1

    if monstro.esta_vivo():
        contra = monstro.atacar(heroi)
        registrar(f"{heroi.nome} causou {dano} de dano. "
                  f"{monstro.nome} revidou {contra}.")   
    else:
        registrar(f"{heroi.nome} causou {dano} e derrotou {monstro.nome}!")

    atualizar_tela()
    checar_fim()


def acao_golpe():
    global cooldown_especial

    if jogo_acabou():
        return
    
    # Trava do cooldown.
    if cooldown_especial > 0:
        registrar(f"Golpe Especial recarregando! Aguarde {cooldown_especial} turno(s).")
        return

    dano = heroi.golpe_especial(monstro)
    
    # Aplica a recarga de 2 turnos
    cooldown_especial = 2

    if monstro.esta_vivo():
        contra = monstro.atacar(heroi)
        registrar(f"{heroi.nome} usou seu GOLPE ESPECIAL e causou {dano} de dano! Já o {monstro.nome} revidou e causou {contra} de dano!")
    else:
        registrar(f"{heroi.nome} obliterou {monstro.nome} com um GOLPE ESPECIAL de {dano} de dano!")
        
    atualizar_tela()
    checar_fim()


def acao_pocao():    
    if jogo_acabou():
        return
    
    # Verifica se há poções para usar.
    itens_mochila = heroi.inventario.listar()
    tem_pocao = any(item.tipo == "pocao" for item in itens_mochila)
    
    # Se não tiver, avisa e encerra.
    if not tem_pocao:
        registrar(f"{heroi.nome} procurou na mochila, mas não tem poções!")
        atualizar_tela()
        return
        
    # Se tiver poção, mas a vida estiver cheia, trava a ação.
    if heroi.vida >= heroi.vida_maxima:
        registrar(f"{heroi.nome} já está com a vida cheia! Melhor guardar a poção.")
        return
        
    # Ele tem a poção e precisa de cura.
    heroi.usar_item("Poção")
    registrar(f"{heroi.nome} bebeu uma Poção e recuperou vida!")
        
    atualizar_tela()


def acao_reiniciar():
    global heroi, monstro, cooldown_especial
    
    heroi = Mago(heroi_bp["nome"], heroi_bp["vida"], heroi_bp["forca"])
    monstro = Dragao(monstro_bp["nome"], monstro_bp["vida"], monstro_bp["forca"])

    cooldown_especial = 0

    registrar("Novo jogo iniciado! A batalha recomeça.")
    atualizar_tela()


# 5. OS BOTÕES.
tk.Button(janela, text="Atacar", width=16, height=2, font=(fonte_principal, 12),
          command=acao_atacar).pack(pady=8)

tk.Button(janela, text="Golpe Especial", width=16, height=2, font=(fonte_principal, 12),
          command=acao_golpe).pack(pady=8)

tk.Button(janela, text="Usar Poção", width=16, height=2, font=(fonte_principal, 12),
          command=acao_pocao).pack(pady=8)

tk.Button(janela, text="Reiniciar Jogo", width=18, height=2, font=(fonte_principal, 12), 
          command=acao_reiniciar).pack(pady=24)


# 6. COMEÇA
atualizar_tela()
janela.mainloop()
