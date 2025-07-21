'use strict';

// Números possíveis para o Game.
const maxNumber = 50;
document.querySelector('.max-number').textContent = maxNumber;

// O número aleatoriamente gerado.
let secretNumber = Math.floor(Math.random() * maxNumber) + 1;

// A pontuação inicial
let score = maxNumber;
document.querySelector('.score').textContent = score;

// Valor inicial da maior pontuação do jogador.
let highscore = 0;

// Valor da maior pontuação já feita.
let highscoreGlobal = 0;

// Função para mostrar mensagem.
function showMessage(msg) {
    return document.querySelector('.message').textContent = msg;
}

function VerifyNumber(number) {
    // Enquanto a pontuação ainda não zerou.
    if (score > 1) {

        // Quando o número inserido não está entre 1 e o valor da constante maxNumber.
        if (!number || number > maxNumber) {
            showMessage('⛔ Número Inválido!');
            score--;
            document.querySelector('.score').textContent = score;

            // Quando o número inserido é maior ao correto.
        } else if (number > secretNumber) {
            showMessage('📉 Muito Alto!');
            score--;
            document.querySelector('.score').textContent = score;

            // Quando o número inserido é menor ao correto.
        } else if (number < secretNumber) {
            showMessage('📈 Muito Baixo!');
            score--;
            document.querySelector('.score').textContent = score;

            // Quando o número inserido é o correto.
        } else {
            showMessage('🎉 Número Correto!');
            document.querySelector('body').style.backgroundColor = '#0e8f48';
            document.querySelector('.number').textContent = secretNumber;
            document.querySelector('.number').style.width = '30rem';

            // Quando a pontuação atual é maior do que a mais alta já registrada.
            if (score > highscore) {
                highscore = score;
                document.querySelector('.highscore').textContent = highscore;

            }
        }

        // Quando a pontuação chega a zero.
    } else {
        showMessage('💥 Você Perdeu!');
        document.querySelector('.score').textContent = 0;
    }
}

// Evento de click no botão 'Verificar!'.
document.querySelector('.check').addEventListener('click', function () {
    const guess = Number(document.querySelector('.guess').value);
    VerifyNumber(guess);
});

// Evento de click no botão 'Recomeçar!'.
document.querySelector('.again').addEventListener('click', function () {
    score = maxNumber;
    secretNumber = Math.floor(Math.random() * maxNumber) + 1;
    document.querySelector('.number').textContent = '?';
    document.querySelector('.number').style.width = '15rem';
    document.querySelector('body').style.backgroundColor = '#222';
    document.querySelector('.guess').value = '';
    document.querySelector('.score').textContent = score;
    showMessage('Comece a advinhar...');
});

// Mesmos eventos, mas agora acontecem quando a tecla Enter ou R são pressionadas.
document.addEventListener('keydown', (event) => {
    let code = event.code;
    if (code === 'Enter') {
        const guess = Number(document.querySelector('.guess').value);
        VerifyNumber(guess);
    } else if (code === 'KeyR') {
        score = maxNumber;
        secretNumber = Math.floor(Math.random() * maxNumber) + 1;
        document.querySelector('.number').textContent = '?';
        document.querySelector('.number').style.width = '15rem';
        document.querySelector('body').style.backgroundColor = '#222';
        document.querySelector('.guess').value = '';
        document.querySelector('.score').textContent = score;
        showMessage('Comece a advinhar...');
    }
}, false);