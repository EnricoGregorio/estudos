//Funções JQuery
$(function() {
    // Função para criar scroll dinâmico para as sessões Acompanhe, Sobre o Projeto e Notícias.
    $('nav a').click(function(e) {
        e.preventDefault()
        const id = $(this).attr('href'), targetOffset = $(id).offset().top
        $('html, body').animate({
            scrollTop: targetOffset
        }, 500)
    })
    // Função para quando pressionar o botão do menu, ele faça algo.
    $(".menu-button").click(function() {
        const menuMobile = $('nav.mobile')
        if (menuMobile.is(':hidden') == false) {
            menuMobile.slideToggle()
            window.document.querySelector(".fa-bars").style.display = 'block'
            window.document.querySelector(".fa-times").style.display = 'none'
        } else {
            menuMobile.slideToggle()
            window.document.querySelector(".fa-bars").style.display = 'none'
            window.document.querySelector(".fa-times").style.display = 'block'
        }
    })
    // Função do botão para retornar ao topo do site.
    $("#return-button").click(function() {
        const topo = $('header'), targetOffset = $(topo).offset().top
        $('html, body').animate({
            scrollTop: targetOffset
        }, 500)
    })
})

// Comando para deixar o ícone X do menu de navegação 'escondido' por padrão.
window.document.querySelector(".fa-times").style.display = 'none'
// Funções para capturar o valor do scroll na página atual.
window.onscroll = function() {
    scrollFunction()
}
function scrollFunction() {
    const returnButton = $("button#return-button")
    if (document.body.scrollTop > 200 || document.documentElement.scrollTop > 200) {
        returnButton.fadeIn(250)
    } else {
        returnButton.fadeOut(250)
    }
}