<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content">

	<h3>제품 DB 조회 테이블</h3>
	<table class="product_table">
		<tr>
			<td>제품번호</td>
			<td>제품명</td>
			<td>카테고리</td>
			<td>제품가격</td>
			<td>할인률</td>
			<td>제품사진</td>
			<td>제품등록일자</td>
			<td>제품설명</td>
		</tr>
		<c:forEach var="prodList" items="${prodList}">
		<tr>
			<td>${prodList.id}</td>
			<td>${prodList.title}</td>
			<td>${prodList.category}</td>
			<td>${prodList.price}</td>
			<td>${prodList.discount}</td>
			<td><img class="picture" src="${prodList.picture}" alt="${prodList.title}"></td>
			<td>${prodList.discription}</td>
			<td>${prodList.up_Date}</td>
		</tr>
		</c:forEach>
	</table>
	
	<h3>사용자 DB 조회 테이블</h3>
	<table class="user_table">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>성명</td>
			<td>생년월일</td>
			<td>핸드폰</td>
			<td>구매한 상품 목록</td>
			<td>이번 달 총 결제금액</td>
			<td>포인트</td>
		</tr>
		<c:forEach var="userList" items="${userList}">
		<tr>
			<td>${userList.id}</td>
			<td>${userList.pw}</td>
			<td>${userList.name}</td>
			<td>${userList.birthdate}</td>
			<td>${userList.phonenum}</td>
			<td>${userList.b_item_num}</td>
			<td>${userList.t_pay}</td>
			<td>${userList.c_point}</td>
		</tr>
		</c:forEach>		
	</table>
	
	<h3>제품 등록</h3>
	<form action="/manage/add" id="form" method="post" enctype="multipart/form-data" accept-charset="UTF-8" onsubmit="return submit_prod()">
		<table class="add_product_table">
			<tr>
				<td>제품명</td>
				<td><input type="text" id="p_title_input" name="title"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="number" id="p_price_input" name="price"></td>
			</tr>
			<tr>
				<td>제품설명</td>
				<td><textarea id="p_description_input" cols="40" rows="10" name="description"></textarea></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><input type="file" name="img" accept="image/gif, image/jpeg, image/png" class="p_img_input"></td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td><input type="text" id="p_category_input" name="category" onkeydown="add_category(event)"></td>
			</tr>
			<tr>
				<td>사이즈</td>
				<td><input type="text" id="p_size_input" name="size"></td>
			</tr>
			<tr>
				<td>색상</td>
				<td><input type="text" id="p_color_input" name="color"></td>
			</tr>
			
			
			<tr id="add_indivisuals_line">
				<td>
					<button type="button" onclick="add_indivisuals_html()">추가</button>
				</td>
			</tr>
			<tr>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<td colspan="2"><button type="submit">제출</button>
			</tr>
					
		</table>
	</form>
</div>