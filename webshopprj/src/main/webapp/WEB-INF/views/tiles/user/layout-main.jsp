<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<link rel="shortcut icon" href="/favicon.ico">
	<meta charset="UTF-8">
	<title>메인 페이지</title>
	<script type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="/js/header.js" defer></script>
	<script type="text/javascript" src="/js/category.js" defer></script> 
	<link rel="stylesheet" type="text/css" href="<tiles:getAsString name="css" />" />
	<link rel="stylesheet" type="text/css" href="/css/common.css" />
	<link rel="stylesheet" type="text/css" href="/css/header.css" />
	
</head>
<body>
	<div class="root">	
		<div class="body">
			<tiles:insertAttribute name="header"/>				<!-- 헤더 -->
			<div class="content">								<!-- 내용 부분 -->
				<tiles:insertAttribute name="content-left"/>		<!-- 왼쪽 카테고리 -->
				<tiles:insertAttribute name="content-right"/>		<!-- 오른쪽 내용 -->
			</div>
			<tiles:insertAttribute name="footer"/>				<!-- 바닥글 -->
		</div>
	</div>
</body>
</html>