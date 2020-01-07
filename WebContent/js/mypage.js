$(function () {

    /*------ ドロップダウンメニュー ------*/

    $("#list1").hover(function () {
        $("#menu:not(:animated)", this).slideDown();
    }, function () {
        $("#menu", this).slideUp();
    });

    /*------ スライドショー（出品履歴） ------*/

    $(document).ready(function () {
        $('.slider').bxSlider({
            auto: true, pause: '3000'
        });
    });

});