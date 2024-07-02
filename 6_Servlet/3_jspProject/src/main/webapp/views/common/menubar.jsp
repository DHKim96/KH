<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member"%>
<%
	String contextPath = request.getContextPath();

    Member loginUser = (Member)session.getAttribute("loginUser");
    // 로그인 시도 전 menubar.jsp로딩시 : null
    // 로그인 성공 후 menubar.jsp로딩시 : 로그인 성공한 회원의 정보
    
    String alertMsg = (String)session.getAttribute("alertMsg");
    //서비스 요청 전 : null
    //서비스 요청 후 : alert띄워줄 메세지 문구
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <!-- Latest compiled and minified CSS -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

 <!-- jQuery library -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
 <!-- Popper JS -->
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

 <!-- Latest compiled JavaScript -->
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

 <style>
    a{
        text-decoration: none;
        color: white;
    }
    .login-area > *{
        float: right;
    }

    .login-area a{
        color: black;
    }

    .nav-area{background: black;}
    .menu{
        display: table-cell;
        width: 150px;
        height: 50px;
    }
    .menu a{
        line-height: 50px;
        font-size: 20px;
        font-weight: bold;
        text-align: center;
        width: 100%;
        height: 100%;
        display: block;
    }
 </style>
</head>
<body>
	<% if(alertMsg != null){ %>
		<script>
			alert("<%=alertMsg%>");
		</script>
		<% session.removeAttribute("alertMsg"); %>
	<% } %>
    <h1 align="center">Welcome KH World</h1>
    <div class="login-area">
        <% if(loginUser == null) { %>
            <!-- 로그인 전 -->
            <form action="<%=contextPath %>/login.me" method="POST">
                <table>
                    <tr>
                        <th>아이디</th>
                        <td><input type="text" name="userId" required></td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td><input type="password" name="userPwd" required></td>
                    </tr>
                    <tr>
                        <th colspan="2">
                            <input type="submit" value="로그인">
                            <input type="button" value="회원가입" onclick="enrollPage();">
                        </th>
                    </tr>
                </table>
                <script>
                    function enrollPage(){
						//location.href = "<%=contextPath%>/views/member/memberEnrollForm.jsp";
                    	//웹 애플리케이션의 디렉토리 구조가 url에 노출되면 보안에 취약
						
                    	location.href = "<%=contextPath%>/enrollForm.me";
                    	//단순한 페이지 요청도 servlet을 거쳐갈 것(즉, url에는 서블릿 맵핑값만 나타나도록)
                    }
                </script>
            </form>
        <% } else { %>
            <!-- 로그인 후 -->
            <div>
                <b><%=loginUser.getUserName()%>님</b>의 방문을 환영합니다<br><br>
                <div align="center">
                    <a href="<%=contextPath %>/myPage.me">마이페이지</a>
                    <a href="<%=contextPath %>/logout.me">로그아웃</a>
                </div>
            </div>
        <% } %>
    </div>

    <br clear="both"><br>

    <div class="nav-area" align="center">
        <div class="menu"><a href="<%=contextPath %>">HOME</a></div>
        <div class="menu"><a href="<%=contextPath %>/list.no">공지사항</a></div>
        <div class="menu"><a href="<%=contextPath %>/list.bo?cpage=1">일반게시판</a></div>
        <div class="menu"><a href="<%=contextPath %>/list.th">사진게시판</a></div>
    </div>

    
</body>
</html>