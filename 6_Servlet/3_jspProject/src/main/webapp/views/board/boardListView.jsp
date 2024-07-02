<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, com.kh.board.model.vo.Board, com.kh.common.vo.PageInfo" %>
<%
    PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int maxPage = pi.getMaxPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        .outer {
            background-color: black;
            color: white;
            width: 1000px;
            height: 500px;
            margin: auto;
            margin-top: 50px;
        }

        .list-area {
            border: 1px solid white;
            text-align: center;
        }

        .list-area>tbody>tr:hover {
            background-color: gray;
            cursor: pointer;
        }
    </style>
</head>

<body>
    <%@ include file="../common/menubar.jsp" %>

        <div class="outer">
            <br>
            <h2 align="center">일반게시판</h2>
            <br>
    
            <% if(loginUser != null) { %>
                <!-- 로그인한 사용자에게만 보이도록 -->
                <div align="right" style="width: 850px; margin-bottom: 4px;">
                    <a href="<%=contextPath%>/enrollForm.bo" class="btn btn-sm btn-secondary">글쓰기</a>
                </div>
            <% } %>
            <table class="list-area" align="center">
                <thead>
                    <th width="70px">글번호</th>
                    <th width="80px">카테고리</th>
                    <th width="300px">제목</th>
                    <th width="100px">작성자</th>
                    <th width="50px">조회수</th>
                    <th width="100px">작성일</th>
                </thead>
                <tbody>
                    <% if(list.isEmpty()) { %>
                        <!--게시글이 없을 경우 -->
                        <tr>
                            <td colspan="6">게시글이 없습니다.</td>
                        </tr>
                    <% } else { %>
                        <!-- 있으면 반복문으로 list 꺼내면 됨 -->
                        <% for(Board b : list)  { %>
                            <tr>
                                <td><%=b.getBoardNo()%></td>
                                <td><%=b.getCategory()%></td>
                                <td><%=b.getBoardTitle()%></td>
                                <td><%=b.getBoardWriter()%></td>
                                <td><%=b.getCount()%></td>
                                <td><%=b.getCreateDate()%></td>
                            </tr>
                        <% } %>
                    <% } %>
                </tbody>
            </table>
           
           <br><br>
           
           <div class="paging-area" align="center">
           		<%if(currentPage != 1){%>
           			<button onclick="location.href='<%=contextPath%>/list.bo?cpage=<%=currentPage - 1 %>'">&lt;</button>
           		<%} %>
           		<%for(int p = startPage; p <= endPage; p++){ %>
           			<%if(p == currentPage) {%>
           				<button disabled><%=p %></button>
           			<%} else { %>
           				<button onclick="location.href='<%=contextPath%>/list.bo?cpage=<%=p %>'"><%=p %></button>
           			<%} %>
           		<%} %>
           		<%if(currentPage != maxPage){%>
           			<button onclick="location.href='<%=contextPath%>/list.bo?cpage=<%=currentPage + 1 %>'">&gt;</button>
           		<%} %>
           </div>
           
        </div>
        <script>
        
            // const trList = document.querySelectorAll(".list-area > tbody > tr")
            // //[tr, tr]
            // for(const tr of trList){
            //     tr.onclick = function(){
            //		또는 this 사용
            //         // const boardNo = this.childNodes[1]; // td들을 배열로 가져옴. 텍스트 노드까지 가져오기 때문에 공백도 가져와짐
            //         // const boardNo = this.childNodes[1].innerText;
            //         const boardNo = this.children[0].innerText;
            //         console.log(boardNo);
    
            //         // 일반게시판 상세페이지(/kh/detail.bo)로 이동
            //         location.href ="<%=contextPath%>/detail.bo?num=" + boardNo; // url ? 키 밸류,... 형식이기에
            //     }
            // }
            //제이쿼리
            $(function(){
                $(".list-area > tbody > tr").click(function(){
                   const boardNo = $(this).children().eq(0).text();
                    location.href ="<%=contextPath%>/detail.bo?bno=" + boardNo; // url ? 키 밸류,... 형식이기에
                })
            })
        </script>
</body>

</html>