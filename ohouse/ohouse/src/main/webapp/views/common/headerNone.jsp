<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${contextPath}/resources/css/common/header.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="${contextPath}/resources/js/headerInit.js"></script>
</head>
<body>
    <div align="center">
        <c:if test="${not empty alertMsg}">
            <script>
                alert("${alertMsg}");
            </script>
            <c:remove var="alertMsg" />
        </c:if>
        <div class="sticky-container" style="height: 80px;">
            <div class="header-logo" onclick="location.href='${pageContext.request.contextPath}'">
                오늘의집
            </div>
            <div class="header-main">
                <a href="${contextPath}"><span>쇼핑</span></a>
                <a href="${contextPath}/list.co"><span>커뮤니티</span></a>
            </div>
            <div class="header-menu">
                <div class="header-search">
                    <form action="${contextPath}/search.se" method="get">
                        <input type="text" id="hearder-search-input" placeholder="통합검색" name="searchKeyword" value="${searchKeyword }">
                        <button type="submit" id="hearder-search-button">
                          <img id="header-search-img" src="${contextPath}/resources/img/common/find.png" alt="">  
                        </button>
                    </form>
                </div>
                <c:choose>
                	<c:when test="${empty loginUser}">
		                <!-- 로그인X -->
		                <div class="header-others">
		                    <a href="${pageContext.request.contextPath}/loginForm.me">로그인</a>|
			                <a href="${pageContext.request.contextPath}/enrollForm.me">회원가입</a>
			                <a href="${contextPath}/loginForm.me" style="background-color: #35C5F0; color: white; border-radius: 5px;">글쓰기</a>
		                </div>
                	</c:when>
                	<c:otherwise>
		                <!-- 로그인O -->
		                <div class="header-others">
		                    <img src="${contextPath}/resources/img/common/pm-bookmark.png" alt="" 
                                onclick="location.href='${contextPath}/scrap.me'">
		                    <!-- <img src="${contextPath}/resources/img/common/shopping-cart.png" alt="" 
                                onclick="location.href='${contextPath}/cart.me'"> -->
		                    <img src="${contextPath}/resources/img/common/logout.png" alt=""
		                        onclick="location.href='${contextPath}/logout.me';">
		                    <img src="" alt="" id="header-profile"
                                onclick="location.href='${contextPath}/profile.me';">
		                    <a href="${contextPath}/enrollForm.co" style="background-color: #35C5F0; color: white; border-radius: 5px;">글쓰기</a>
		                </div>
                	</c:otherwise>
                </c:choose>
            </div>
        </div>
        <div style="border: 1px solid #f7f9fa; min-width: 1136px;"></div>
    </div>
    <script>
        $(function () {
            init("${loginUser.membersNo}", function (result) {
                if (result == null) {
                    $("#header-profile").attr("src", `${contextPath}//resources/img/common/user.png`);
                } else {
                    $("#header-profile").attr("src", `${contextPath}/` + result.filePath);
                }
            })
        })
    </script>
</body>
</html>