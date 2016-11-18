/**
 * Created by serge on 03.11.2016.
 */
$(document).ready(function () {
    var touch = $('#touch_menu');
    var menu = $('.nav')
    $(touch).on('click', function (e) {
        e.preventDefault();
        menu.slideToggle();
    });
    $(window).resize(function () {
        var wid = $(window).width();
        if(wid > 940 && menu.is(':hidden')){
            menu.removeAttr('style');
        }
    });
});