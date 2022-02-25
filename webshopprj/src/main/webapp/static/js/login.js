$(function(){
	$('#form').submit(function(){
		if($('#username').val() == ""){
			alert("아이디를 입력해주세요")
			return false;
		}
		else if($('#password').val() == ""){
			alert("비밀번호를 입력해주세요")
			return false;
		}
			
	})
})