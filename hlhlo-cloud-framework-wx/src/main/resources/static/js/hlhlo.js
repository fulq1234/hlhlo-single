/**
***hlhlo msg
***by Just
***data 20181030
***/

$(function($){

  //转接功能块 show/hide
  $('.transfer-btn').click(function(){
    if( $(this).hasClass('c-red') ){
      $(this).removeClass('c-red');
      $(this).parents('.msg-enter-box').find('.transfer-box').hide();
      $('.msg-main').css('top','0');
      $(this).parents('.msg-enter-box').find("input[name='transfer-inp']").prop('checked',false);
      $('.transfer-go-btn').addClass('dis-red-btn');
    }else{
      $(this).addClass('c-red');
      $(this).parents('.msg-enter-box').find('.transfer-box').show();
      $('.msg-main').css('top','-140px');
    }
  });

  //输入框点击
  $('.flex-item').click(function(){
    $(this).parents('.msg-enter-box').find('.transfer-btn').removeClass('c-red');
    $(this).parents('.msg-enter-box').find('.transfer-box').hide();
    $(this).parents('.msg-enter-box').find("input[name='transfer-inp']").prop('checked',false);
    $('.transfer-go-btn').addClass('dis-red-btn');
    $('.msg-main').css('top','0');
  });

  //点击聊天部分 隐藏转接功能部分
  $('.msg-main').click(function(){
    $('.msg-enter-box').find('.transfer-btn').removeClass('c-red');
    $('.msg-enter-box').find('.transfer-box').hide();
    $('.msg-main').css('top','0');
    $("input[name='transfer-inp']").prop('checked',false);
    $('.transfer-go-btn').addClass('dis-red-btn');
  });

  //转接按钮是否disabled
  $("input[name='transfer-inp']").click(function(){
    $('.transfer-go-btn').removeClass('dis-red-btn');
  });

});

//判断设备终端
var u = navigator.userAgent;
var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
if( isiOS ){
  $('.send-btn').hide();
}
