<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.notice.model.vo.Notice" %>
<%
    ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{
        background-color: black;
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
        background-color: gray;
        cursor: pointer;
    }
</style>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>

    <div class="outer">
        <br>
        <h2 align="center">공지사항</h2>
        <br>

        <% if(loginUser != null && loginUser.getUserId().equals("admin")) { %>
            <!-- 현재 로그인한 유저가 관리자일 때 글쓰기 버튼 나타나도록-->
            <div align="right" style="width: 850px; margin-bottom: 4px;">
                <a href="<%=contextPath %>/enroll.no" class="btn btn-sm btn-secondary">글쓰기</a>
            </div>
        <% } %>
        <table class="list-area" align="center">
            <thead>
                <th>글번호</th>
                <th width="400px">제목</th>
                <th width="100px">작성자</th>
                <th>조회수</th>
                <th width="100px">작성일</th>
            </thead>
            <tbody>
                <% if(list.isEmpty()) { %>
                    <!-- 공지사항이 없을 경우 -->
                    <tr>
                        <td colspan="5">공지사항이 없습니다.</td>
                    </tr>
                <% } else { %>
                    <!-- 있으면 반복문으로 list 꺼내면 됨 -->
                    <% for(Notice n : list)  { %>
                        <tr>
                            <td><%=n.getNoticeNo()%></td>
                            <td><%=n.getNoticeTitle()%></td>
                            <td><%=n.getNoticeWriter()%></td>
                            <td><%=n.getCount()%></td>
                            <td><%=n.getCreateDate()%></td>
                        </tr>
                    <% } %>
                <% } %>
            </tbody>
        </table>
    </div>
	<script>
        // const trList = document.querySelectorAll(".list-area > tbody > tr")
        // //[tr, tr]
        // for(const tr of trList){
        //     tr.onclick = function(){
        //         // const noticeNo = this.childNodes[1]; // td들을 배열로 가져옴. 텍스트 노드까지 가져오기 때문에 공백도 가져와짐
        //         // const noticeNo = this.childNodes[1].innerText;
        //         const noticeNo = this.children[0].innerText;
        //         console.log(noticeNo);

        //         // 공지사항 상세페이지(/kh/detail.no)로 이동
        //         location.href ="<%=contextPath%>/detail.no?num=" + noticeNo; // url ? 키 밸류,... 형식이기에
        //     }
        // }
        //제이쿼리
        $(function(){
            $(".list-area > tbody > tr").click(function(){
               const noticeNo = $(this).children().eq(0).text();
                location.href ="<%=contextPath%>/detail.no?num=" + noticeNo; // url ? 키 밸류,... 형식이기에
            })
        })
    </script>
</body>
</html>