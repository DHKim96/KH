<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="com.kh.notice.model.vo.Notice" %>
<% Notice n=(Notice)request.getAttribute("notice"); %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

    <style>
        .outer {
            background: black;
            color: white;
            width: 1000px;
            height: 500px;
            margin: auto;
            margin-top: 50px;
        }

        .outer table {
            border: 1px solid white;
            border-collapse: collapse;
        }

        .outer > table tr, .outer > table td{
            border: 1px solid white;
        }

    </style>
</head>

<body>
    <%@ include file="../common/menubar.jsp" %>

        <div class="outer" align="center">
            <br>
            <h2 align="center">공지사항 상세보기</h2>
            <br>
            <table>
                <tr>
                    <th width="70">제목</th>
                    <td colspan="3" width="430"><%=n.getNoticeTitle()%></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><%=n.getNoticeWriter()%></td>
                    <th>작성일</th>
                    <td><%=n.getCreateDate()%></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3">
                        <p style="height: 150px;"><%=n.getNoticeContent()%></p>
                    </td>
                </tr>
            </table>
            <br><br>
            <div>
              <a href="<%=contextPath %>/list.no" class="btn btn-sm btn-secondary">목록가기</a>
              <% if(loginUser != null && loginUser.getUserId().equals(n.getNoticeWriter())) { %>
              	<!-- 현재 로그인한 사용자가 해당 글을 쓴 보인일때만 -->
              	<a href="<%=contextPath %>/updateForm.no?num=<%=n.getNoticeNo() %>" class="btn btn-sm btn-warning">수정하기</a>
              	<a href="<%=contextPath %>/delete.no?num=<%=n.getNoticeNo() %>" class="btn btn-sm btn-danger">삭제하기</a>
              <% } %>
            </div>
        </div>
</body>

</html>