$(function(){
  var currentPosition = parseInt($(".content-left").css("top"));
  $(".body").scroll(function() {
    var position = $(".body").scrollTop(); 
	console.log(position);
    $(".content-left").stop().animate({"top":position+currentPosition+"px"},1000);
  });
});

/* currentPosition : 현재 content-left의 absolute top속성의 값
   .body(스크롤링 하는 객체).scroll : scoll 했을 경우의 리스너
   .stop을 먼저하는 이유는 stop을 하지않을 시, 중간에 애니메이션을 멈추지 않고 모두 다 한다음 다음 애니메이션으*/