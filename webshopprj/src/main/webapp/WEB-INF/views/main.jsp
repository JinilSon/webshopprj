<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<link rel="shortcut icon" href="#">
	<meta charset="UTF-8">
	<title>메인 페이지</title>
	<script type="text/javascript" src="/customer/js/jquery-3.6.0.min.js"></script> 
	<script type="text/javascript" src="/customer/js/main.js" defer></script> 
	<link rel="stylesheet" type="text/css" href="/customer/css/main.css" />
	
</head>
<body>
	<div class="root">	
		<div class="body">
			<div class="header">			<!-- header 부분 -->
				<div class="header-content">
					<div class="header-left">
						<h1><a>Webshopprj</a></h1>
					</div>
					<input class="header-left-search" type="text" value="" placeholder=" 검색" size="20" maxlength="20" />
					
				</div>
			</div>
			<div class="content">			<!-- 내용 부분 -->
				<div class="content-left">
					<ul class="category">
						<li><h3><a>카테고리</a></h3></li>
						<li><h5><a>Category2</a></h5></li>
						<li><h5><a>Category3</a></h5></li>
						<li><h5><a>Category4</a></h5></li>
					</ul>
				</div>
				<div class="content-right">
					<div class="notice">
						<c:forEach var="prodList" items="${prodList}" varStatus="status">
						<tr>
							<td>${prodList.id}</td>
							<td>${prodList.title}</td>
						</tr>
						</c:forEach>
					</div>
					<div class="hots">
					</div>
					<div class="recommend">
					</div>
				</div>
			</div>
			<div class="footer">			<!-- footer 부분 -->
			</div>
		</div>
	</div>
</body>
</html>