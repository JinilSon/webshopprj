$(function(){
 	var currentPosition = parseInt($(".content-left").css("top"));
 	$(".body").scroll(function() {
		var position = $(".body").scrollTop(); 
		$(".content-left").stop().animate({"top":position+currentPosition+"px"},1000);
	});
});
/* currentPosition : 현재 content-left의 absolute top속성의 값
   .body(스크롤링 하는 객체).scroll : scoll 했을 경우의 리스너
   .stop을 먼저하는 이유는 stop을 하지않을 시, 중간에 애니메이션을 멈추지 않고 예정된 애니메이션을 모두 수행하고, 다음 애니메이션을 수행한다.*/


