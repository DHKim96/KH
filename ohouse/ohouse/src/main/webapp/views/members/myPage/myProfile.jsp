<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/myPage/myProfile.css">
</head>
<body>
    <header>
        <%@ include file="../../common/headerMyPage.jsp" %>
    </header>
    <div align="center">
        <div id="profile-total">
            <div id="profile-area">
                <div id="profile-info">
                    <div id="profile-img-area">
                        <img src="" alt=""><br>
                        <h2>${loginUser.membersName}</h1>
                    </div>
                    <button type="button" onclick="location.href='${contextPath}/updateForm.me'">설정</button>
                </div>
                <hr>
                <div id="profile-bookmark">
                    <img src="${contextPath}/resources/img/member/myPage/profile-bookmark.png" alt=""  onclick="location.href='${contextPath}/scrap.me'" >
                    <div>스크랩북</div>
                    <div id="scrap-count"></div>
                </div>
            </div>
            <script>
                let mNo = ${loginUser.membersNo};
                
                window.onload = function(){
                    $.ajax({
                        url: "profile.co",
                        data: {mNo: mNo},
                        success: function(result) {
                            if(result == null) {
                                $("#profile-img-area>img").attr("src", `${contextPath}/resources/img/common/user.png`);
                            } else{
                                $("#profile-img-area>img").attr("src", `${contextPath}` + `/` + result.filePath);
                            }
                        }
                    })

                    $.ajax({
                        url : "scrapCount.me",
                        data : {
                            mNo : mNo 
                        },
                        success : function(result){
                            drawScrapCount(result)
                        }, error : function(){
                            console.log("스크랩카운트 실패")
                        }
                    })

                    function drawScrapCount(result){
                        const scrapCountArea = document.getElementById("scrap-count");

                        scrapCountArea.innerHTML = result
                    }

                    $.ajax({
                        url : "communityCount.me",
                        data : {
                            mNo : mNo
                        },
                        success : function(res){                      
                            drawCommunityCount(res)
                        }, error : function(){
                            console.log("게시글카운트 실패")
                        }
                    })

                    function drawCommunityCount(res){
                        const communityCountArea = document.getElementById("profile-content-cnt");

                        communityCountArea.innerHTML = res
                    }
                    
                    $.ajax({
                        url : "communityList.me",
                        data : {
                            mNo : mNo
                        },
                        success : function(list){                      
                            drawCommunityList(list)
                        }, error : function(){
                            console.log("게시글 리스트 실패")
                        }
                    })

                    function drawCommunityList(list){
                        const communityListTest = document.getElementById("profile-content-area");
                        console.log(list)
                       
                        for(let i = 0; i < list.length; i++){
                            const communityList = list[i];
                            if(communityList){
                                communityListTest.innerHTML += `<div class="profile-content-img" onclick="location.href='${contextPath}/detail.co?bid=`+communityList.mediaBoardId+`'">
                                    <img id="profile-community-img" src="${pageContext.request.contextPath}/` + communityList.filePath + communityList.changeName +  `">
                                    </div>` 
                            }
                        }
                    }
                    
                }
            </script>
            <div id="profile-content">
                <h3>게시글 <span id="profile-content-cnt"></span></h3>
                <div id="profile-content-area">
                    
                    
                </div>
            </div>
        </div>
    </div>
    <footer>
        <%@ include file="../../common/footer.jsp" %>
    </footer>
</body>
</html>