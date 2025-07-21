$(function () {
    //Aqui vai todo nosso código de JavaScript.
    $('nav.mobile').click(function () {
        //O que vai acontecer quando clicarmos nav.mobile?
        var menuList = $('nav.mobile ul');
        var icone = $('.botao-menu-mobile').find('i');

        if (menuList.is(':hidden') == true) {

            icone.removeClass('fa-bars');
            icone.addClass('fa-times');
            menuList.slideToggle();
        } else {
            icone.removeClass('fa-times');
            icone.addClass('fa-bars');
            menuList.slideToggle();
        }
    })
})