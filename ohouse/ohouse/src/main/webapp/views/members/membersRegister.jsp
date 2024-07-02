<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String alertMsg = (String)session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원가입</title>
  <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <link rel="stylesheet" href="${contextPath}/resources/css/main.css">
  <link rel="stylesheet" href="${contextPath}/resources/css/member/memberRegister.css">
</head>

<body>
  <% if(alertMsg != null) { %>
		<script>
			alert("<%=alertMsg%>");
		</script>
		<% session.removeAttribute("alertMsg"); %>
	<% } %>
  <div class=wrapper>
    <section>
      <header>
        <div class=logo>
          <a href="${contextPath}">
            <img src="${pageContext.request.contextPath}/resources/img/member/오늘의집 로고.jpg" style="width: 88px; height: 33px;" alt="">
            <!-- ${pageContext.request.contextPath} -->
          </a>
        </div>
      </header>
      <main>
        <div class="enroll">
          <h1 style="font-size: 20px; margin: 0px;">회원가입</h1>
          <form action="${pageContext.request.contextPath}/insert.me" style="margin-top: 60px;" method="POST">
            <div id="enroll-id">
              <label for="id">아이디</label>
              <div class="enroll-notice">영문, 숫자를 포함한 8자 이상의 아이디를 입력해주세요.</div>
              <div id="enroll-id-input">
                <input type="text" name="id" id="id-input" maxlength="20" required placeholder="아이디">
              </div>
              <div class="warning id-empty hide" id="id-empty">필수 입력 항목입니다.</div>
              <div class="warning id-failure hide" id="id-failure">아이디 형식이 올바르지 않습니다.</div>
            </div>
            <!--아이디 인증을 위한 버튼-->
            <div id="id-confirm-button" class="margin30">
              <button type="button" onclick="idCheck();" disabled>아이디 중복체크</button>
            </div>
            <!-- 이메일 id + 주소 위한 div-->
            <div id="enroll-email" class="margin30">
              <label for="email">이메일</label>
              <div id="enroll-email-input">
                <input type="text" name="email" id="enroll-fullEmail">
                <input type="text" name="email-id" id="email-input" required placeholder="이메일">
                <span id="middle">@</span>
                <select id="select-Email">
                  <option value="">선택해주세요</option>
                  <option value="naver.com">naver.com</option>
                  <option value="hanmail.com">hanmail.com</option>
                  <option value="daum.net">daum.net</option>
                  <option value="gmail.com">gmail.com</option>
                  <option value="nate.com">nate.com</option>
                  <option value="hotmail.com">hotmail.com</option>
                  <option value="outlook.com">outlook.com</option>
                  <option value="icloud.com">icloud.com</option>
                  <option value="directly">직접입력</option>
                  <!--참고 https://choiiis.github.io/web/toy-project-sign-up-and-in-page-2/ -->
                </select>
              </div>
              <div class="warning email-empty hide" id="email-empty">필수 입력 항목입니다.</div>
              <div class="warning email-failure hide" id="email-failure">이메일 형식이 올바르지 않습니다.</div>
            </div>
            <!-- 비밀번호 위한 div-->
            <div id="enroll-pwd" class="margin30">
              <label for="pwd">비밀번호</label>
              <div class="enroll-notice">영문, 숫자를 포함한 8자 이상의 비밀번호를 입력해주세요.</div>
              <input type="password" name="pwd" class="input-style" id="input-pwd" required placeholder="비밀번호">
              <!--비밀번호 유효성 검사 실패 시 보여줄 텍스트들-->
              <div class="warning pwd-empty hide" id="pwd-empty">필수 입력 항목입니다.</div>
              <div class="warning pwd-failure hide" id="pwd-failure">비밀번호는 영문, 숫자를 포함하여 8자 이상이어야 합니다.</div>
            </div>
            <!-- 비밀번호 확인 위한 div-->
            <div id="enroll-pwd-confirm" class="margin30">
              <label for="pwd-confirm">비밀번호 확인</label>
              <input type="password" name="pwd-confirm" class="input-style" id="confirm-pwd" placeholder="비밀번호 확인">
              <!-- 비밀번호 확인 유효성 검사 실패 시 보여줄 텍스트들-->
              <div class="warning pwdCon-empty hide" id="pwdCon-empty">확인을 위해 비밀번호를 한 번 더 입력해주세요.</div>
              <div class="warning pwdCon-failure hide" id="pwdCon-failure">비밀번호가 일치하지 않습니다.</div>
            </div>
            <!-- 핸드폰 번호 받기 위한 div-->
            <div id="enroll-phone" class="margin30">
              <label for="phone">전화번호</label>
              <div class="enroll-notice">'-'을 포함한 전화번호를 입력해주세요 <br> 예) 010-1111-2222</div>
              <input type="text" name="phone" class="input-style" id="input-phone" placeholder="전화번호 입력">
              <!-- 전화번호 유효성 검사 실패 시 보여줄 텍스트들-->
              <div class="warning phone-empty hide" id="phone-empty">전화번호를 입력해주세요.</div>
              <div class="warning phone-failure hide" id="phone-failure">전화번호 형식이 올바르지 않습니다.</div>
            </div>
            <!--닉네임 위한 div-->
            <div id="enroll-nickname" class="margin30">
              <label for="nickname">닉네임</label>
              <div class="enroll-notice">다른 유저와 겹치지 않도록 입력해주세요.(2~20자)</div>
              <input type="text" name="nickname" class="input-style" id="input-nickname" required placeholder="별명(2~20자)">
              <!-- 닉네임 유효성 검사 실패 시 보여줄 텍스트들-->
              <div class="warning nickname-empty hide" id="nickname-empty">필수 입력 항목입니다.</div>
              <div class="warning nickname-min hide" id="nickname-min">2자 이상 입력해주세요.</div>
              <div class="warning nickname-max hide" id="nickname-max">20자 이하로 입력해주세요.</div>
            </div>
            <!-- 이메일, 비밀번호, 닉네임을 보내기 위한 버튼을 담은 div-->
            <div id="enroll-submit-button">
              <button type="submit" id="enroll-submit">회원가입하기</button>
            </div>
          </form>
          <p>이미 아이디가 있으신가요? <a href="${contextPath}/loginForm.me">로그인</a></p>
        </div>
      </main>
    </section>
  </div>

  <script>
    // 아이디 입력 필드
    const inputId = document.getElementById('id-input');
    // 이메일 유효성 검사 실패 시 보여줄 텍스트
    const warnIdEmpty = document.getElementById('id-empty');
    const warnIdFailure = document.getElementById('id-failure');
    let isId = false;
    // 이메일 입력 필드
    const elEmail = document.getElementById('email-input');
    // 이메일 주소 선택 셀렉트 박스
    const elAddress = document.getElementById('select-Email');
    // 이메일 유효성 검사 실패 시 보여줄 텍스트
    const warnEmailEmpty = document.getElementById('email-empty');
    const warnEmailFailure = document.getElementById('email-failure');
    // 비밀번호 입력 필드
    const inputPwd = document.getElementById('input-pwd');
    // 비밀번호 유효성 검사 실패 시 보여줄 텍스트
    const warnPwdEmpty = document.getElementById('pwd-empty');
    const warnPwdFailure = document.getElementById('pwd-failure');
    let isPwd = false;
    // 비밀번호 확인 입력 필드
    const confirmPwd = document.getElementById('confirm-pwd');
    let isConfirmPwd = false;
    // 비밀번호 확인 유효성 검사 실패 시 보여줄 텍스트
    const warnNameEmpty = document.getElementById('nickname-empty');
    const warnNameMin = document.getElementById('nickname-min');
    const warnNameMax = document.getElementById('nickname-max');
    // 전화번호 입력 필드
    const inputPhone = document.getElementById('input-phone');
    // 전화번호 유효성 검사 실패 시 보여줄 텍스트
    const warnPhoneEmpty = document.getElementById('phone-empty');
    const warnPhoneFailure = document.getElementById('phone-failure');
    let isPhone = false;
    // 닉네임 입력 필드
    const nicknameInput = document.getElementById('input-nickname')
    // 닉네임 유효성 검사 실패 시 보여줄 텍스트
    const warnPConEmpty = document.getElementById('pwdCon-empty');
    const warnPConFailure = document.getElementById('pwdCon-failure');
    let isName = false;

    $(function(){
      if(isId & isPwd & isConfirmPwd & isPhone & isName) {
        $("#enroll-submit").attr("disabled", "false");
      } else {
        $("#enroll-submit").attr("disabled", "true");
      }
    })

    // 이메일 입력 필드 또는 주소 선택 셀렉트 박스 값 변경 시 이메일 유효성 검사 함수 호출
    inputId.onblur = function () {
      validateId();
    }
    elEmail.onblur = function () {
      validateEmail();
    }
    elAddress.onchange = function () {
      validateEmail();
    }
    inputPwd.onblur = function(){
      validatePwd();
    }
    confirmPwd.onblur = function(){
      confirmPassword();
    }
    inputPhone.onblur = function(){
      validatePhone();
    }
    nicknameInput.onblur = function(){
      validateNickname();
    }

    function validateId() {
      const idRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
      const idCheckBtn = document.querySelector("#id-confirm-button>button");
      isId = false;
      if(inputId.value.trim() === ""){
        warnIdEmpty.classList.remove("hide");
        warnIdFailure.classList.add("hide");
      } else if(!(idRegex.test(inputId.value))) {
        warnIdEmpty.classList.add("hide");
        warnIdFailure.classList.remove("hide");
      } else {
        warnIdEmpty.classList.add("hide");
        warnIdFailure.classList.add("hide");
        idCheckBtn.removeAttribute("disabled");
      }
    }

    // 하나의 완성된 이메일로 합치기 위한 함수
    function validateEmail() {
      const emailId = elEmail.value;
      const middle = document.getElementById('middle').innerHTML;
      const address = elAddress.options[elAddress.selectedIndex].value;
      const email = emailId + middle + address;
      if(emailId.trim() === ""){
        warnEmailEmpty.classList.remove("hide");
      } else {
        warnEmailEmpty.classList.add("hide");
        const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if(address.trim() === ""){
          warnEmailFailure.classList.remove("hide");
        } else if(emailRegex.test(email)){
          warnEmailFailure.classList.add("hide");
        } else {
          document.getElementById("enroll-fullEmail").value = email;
        }
      }
      $(function() {
        $("#enroll-fullEmail").val(email);
      })
    }

    function validatePwd(){
      const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
      isPwd = false;
      if(inputPwd.value.trim() === ""){
        warnPwdEmpty.classList.remove("hide");
        warnPwdFailure.classList.add("hide");
      } else if(!(passwordRegex.test(inputPwd.value))) {
        warnPwdEmpty.classList.add("hide");
        warnPwdFailure.classList.remove("hide");
      } else {
        warnPwdEmpty.classList.add("hide");
        warnPwdFailure.classList.add("hide");
        isPwd = true;
      }
    }

    function confirmPassword() {
      isConfirmPwd = false;
      if (confirmPwd.value.trim() === "") {
        warnPConEmpty.classList.remove("hide");
        warnPConFailure.classList.add("hide");
      } else if (inputPwd.value !== confirmPwd.value) {
        warnPConEmpty.classList.add("hide");
        warnPConFailure.classList.remove("hide");
      } else {
        warnPConEmpty.classList.add("hide");
        warnPConFailure.classList.add("hide");
        isConfirmPwd = true;
      }
    }

    function validatePhone(){
      const phone = inputPhone.value.trim();
      isPhone = false;
      if(phone === ""){
        //전화번호 입력창 공백일 시
        warnPhoneEmpty.classList.remove("hide");
        warnPhoneFailure.classList.add("hide");
      } else {
        // 공백아닐 시
        warnPhoneEmpty.classList.add("hide");
        const phoneRegex = /^\d{3}-\d{4}-\d{4}$/;
        if(!phoneRegex.test(phone)){ // 유효성 검사 실패시
          warnPhoneFailure.classList.remove("hide");
          warnPhoneEmpty.classList.add("hide");
        } else{ // 유효성 검사 성공시
          warnPhoneFailure.classList.add("hide");
          warnPhoneEmpty.classList.add("hide");
          isPhone = true;
        }
      }
    }

    function validateNickname(){
      const nickname = nicknameInput.value.trim();
      isName = false;
      if(nickname === ""){
        // 닉네임이 비어있는 경우
        warnNameEmpty.classList.remove("hide");
        warnNameMax.classList.add("hide");
        warnNameMin.classList.add("hide");
      } else {
        // 비어있지 않은 경우
        warnNameEmpty.classList.add("hide");
        if(nickname.length < 2){
          // 닉네임이 2자 미만인 경우
          warnNameMin.classList.remove("hide");
          warnNameMax.classList.add("hide");
        } else if(nickname.length > 20){
          // 닉네임이 20자 초과 시
          warnNameMax.classList.remove("hide");
          warnNameMin.classList.add("hide");
        } else {
          // 닉네임 유효시
          warnNameMin.classList.add("hide");
          warnNameMax.classList.add("hide");
          isName = true;
        }
      }
    }

    function idCheck() {
      $.ajax({
        type: "GET",
        url: "idCheck.me",
        data: {
          checkId: inputId.value
        },
        success: function (result) {
          if (result === "Y") {
            if (confirm("사용가능한 아이디입니다. 사용하시겠습니까?")) {
              inputId.setAttribute("readonly", true);
              document.querySelector("#enroll-submit").removeAttribute("disabled");
              isId = true;
            } else {
              inputId.focus();
            }
          } else {
            alert("사용불가능한 아이디입니다.");
            inputId.focus();
          }
        },
        error: function (err) {
          console.log("실패 : ", err)
        }
      });
    }
  </script>
</body>

</html>