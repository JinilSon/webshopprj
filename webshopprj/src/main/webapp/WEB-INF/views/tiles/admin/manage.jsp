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
</div>