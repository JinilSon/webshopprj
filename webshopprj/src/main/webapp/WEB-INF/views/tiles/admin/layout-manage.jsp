<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="_csrf" content="${_csrf.token}" />
	<meta name="_csrf_header" content="${_csrf.headerName}" />
	<title>Insert title here</title>
	<script type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="/js/header.js" defer></script>
	<script type="text/javascript" src="/js/manage.js" defer></script> 
	<link rel="stylesheet" type="text/css" href="/css/common.css" />
	<link rel="stylesheet" type="text/css" href="/css/header.css" />
	<link rel="stylesheet" type="text/css" href="<tiles:getAsString name="css" />" />
	<link rel="shortcut icon" href="/favicon.ico">
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