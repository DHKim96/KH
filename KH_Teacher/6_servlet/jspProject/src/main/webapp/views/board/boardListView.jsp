<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.common.vo.PageInfo, java.util.ArrayList, com.kh.board.model.vo.Board" %>

<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    .outer{
        background: black;
        color: white;
        width: 1000px;
        height: 500px;
        margin: auto;
        margin-top: 50px;
    }

    .list-area{
        border: 1px solid white;
        text-align: center;
    }
    .list-area>tbody>tr:hover{
        background: gray;
        cursor: pointer;
    }
</style>
</head>
<body>
    <%@ include file="../common/menubar.jsp"%>

    <div class="outer">
        <br>
        <h2 align="center">일반게시판</h2>
        <br>

        <% if( loginUser != null){%>
            <!-- 로그인한 사용자 일때-->
            <div align="right" style="width: 850px; margin-bottom: 4px;">
                <a href="<%=contextPath %>/enrollForm.bo" class="btn btn-sm btn-secondary">글쓰기</a>
            </div>
        <%}%>    
        <table class="list-area" align="center">
            <thead>
                <th width="70">글번호</th>
                <th width="80">카테고리</th>
                <th width="300">제목</th>
                <th width="100">작성자</th>
                <th width="50">조회수</th>
                <th width="100">작성일</th>
            </thead>
            <tbody>
              	<% if(list.isEmpty()) { %>
	                <!-- 게시글이 없을 경우 -->
	                <tr>
	                    <td colspan="6">존재하는 게시글이 없습니다.</td>
	                </tr> 
                <% } else { %>
					<%for(Board b : list) { %>
		                <!-- 게시글 있는 경우 -->
		                <tr>
		                    <td><%=b.getBoardNo() %></td>
		                    <td><%=b.getCategory() %></td>
		                    <td><%=b.getBoardTitle() %></td>
		                    <td><%=b.getBoardWriter() %></td>
		                    <td><%=b.getCount() %></td>
		                    <td><%=b.getCreateDate() %></td>
		                </tr>
		            <% } %>
              	<% } %> 
            </tbody>
        </table>
        <script>
        	//kh/detail.bo?bno=? 요청
        	const trList = document.querySelectorAll(".list-area>tbody>tr");
            for (let tr of trList) {
                tr.onclick = function(){
                    // this => 클릭된 객체를 가르킨다.
                    // .children => 객체의 자식노드list를 전부 가져온다.
                    let bno = this.children[0].innerText;
                    location.href = "<%=contextPath%>/detail.bo?bno=" + bno;
                }
            }
        </script>
        
        <br><br>
        <div class="paging-area" align="center">
        	<%if(currentPage != 1){ %>
        		<button onclick="location.href='<%=contextPath%>/list.bo?cpage=<%=currentPage - 1%>'">&lt;</button>
        	<%} %>
        	<%for(int p = startPage; p <= endPage; p++){ %>
        		<%if(p == currentPage) { %>
        			<button disabled><%=p %></button>
        		<%} else { %>
        			<button onclick="location.href='<%=contextPath%>/list.bo?cpage=<%=p %>'"><%=p %></button>
        		<%} %>
        	<%} %>
        	<%if(currentPage != maxPage){ %>
        		<button onclick="location.href='<%=contextPath%>/list.bo?cpage=<%=currentPage + 1%>'">&gt;</button>
        	<%} %>
        </div>
    </div>
</body>
</html>