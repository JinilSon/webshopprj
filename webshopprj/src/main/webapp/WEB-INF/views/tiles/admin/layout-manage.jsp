<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<link rel="shortcut icon" href="#">
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="/customer/js/jquery-3.6.0.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<tiles:getAsString name="css" />" />
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