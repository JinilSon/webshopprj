window.onload = function(){
 	var userId = $(".userId_input").val();
  
	 if(userId != ""){
	 	$("#login_btn").text("로그아웃");}
};
/* 로그인 후의 로그인 버튼 변경 */

/* onload와 document.ready의 차이점
	onload
	: 문서의 모든 컨텐츠(img, css, script ..)가 로드된 후에 발생하는 이벤트
	문서에 포함된 모든 컨텐츠가 로드된 후에 실행되기에 불필요한 로딩시간이 추가될 수 있음
	<body onload="" 로도 실행가능
	여러 번 사용되면 마지막에 선언된 것만 실행됨
	$(document).ready();
	:onload 보다 먼저 발생하는 이벤트
	DOM 트리만 완성되면 바로 실행하므로 미리 로딩해야 할 데이터에 적합
	여러 번 사용되면 선언 순서에 따라 순차적으로 발생
*/

function isLogin(ths){
 	if(ths.text == "로그인")
		location.replace("/login");
 	else
		location.replace("/logout");
};
/* 로그인 후의 href 이동 제어 */
