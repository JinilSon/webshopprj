function submit_prod(){
	
	if($('#p_title_input').val() == ""){
		alert("상품명을 입력해주세요")
		return false;
	}
	else if($('#p_category_input').val() == ""){
		alert("카테고리를 입력해주세요")
		return false;
	}
	else if($('#p_price_input').val() == ""){
		alert("가격를 입력해주세요")
		return false;
	}
	else if($('#p_color_input').val() == ""){
		alert("색상을 입력해주세요")
		return false;
	}
	else if($('#p_description_input').val() == ""){
		alert("설명을 입력해주세요")
		return false;
	}
	
	var frm = document.getElementById('form');
	var formData = new FormData(frm);
	for(var key of formData.keys())
		console.log(key);
	for(var value of formData.values())
		console.log(value);
	$.ajax({
		type : 'post',
		url : '/manage/add',
		data : formData,
		enctype : "multipart/form-data",
		cache : false,
		contentType : false,
		processData : false,
		success : function(){
			alert("success");	
		},
		error : function(){
			alert("error occurred");
		}
			
	});	
	
	return false;
};

/*$(function(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options){
		alert("ajax setting" + header + token);
		xhr.setRequestHeader(header, token);
	});
});*/
/* jsp 파일에 meta태그를 첨부하고, 해당 태그의 값을 불러들이는 구조 */
/* ajaxSend는 ajax데이터를 보내기 전에 실행된다. */
/* XMLHttpRequest의 헤더에 csrf 토큰 첨부방식은 multidata/form-data방식에서는 사용할 수 없다.*/

function add_category(e){
	e.stopPropagation();
	if(e.key == 'Enter'){
		alert("enter pressed");
	}
}

function add_indivisuals_html(){
	
	$("#add_indivisuals_line").before(
		"<tr><td>"
		+ "<button>버튼</button>"
		+ "</td></tr>");
}

