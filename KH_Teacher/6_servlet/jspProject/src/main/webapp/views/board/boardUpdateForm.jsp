<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.board.model.vo.Category" %>
<%@ page import="com.kh.board.model.vo.Board, com.kh.board.model.vo.Attachment" %>
<%
	ArrayList<Category> list = (ArrayList<Category>)request.getAttribute("list");

	Board b = (Board)request.getAttribute("b");
	//글번호, 카테고리명, 제목, 내용, 작성자, 작성일
	
	Attachment at = (Attachment)request.getAttribute("at");
	//없을 수도 있다. null
	//있다면 파일번호, 원본명, 수정명, 저장경로
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
        height: 550px;
        margin: auto;
        margin-top: 50px;
    }
    #update-form table{
        border: 1px solid white;
    }
    #update-form input, #update-form textarea{
        width: 100%;
        box-sizing: border-box;
    }
</style>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>

    <div class="outer" align="center">
        <br>
        <h2 align="center">일반게시판 수정하기</h2>
        <br>

        <form id="update-form" action="<%=contextPath %>/update.bo" method="post" enctype="multipart/form-data">
            <input type="hidden" name="bno" value="<%=b.getBoardNo()%>">
            <table>
                <tr>
                    <th width="70">카테고리</th>
                    <td width="500">
                        <select name="category">
                        	<!-- category테이블로부터 조회해오기 -->
                        	<% for(Category c : list) { %>
                            	<option value="<%=c.getCategoryNo()%>"><%=c.getCategoryName() %></option>
                            <%} %>
                        </select>
                        <script>
                            const optList = document.querySelectorAll("#update-form option");
                            for (let opt of optList){
                                if(opt.innerText === "<%=b.getCategory()%>"){
                                    opt.selected = true;
                                }
                            }
                        </script>
                    </td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title" required value="<%=b.getBoardTitle()%>"></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea name="content" rows="10" style="resize: none;" required><%=b.getBoardContent()%></textarea></td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td>
                    	<%if(at != null){ %>
                    		<%=at.getOriginName() %>
                    		<input type="hidden" name="originFileNo" value="<%=at.getFileNo()%>">
                    	<%} %>
                    	<input type="file" name="upfile">
                    </td>
                </tr>
            </table>

            <br>

            <div align="center">
                <button type="submit">작성하기</button>
                <button type="reset">취소하기</button>
            </div>
        </form>
    </div>

</body>
</html>