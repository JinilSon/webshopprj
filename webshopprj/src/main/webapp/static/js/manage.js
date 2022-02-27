var size = new Array();
var color = new Array();

function submit_prod(){
	var title = $('#p_title_input').val();
	var price = $('#p_price_input').val();
	var description = $('#p_description_input').val();
	var img = document.getElementById("p_img_input").files;
	var category = $('#p_category_input').val();
	var csrf_token = $('#csrf_token');

	alert(csrf_token.attr('name'));

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
	else if($('#p_description_input').val() == ""){
		alert("설명을 입력해주세요")
		return false;
	}
	
	var formData = new FormData();
	for(let i=0; i < img.length; i++)
		formData.append("img_data", img[i]);
	// formData에서는 List형식으로 담을 수 없기에, 같은이름으로 개별적으로 추가하여야 한다.
	for(let i=0; i < size.length; i++)
		formData.append("size", size[i]);
	for(let i=0; i < color.length; i++)
		formData.append("color", color[i]);
	formData.append("title", title);
	formData.append(csrf_token.attr('name'), csrf_token.attr('value'));
	formData.append("price", price);
	formData.append("description", description);
	formData.append("category", category);
	
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
			location.reload();
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
// jsp 파일에 meta태그를 첨부하고, 해당 태그의 값을 불러들이는 구조 */
// ajaxSend는 ajax데이터를 보내기 전에 실행된다. */
// XMLHttpRequest의 헤더에 csrf 토큰 첨부방식은 multidata/form-data방식에서는 사용할 수 없다.*/

function add_size(e, ths){
	var text = ths.value;						// 해당 input 태그의 val 값을 저장
	var name = $(ths).attr('name') + "_array";	// 해당 input 태그의 'name' 속성명(class 구분점으로 사용)
	
	if(e.key == 'Enter'){
		e.preventDefault();
		// .keyCode 속성은 deprecated 되었다.	
		alert(name);
		var arr;
		// 참조를 위한 지역변수 생성('='을 통한 얕은 복사)
		
		if(name == "color_array")
			arr = color;
		else if(name == "size_array")
			arr = size;
		// 각 input에 맞는 arr와 매칭

		
		if(text == "")
			return false;
		// 값이 존재하지 않을 경우 action X

		arr.push(text);
		$(ths).after(
			"<div class='" + name +"'>"
			+	"<button class='p_del_btn' type='button'>B</button>"
			+	"<label>" + text + "</label>"
			+ "</div>"
		);
		// 값이 존재할 경우 배열에 val값 추가 및 사용자 확인 기능 div(p_color_array) 추가
		
		ths.value = null;
		// input 태그 값 초기화(text에는 값이 저장된 것이기에, text = ""와 같이는 사용할 수 없다.)
		
		for(const s of arr)
			alert(s + " ");

	}
}

/*function add_indivisuals_html(){
	
	$("#add_indivisuals_line").before(
		"<tr><td></td></tr>"
		+ "<tr>"
		+ 	"<td>카테고리</td>"
		+ 	"<td><input type='text' id='p_category_input' name='category' onkeydown='add_category(event)'></td>"
		+ "</tr>"
		+ "<tr>"
		+ 	"<td>사이즈</td>"
		+ 	"<td><input type='text' id='p_size_input' name='size'></td>"
		+ "</tr>"
		+ "<tr>"
		+ 	"<td>색상</td>"
		+ 	"<td><input type='text' id='p_color_input' name='color'></td>"
		+ "</tr>");
}*/
