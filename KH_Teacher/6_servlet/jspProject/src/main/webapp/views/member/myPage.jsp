<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        margin: auto;
        margin-top: 50px;
        padding: 10px 0 50px 0;
    }

    table{
        margin: auto;
    }
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
    <%
    	String userId = loginUser.getUserId();
	    String userName = loginUser.getUserName();
	    String phone = loginUser.getPhone() == null ? "" : loginUser.getPhone();
	    String email = loginUser.getEmail() == null ? "" : loginUser.getEmail();
	    String address = loginUser.getAddress() == null ? "" : loginUser.getAddress();
	    String interest = loginUser.getInterest() == null ? "" : loginUser.getInterest(); 
    %>

    <div class="outer">
        <br>
        <h2 align="center">회원가입</h2>
        <form action="<%=contextPath%>/update.me" id="enroll-form" method="POST">
            <table>
                <tr>
                    <td>* 아이디</td>
                    <td><input type="text" name="userId" maxlength="12" value="<%=userId %>" readonly></td>
                    <td></td>
                </tr>
                <tr>
                    <td>* 이름</td>
                    <td><input type="text" name="userName" maxlength="6" value="<%=userName %>" required></td>
                    <td></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="text" name="phone"  placeholder="- 포함해서 입력" value="<%=phone %>"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="email" name="email" value="<%=email %>"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text" name="address" value="<%=address %>"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>관심분야</td>
                    <td colspan="2">
                        <input type="checkbox" name="interest" id="sports" value="운동">
                        <label for="sports">운동</label>
                        <input type="checkbox" name="interest" id="climbing" value="등산">
                        <label for="climbing">등산</label>
                        <input type="checkbox" name="interest" id="fishing" value="낚시">
                        <label for="fishing">낚시</label>
                        <br>
                        <input type="checkbox" name="interest" id="cooking" value="요리">
                        <label for="cooking">요리</label>
                        <input type="checkbox" name="interest" id="game" value="게임">
                        <label for="game">게임</label>
                        <input type="checkbox" name="interest" id="movie" value="영화">
                        <label for="movie">영화</label>
                        <input type="checkbox" name="interest" id="etc" value="기타">
                        <label for="etc">기타</label>
                    </td>
                </tr>
            </table>
            <script>
                const interest = "<%=interest%>"; // 운동,낚시
                const inputArr = document.querySelectorAll("input[name=interest]");
                //[<input>,<input>,<input>,<input>,<input>,<input>]

                for(let input of inputArr){ //가져온 checkbox요소들을 전부 반복한다.
                    if(interest.includes(input.value)){ // interest에 input.value의 값이 포함되어 있다면 true
                        input.checked = true;
                    }
                }
            </script>

            <br><br>

            <div align="center">
                <button type="submit" class="btn btn-sm btn-secondary">정보변경</button>
                <button type="button" class="btn btn-sm btn-primary" data-toggle="modal" data-target="#update-pwd-modal">
				  비밀번호변경
				</button>
                <button type="button" class="btn btn-sm btn-danger" data-toggle="modal" data-target="#delete-modal">
                	회원탈퇴
                </button>
            </div>
        </form>
    </div>

    <script>
        function checkPwd(){
            const pwd = document.querySelector("#enroll-form input[name=userPwd]").value;
            const pwdCheck = document.querySelector("#enroll-form input[name=userPwdCheck]").value;

            if (pwd !== pwdCheck){
                alert("비밀번호가 일치하지 않습니다.")
                return false;
            }
        }
    </script>
	
	<!-- 비밀번호 변경 modal-->
	<div class="modal" id="update-pwd-modal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">비밀번호 변경</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body" align="center">
	        <form action="<%=contextPath%>/updatePwd.me" method="POST">
                <input type="hidden" name="userId" value="<%=userId%>" >
                <table>
                    <tr>
                        <td>현재 비밀번호</td>
                        <td><input type="password" name="userPwd" required></td>
                    </tr>
                    <tr>
                        <td>변경할 비밀번호</td>
                        <td><input type="password" name="updatePwd" required></td>
                    </tr>
                    <tr>
                        <td>변경할 비밀번호 확인</td>
                        <td><input type="password" name="checkPwd" required></td>
                    </tr>
                </table>
                <br>
                <button id="edit-pwd-btn" type="submit" class="btn btn-sm btn-secondary">
                    비밀번호 변경
                </button>
            </form>
            <script>
                document.getElementById("edit-pwd-btn").onclick = function(){
                    const updatePwd = document.querySelector("input[name=updatePwd]").value;
                    const checkPwd = document.querySelector("input[name=checkPwd]").value;
                    
                    if(updatePwd !== checkPwd) {
                        alert("비밀번호를 확인해주세요.");
                        return false;
                    }
                  
                    // if($("input[name=updatePwd]").val() !== $("input[name=checkPwd]").val()){

                    // }
                }
            </script>
	      </div>
	
	     
	    </div>
	  </div>
	</div>
    
    <!-- 회원탈퇴 modal-->
	<div class="modal" id="delete-modal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">회원탈퇴</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body" align="center">
	     	<form action="<%=contextPath%>/delete.me" method="POST">
                <b>탈퇴 후 복구가 불가능합니다.<br>
                정말로 탈퇴하시겠습니까?</b>
                <br><br>
                <input type="hidden" name="userId" value="<%=userId%>">
                비밀번호 : <input type="password" name="userPwd" required>
                <br><br>
                <button type="submit" class="btn btn-sm btn-danger">탈퇴하기</button>

            </form>
	      </div>
	
	     
	    </div>
	  </div>
	</div>
    
    
</body>
</html>