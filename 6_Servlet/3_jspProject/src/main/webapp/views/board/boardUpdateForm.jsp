<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.ArrayList, 
    		com.kh.board.model.vo.Category,
    		com.kh.board.model.vo.Board,
    		com.kh.common.vo.Attachment" %>

<%
    ArrayList<Category> categories = (ArrayList<Category>)request.getAttribute("categories");
	Board b = (Board)request.getAttribute("board");
	// 글번호, 카테고리명(문자열), 제목, 내용, 작성자, 작성일
	Attachment at = (Attachment)request.getAttribute("attachment");
	// 없을 수도 있음(null)
	// 존재 시 파일 번호, 원본명, 수정파일명, 저장 경로
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
                    	<!-- 게시글의 카테고리 넘버를 가져와야함 -->
                        <select name="category">
                        	<%for(Category c : categories) {%>
                            	<option value="<%=c.getCategoryNo()%>"><%=c.getCategoryName()%></option>
                            <%} %>
                        </select>
                        <script>
                            //카테고리 셀렉트 박스의 옵션들을 모두 가져온 뒤 내가 선택한 옵션이 무엇인지 선별
                            const options = document.querySelectorAll("#update-form option");
                            console.log(options)
                            for (let opt of options){
                            	console.log(opt.innerText === "<%=b.getCategory()%>")
                                if(opt.innerText === "<%=b.getCategory()%>"){
                                    opt.selected = true;
                                }
                            }
                        </script>
                    </td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title" value="<%=b.getBoardTitle()%>" required></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td>
                    	<textarea name="content" rows="10" style="resize: none;" required><%=b.getBoardContent()%></textarea>
                    </td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td>
                    	<!-- 새로 넣을 때에도 기존 것은 보여줘야 함 -->
                    	<%if(at != null){ %>
                    		<%=at.getOriginName()%>
                    		<input type="hidden" name="originFileNo" value="<%=at.getFileNo()%>">
                    	<% } %>
                    	<input type="file" name="upfile">
                    </td>
                </tr>
            </table>

            <br>

            <div align="center">
                <button type="submit">수정하기</button>
                <button type="reset">취소하기</button>
            </div>
        </form>
    </div>

</body>
</html>