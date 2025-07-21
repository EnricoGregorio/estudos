'use strict';

// const btnDarkMode = document.querySelector('.btn-dark-mode');

// btnDarkMode.addEventListener('click', function () {
//     document.body.style.setProperty('--cor5', '#0F1419');
//     document.body.style.setProperty('--cor0', 'white');
//     document.body.style.setProperty('--cor1', '#536471');
//     btnDarkMode.innerHTML = '<i class="fa-solid fa-sun"></i>'
//     btnDarkMode.classList.remove('claro');
//     btnDarkMode.classList.add('escuro');
// });

// if (btnDarkMode.classList.contains('claro')) {
// }


function getDate() {
    const date = new Date();
    const year = date.getFullYear();
    return year;
}

document.querySelector('#year').textContent = getDate();

if (document.URL === 'http://localhost/site/login' || document.URL === 'http://localhost/site/cadastro' || document.URL === 'http://localhost/Site/login' || document.URL === 'http://localhost/Site/cadastro') {
    document.querySelector('header').classList.add('hidden');
    document.querySelector('footer').classList.add('hidden');
    document.querySelector('main').style.width = '100%';
}
