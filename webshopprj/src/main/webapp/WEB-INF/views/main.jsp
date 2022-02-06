<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content-right">
	<div class="notice">
		<c:forEach var="prodList" items="${prodList}">
		<div class="items">
			<div class="item_img">
				<img alt="사진 &#13; 1" src="/img/img.jpg" />
			</div>
			<div class="item_text">
				<td>${prodList.id}</td>
				<td>${prodList.title}</td>
			</div>
			
		</div>
		</c:forEach>
	</div>
	<div class="hots">
	</div>
	<div class="recommend">
	</div>
</div>