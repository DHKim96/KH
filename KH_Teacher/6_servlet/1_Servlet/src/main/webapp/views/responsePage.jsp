<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//스크립틀릿(scriptlet) == html문서내에서 자바코드를 쓸 수있는 영역
		
		String name = (String)request.getAttribute("name");
	%>
	
	<h1>개인정보 응답화면 - POST</h1>
	<span id="name"><%=name%></span>님은

</body>
</html>