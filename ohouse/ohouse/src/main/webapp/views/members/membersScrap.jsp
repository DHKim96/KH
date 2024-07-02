<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/memberScrap.css">
</head>
<body>
    <header>
        <%@ include file="../common/headerNone.jsp" %>
    </header>
    <div align="center">
        <div class="content">
            <div align="left"> 
                <h2><b>스크랩북</b></h2>
            </div>
            <div id="scrap-profile-area">
                <img src="" alt=""
                    id="profile-img-setting"><br>
                <h2>${loginUser.membersName}</h2>
            </div>
            <nav id="scrap-nav">
                <button class="media clicked btn" onclick="navclicked(2,0,'detail.co?bid=');"><b>사진&nbsp;</b><span id="scrap-count1"></span></button>
                <button class="contents btn" onclick="navclicked(3,1,'detail.co?bid=');"><b>게시글&nbsp;</b><span id="scrap-count2"></span></button>
                <button class="item btn" onclick="navclicked(1,2,'detail.pr?productId=');"><b>상품&nbsp;</b><span id="scrap-count3"></span></button>
            </nav>
           
            
            <div id="scrap-item">
            	        	  

            </div>
        </div>
    </div>
    <script>
        let mNo = ${loginUser.membersNo};
                
                window.onload = function(){

                    $.ajax({
                        url: "profile.co",
                        data: {mNo: mNo},
                        success: function(result) {
                            // console.log(result)
                            if(result == null) {
                                $("#profile-img-setting").attr("src", `${contextPath}/resources/img/common/user.png`);
                            } else{
                                $("#profile-img-setting").attr("src", `${contextPath}` + `/` + result.filePath);
                            }
                        }
                    })


                    $.ajax({
                        url : "scrapPageCount.me",
                        data : {
                            mNo : mNo,
                            scrapType : 2
                        },
                        success : function(result){
                            drawScrapCount2(result)
                        }, error : function(){
                            console.log("스크랩카운트 실패")
                        }
                    })

                    function drawScrapCount2(result){
                        const scrapCountArea = document.getElementById("scrap-count1");

                        scrapCountArea.innerHTML = result
                    }

                    $.ajax({
                        url : "scrapPageCount.me",
                        data : {
                            mNo : mNo,
                            scrapType : 3
                        },
                        success : function(result){
                            drawScrapCount3(result)
                        }, error : function(){
                            console.log("스크랩카운트 실패")
                        }
                    })

                    function drawScrapCount3(result){
                        const scrapCountArea = document.getElementById("scrap-count2");

                        scrapCountArea.innerHTML = result
                    }

                    $.ajax({
                        url : "scrapPageCount.me",
                        data : {
                            mNo : mNo,
                            scrapType : 1
                        },
                        success : function(result){
                            drawScrapCount1(result)
                        }, error : function(){
                            console.log("스크랩카운트 실패")
                        }
                    })

                    function drawScrapCount1(result){
                        const scrapCountArea = document.getElementById("scrap-count3");

                        scrapCountArea.innerHTML = result
                    }

                    $.ajax({
                        url : "scrapPageList.me",
                        data : {
                            mNo : mNo,
                            scrapType : 2
                        },
                        success : function(list){
                            drawScrapList2(list)
                        }, error : function(){
                            console.log("스크랩리스트 실패")
                        }
                    })

                    function drawScrapList2(list){
                        let detailUrl = 'detail.co?bid='
                        const scrapListArea = document.getElementById("scrap-item");

                        for (let i = 0; i < list.length; i++){
                            const scrap = list[i];
                            if(scrap){
                                scrapListArea.innerHTML += `<div class="profile-content-img" onclick="location.href='${contextPath}/`+ detailUrl +  scrap.mediaBoardId+`'">
                                    <img class="profile-community-img" src="${pageContext.request.contextPath}/` + scrap.filePath + scrap.changeName +  `">
                                    </div>` 
                            }
                        }
                    }
                }


                function navclicked(st, index,du){



                    $.ajax({
                        url : "scrapPageList.me",
                        data : {
                            mNo : mNo,
                            scrapType : st
                        },
                        success : function(list){
                            drawScrapList3(list)
                        }, error : function(){
                            console.log("스크랩리스트 실패")
                        }
                    })

                    function drawScrapList3(list){
                        let btn = document.querySelectorAll(".btn")
                        for(let i = 0; i < btn.length; i++){
                            btn[i].classList.remove("clicked")
                        }
                     
                        btn[index].classList.add("clicked")
                        let detailUrl = du;
                        const scrapListArea = document.getElementById("scrap-item");
                        scrapListArea.innerHTML = "";
                        for (let i = 0; i < list.length; i++){
                            const scrap = list[i];
                            if(scrap && detailUrl != 'detail.pr?productId='){
                            	
                                scrapListArea.innerHTML += `<div class="profile-content-img" onclick="location.href='${contextPath}/`+ detailUrl + scrap.mediaBoardId+`'">
                                    <img class="profile-community-img" src="${pageContext.request.contextPath}/` + scrap.filePath + scrap.changeName +  `">
                                    </div>` 
                            } else {
                                scrapListArea.innerHTML += `<div class="profile-content-img" onclick="location.href='${contextPath}/`+ detailUrl + scrap.mediaProductId+`'">
                                    <img class="profile-community-img" src="${pageContext.request.contextPath}/` + scrap.filePath + scrap.changeName +  `">
                                    </div>`
                            }
                        }
                    }
                }

                
    </script>
    
    <footer>
        <%@ include file="../common/footer.jsp" %>
    </footer>
</body>
</html>