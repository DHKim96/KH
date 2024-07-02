<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/main.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/member/memberLogin.css">
</head>
<body>
    <div class="wrapper">
    	<c:if test="${not empty alertMsg}">
            <script>
                alert("${alertMsg}");
            </script>
            <c:remove var="alertMsg" />
        </c:if>
        <main>
            <div class="container">
                <div class="content">
                    <a aria-label="오늘의집" href="${contextPath}">
                        <img src="${contextPath}/resources/img/member/오늘의집 로고.jpg" alt="">
                    </a>
                    <form action="${contextPath}/login.me" method="POST">
                        <input type="hidden" name="userId">
                        <input type="hidden" name="userPassword">
                        <div class="div-input">
                            <input type="text" name="id" class="input-style" id="input-id" placeholder="아이디">
                        </div>
                        <div class="div-input">
                            <input type="password" name="password" class="input-style" id="input-password" placeholder="비밀번호">
                        </div>
                        <button type="submit">로그인</button>
                        <section>
                            <a href="#">비밀번호 재설정</a>
                            <a href="${contextPath}/enrollForm.me" style="margin-left: 20px;">회원가입</a>
                        </section>
                    </form>
                </div>
            </div>
            <footer></footer>
        </main>
    </div>
</body>
</html>