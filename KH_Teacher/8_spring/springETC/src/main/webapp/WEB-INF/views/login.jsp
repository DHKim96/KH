<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
<form action="login" method="post">
	<input type="text" name="nick">
	<input type="submit" value="로그인">
</form>
<a id="naverLoginLink">네이버로그인</a>
<script>
    //네이버로그인설정
    window.onload = function(){
        const clientId = "m1hCzwCK66Nrt_XkxJfr";
        //리다이렉트 URI를 utf-8로 인코딩해서 저장
        const redirectURI = encodeURIComponent("http://localhost:8899/etc/naver-login");

        const state = Math.random().toString(36).substring(2);
        
        //로그인 api url
        const apiURL = 'https://nid.naver.com/oauth2.0/authorize?response_type=code&'
            + 'client_id=' + clientId + "&redirect_uri=" + redirectURI + '&state=' + state;

        const loginBtn = document.getElementById('naverLoginLink');
        loginBtn.href= apiURL;
    }
</script>
</body>
</html>