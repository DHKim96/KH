<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="com.kh.board.model.vo.Board, com.kh.common.vo.Attachment, java.util.ArrayList" %>
    
<%
    Board b = (Board)request.getAttribute("board");
	// 글번호, 카테고리명, 제목, 내용, 작성자, 작성일
	ArrayList<Attachment> attachments = (ArrayList<Attachment>)request.getAttribute("attachments");
	// 없을 수도 있음(null)
	// 존재 시 파일 번호, 원본명, 수정파일명, 저장 경로
	
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

        .detail-area td,
        .detail-area th{
            border: 1px solid white;
            text-align: center;
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
            <h2 align="center">사진게시판 상세보기</h2>
            <br>
            <table id="detail-area" border="1" align="center">
                <tr>
                    <th width="100px">제목</th>
                    <td colspan="3" width="600px"><%=b.getBoardTitle()%></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><%=b.getBoardWriter()%></td>
                    <th>작성일</th>
                    <td><%=b.getCreateDate()%></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3">
                        <p style="height: 200px;"><%=b.getBoardContent()%></p>
                    </td>
                </tr>
                <tr>
                    <th>대표이미지</th>
                    <td colspan="3">
                        <img src="<%=contextPath %>/<%=attachments.get(0).getFilePath() + attachments.get(0).getChangeName()%>">
                    </td>
                </tr>
                <tr>
                    <th>상세이미지</th>
                    <td colspan="3">
                    	<%for(int i = 1; i < attachments.size(); i++){ %>
                        <img id="<%=contextPath %>/<%=attachments.get(i).getFilePath() + attachments.get(i).getChangeName()%>" width="200" height="250";>
                    	<%} %>
                    </td>
                </tr>
            </table>
            <br><br>
            <div align="center">
		           <a href="<%=contextPath %>/list.th" class="btn btn-sm btn-secondary">목록가기</a>
            </div>
        </div>
</body>

</html>