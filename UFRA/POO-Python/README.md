# ⚔️ POO em Python: Projeto RPG Evolutivo

![Python](https://img.shields.io/badge/Python-3.12%2B-blue.svg?style=flat-square&logo=python)
![Status](https://img.shields.io/badge/Status-Em%20Construção%20(Aula%20a%20Aula)-success?style=flat-square)
![UFRA](https://img.shields.io/badge/UFRA-Graduação-00563B?style=flat-square)

## 📖 Qual é a proposta deste repositório?

Este projeto é o laboratório prático da disciplina de **Programação Orientada a Objetos**. 

Em vez de resolver dezenas de exercícios pequenos e desconectados, a proposta da disciplina é **construir um único sistema de RPG de texto que evolui organicamente a cada aula**. A cada novo conceito teórico apresentado em sala, o código sofre um processo de *Progressive Refactoring* (Refatoração Progressiva) para absorver boas práticas de arquitetura.

O objetivo final não é criar um jogo comercialmente viável, mas sim **provar a aplicação prática dos conceitos fundamentais da Engenharia de Software**.

---

## 🏛️ Os 4 Pilares da POO aplicados

Para fins de avaliação ou estudo, os pilares da orientação a objetos podem ser mapeados neste código da seguinte forma:

1. **Abstração:** Tradução de conceitos abstratos de um mundo de fantasia (força, aljava de flechas, vitalidade) em atributos e responsabilidades computacionais estritas.
2. **Encapsulamento:** Proteção do estado interno dos objetos (como a lista de `_itens` do inventário) e criação de rotinas matemáticas privadas (como o método `_calcular_dano()`).
3. **Herança:** Criação de uma hierarquia limpa onde especializações (`Guerreiro`, `Mago`, `Arqueiro` e `Monstro`) herdam comportamentos vitais de suas classes-base.
4. **Polimorfismo:** Implementação do conceito de *Duck Typing* e *Method Overriding*, permitindo que o maestro da batalha (`Combate.lutar()`) dê a ordem genérica `atacante.atacar(alvo)` sem precisar saber qual é a classe concreta agindo no turno.

---

## 🗺️ Roadmap de Evolução (Aula a Aula)

* **Aulas 1 a 3 - Fundamentos:** Criação de classes brutas, construtores (`__init__`), tipagem estática opcional (*Type Hints*) e instanciação básica.
* **Aula 4 - Composição e Encapsulamento:** Implementação da classe `Inventario`, estabelecendo a relação *"Personagem **tem um** Inventário"*, com regras de limite de slots.
* **Aulas 5 e 6 - Herança e Polimorfismo:** Desmembramento da classe base em especializações. Introdução da classe `Combate` gerenciando a interação entre objetos.
* **Aulas 7 e 8 - Programação Defensiva:** Blindagem do domínio. Implementação de uma hierarquia própria de exceções (`RpgError`, `InventarioCheioError`, `PersonagemMortoError`) e tratamento de erros na borda do sistema.
* **Aula 9 - Encapsulamento Idiomático e Decorators:** Aprofundamento do pilar de encapsulamento através da resposta idiomática do Python aos modificadores *private* e *protected* do Java. Desmistificação dos *decorators* (o mecanismo por trás do `@`) e conversão de atributos em `@property` com rotinas de *getter*, *setter* e *deleter*.
* **Aula 10 - Classes Abstratas e Sobrecargas de Operadores:** Aprendi o que sobre **calsses abstratras**, porquê ela não pode ser instanciada e quando vale a pena criar uma (`ABC` e `@abstractmethod`). Além disso, foi visto a diferença entre **identidade** (`is`) e **igualdade** (`==`), e como mudar a regra do `==` com `__eq__`. Por fim, aprendi sobre **sobrecarga de operadores** pelos *métodos mágicos*: `__str__`, `__repr__`, `__eq__`, `__hash__` e `__lt__`. Esses temas fecham o pilar da **abstração** com vocabulário formal e dão sequência ao **polimorfismo** da Aula 6, agora na forma de operadores que respondem que respondem aos nossos objetos.

---

## 🚀 Como inspecionar e testar

O projeto foi construído sem dependências externas pesadas, utilizando a biblioteca padrão do Python. 

1. Clone o repositório:
   ```bash
   git clone https://github.com/EnricoGregorio/estudos.git
   ```
2. Navegue até o diretório da disciplina:
   ```bash
   cd estudos/UFRA/POO-Python
   ```
3. Execute a simulação de combate a partir da raiz do pacote:
   ```bash
   python3 main.py
   ```
> Nota: O arquivo `main.py` atua como um script de demonstração, instanciando os heróis, gerando os cenários de batalha e exercitando as capturas de exceção do sistema