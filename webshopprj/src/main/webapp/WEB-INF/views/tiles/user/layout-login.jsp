<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<!-- <link rel="shortcut icon" href="#"> -->		<!-- favicon에 # 연결 시, 해당 페이지를 두 번 로드하는 오류가 발생한다. -->
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<tiles:getAsString name="css"/>" />
	<link rel="stylesheet" type="text/css" href="/css/header.css" />
</head>
<body>
	<div class="root">
		<div class="body">
			<tiles:insertAttribute name="header" />
			<tiles:insertAttribute name="content"/>
			<tiles:insertAttribute name="footer"/>
		</div>
	</div>
</body>
</html>