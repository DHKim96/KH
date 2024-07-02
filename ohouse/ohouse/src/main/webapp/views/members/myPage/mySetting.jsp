<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/myPage/mySetting.css">
</head>
<body>
    <header>
        <%@ include file="../../common/headerMyPage.jsp" %>
    </header>
    <div align="center">
        <div id="mySetting-content" >
            <form action="${contextPath}/update.me" method="POST" enctype="multipart/form-data">
                <input type="hidden" name="mid">
                <div id="mySetting-img-area">
                    <img src="" alt="" onclick="profileChange()" id="profile-img-setting"><br>
                    <input type="file" name="profile" id="profile-hidden" onchange="loadImg(this)" class="mySetting-hidden">
                    <label for="profile-hidden">이미지 변경</label>
                </div>
                <div align="left" id="mySetting-content-area">
                    <div>
                        <h3>닉네임</h3>
                        <input type="text" name="name" class="mySetting-input" value="${loginUser.membersName}">
                        <div class="mySetting-msg">
                            <p class="mySetting-hidden">이미 존재하는 닉네임입니다.</p>
                            <p class="mySetting-hidden">닉네임은 4글자 이상입니다.</p>
                        </div>
                    </div>
                    <div>
                        <h3>이메일</h3>
                        <input type="email" name="email" class="mySetting-input" value="${loginUser.membersEmail}">
                        <div class="mySetting-msg"></div>
                    </div>
                    <div>
                        <h3>비밀번호 변경</h3>
                        <button type="button" id="pwd-change" data-toggle="modal" data-target="#update-pwd-modal" >비밀번호 변경</button>
                        <div class="mySetting-msg"></div>
                    </div>
                    <div>
                        <h3>휴대폰 번호</h3>
                        <input type="text" name="phone" class="mySetting-input" value="${loginUser.membersPhone}">
                        <div class="mySetting-msg"></div>
                    </div>
                    <div>
                        <h3>생년월일(예시: 1900-01-01)</h3>
                        <input type="text" name="birth" class="mySetting-input" placeholder="생년월일(예시: 1900-01-01)" value="${loginUser.membersBirth}">
                        <div class="mySetting-msg"></div>
                    </div>
                    <div>
                        <h3>성별</h3>
                        <div id="mySetting-radio">
                            <input type="radio" name="gender" id="male" value="남성">
                            <label for="male">남성</label>
                            <input type="radio" name="gender" id="female" value="여성">
                            <label for="female">여성</label>
                            <input type="radio" name="gender" id="none" value="선택하지 않음">
                            <label for="none">선택하지 않음</label>
                        </div>
                        <script>
                            $(function() {
                                const gender = $("input[name=gender]");
                                const userGender = "${loginUser.gender}";
                                if(userGender === "M") {
                                    $("#male").prop("checked", true);
                                } else if(userGender === "F") {
                                    $("#female").prop("checked", true);
                                } else {
                                    $("#none").prop("checked", true);
                                }
                            });
                        </script>
                    </div>
                    <hr>
                    <h3 style="cursor: pointer;" data-toggle="modal" data-target="#delete-modal">탈퇴하기</h3>
                </div>
                <button type="submit" id="setting-submit">완료</button>
            </form>
        </div>
    </div>
    <footer>
        <%@ include file="../../common/footer.jsp" %>
    </footer>

    <!-- 비밀번호 변경 modal -->
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
                    <form action="${pageContext.request.contextPath}/updatePwd.me" method="POST">
                        <input type="hidden" name="userId" value="${loginUser.membersId}">
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
                        document.getElementById("edit-pwd-btn").onclick = function () {
                            const updatePwd = document.querySelector("input[name=updatePwd]").value;
                            const checkPwd = document.querySelector("input[name=checkPwd]").value;

                            if (updatePwd !== checkPwd) {
                                alert("비밀번호를 확인해주세요.");
                                return false;
                            }
                            // if($("input[name=updatePwd]").val() !== $("input[name=checkPwd]").val()){}
                        }
                    </script>
                </div>
    
            </div>
        </div>
    </div>
    
    <!-- 회원탈퇴 modal -->
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
                    <form action="${contextPath}/delete.me" method="POST">
                        <b>탈퇴 후 복구가 불가능합니다.<br>
                            정말로 탈퇴하시겠습니까?</b>
                        <br><br>
                        <input type="hidden" name="checkId" value="${loginUser.membersId}">
                        비밀번호 : <input type="password" name="checkPwd" required>
                        <br><br>
                        <button type="submit" class="btn btn-sm btn-danger">탈퇴하기</button>
                    </form>
                </div>
    
            </div>
        </div>
    </div>
    <script src="${contextPath}/resources/js/headerInit.js"></script>
    <script>
        $(function () {
            init("${loginUser.membersNo}", function (result) {
                if (result == null) {
                    $("#profile-img-setting").attr("src", `${contextPath}/resources/img/common/user.png`);
                } else {
                    $("#profile-img-setting").attr("src", `${contextPath}/` + result.filePath);
                    $("input[name='mid']").val(result.mediaId);
                }
            })
        })

        function profileChange() {
            const imgInput = document.getElementById("profile-hidden");
            imgInput.click();
        }

        function loadImg(inputFile) {
            if(inputFile.files.length == 1) {
                const reader = new FileReader();
                reader.readAsDataURL(inputFile.files[0]);
                reader.onload = function(ev) {
                    $("#profile-img-setting").attr("src", ev.target.result);
                }
            } else {
                $("#profile-img-setting").attr("src", "${pageContext.request.contextPath}/resources/img/member/myPage/user.png");
            }
        }
    </script>
</body>
</html>