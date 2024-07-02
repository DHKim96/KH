<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/community/communityPage.css">
</head>
<body>
<header> 
    <%@ include file="../common/headerCommunity.jsp" %>    
</header>
<div id="thumbnail-area">
    <img src="${contextPath}/${thumbnail.filePath}" alt="" class="thumbnail">
</div>
<div class="content-area" align="center">
    <div id="side-bar-area">
        <div class="side-bar">
            <div class="side-bar-scrap">
                <button class="side-bar-scrap-button scrap" onclick="bookmarkToggle(this, 0, '${b.boardId}', '${loginUser.membersNo}');">
                    <img class="side-bar-scrap-img" src="${contextPath}/resources/img/community/bookmark.png" alt="" >
                    <img class="side-bar-scrap-img hidden" src="${contextPath}/resources/img/community/bookmark-checked.png" alt="" >
                </button>        
                <span id="sc" class="side-bar-scrap-count scrap-count"></span>     
            </div>
            <hr class="hr3">
            <div class="side-bar-comment" onclick="$('#comment-detail-input-area').focus();">
                <button class="side-bar-comment-button">
                    <img class="side-bar-comment-img" src="${contextPath}/resources/img/community/speech-bubble.png" alt="">
                </button>        
                <span class="side-bar-comment-count">558</span>     
            </div>
        </div>
    </div>
    <div class="content">
        <input type="hidden" id="hidden-no" value="${b.boardId}" name="bid">
        <div class="bulletin-title" align="left">
            <p>${b.boardTitle}</p>
        </div>
        <div align="left" id="content-head">
            <div>
                <img class="user-profile-img" src="${pageContext.request.contextPath}/resources/img/community/communityPage/userProfile.png" alt="">
                <span id="user-name">${b.boardWriterName}</span>
            </div>
            <div>
                <span onclick="location.href='${contextPath}/updateForm.co?bid=${b.boardId}'">수정&nbsp;&#183;</span>
                <span onclick="location.href='${contextPath}/delete.co?bid=${b.boardId}'">삭제</span>
            </div>
        </div>
        <div id="house-information">
            <div id="house-information-head">
                <div class="cummunityPage-info">
                    <img class="cummuniyPage-info-img" src="${pageContext.request.contextPath}/resources/img/community/community-info-img1.png" alt="">
                    <c:choose>
                        <c:when test="${not empty b.filType}">
                            ${b.filType}
                        </c:when>
                        <c:otherwise>
                            -
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="hr1"></div>
                <div class="cummunityPage-info">
                    <img class="cummuniyPage-info-img" src="${pageContext.request.contextPath}/resources/img/community/community-info-img1.png" alt="">
                    <c:choose>
                        <c:when test="${not empty b.filArea}">
                            ${b.filArea}평
                        </c:when>
                        <c:otherwise>
                            -
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="hr1"></div>
                <div class="cummunityPage-info">
                    <img class="cummuniyPage-info-img" src="${pageContext.request.contextPath}/resources/img/community/community-info-img1.png" alt="">
                    <c:choose>
                        <c:when test="${not empty b.filField}">
                            ${b.filField}
                        </c:when>
                        <c:otherwise>
                            -
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="hr1"></div>
                <div class="cummunityPage-info">
                    <img class="cummuniyPage-info-img" src="${pageContext.request.contextPath}/resources/img/community/community-info-img1.png" alt="">
                    <c:choose>
                        <c:when test="${not empty b.filWorker}">
                            ${b.filWorker}
                        </c:when>
                        <c:otherwise>
                            -
                        </c:otherwise>
                    </c:choose>
                </div> 
            </div>
            <div class="hr2"></div>
            <div id="house-information-foot">
                <c:if test="${not empty b.filType}">
                    <div class="house-information-foot-info">
                        <div class="house-information-foot-info-title">공간</div>
                        <div>
                            ${b.filType}
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty b.filArea}">
                    <div class="house-information-foot-info">
                        <div class="house-information-foot-info-title">평수</div>
                        <div>
                            ${b.filArea}
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty b.filNum}">
                    <div class="house-information-foot-info">
                        <div class="house-information-foot-info-title">방개수</div>
                        <div>
                            ${b.filNum}
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty b.filDirection}">
                    <div class="house-information-foot-info">
                        <div class="house-information-foot-info-title">방향</div>
                        <div>
                            ${b.filDirection}
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty b.filPast}">
                    <div class="house-information-foot-info">
                        <div class="house-information-foot-info-title">준공연차</div>
                        <div>
                            ${b.filPast}
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty b.filLocal}">
                    <div class="house-information-foot-info">
                        <div class="house-information-foot-info-title">지역</div>
                        <div>
                            ${b.filLocal}
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty b.filFamily}">
                    <div class="house-information-foot-info">
                        <div class="house-information-foot-info-title">가족형태</div>
                        <div>
                            ${b.filFamily}
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty b.filPet}">
                    <div class="house-information-foot-info">
                        <div class="house-information-foot-info-title">반려동물</div>
                        <div>
                            ${b.filPet}
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty b.filFamMemCnt}">
                    <div class="house-information-foot-info">
                        <div class="house-information-foot-info-title">구성원수</div>
                        <div>
                            ${b.filFamMemCnt}
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty b.filField}">
                    <div class="house-information-foot-info">
                        <div class="house-information-foot-info-title">작업분야</div>
                        <div>
                            ${b.filField}
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty b.filWorker}">
                    <div class="house-information-foot-info">
                        <div class="house-information-foot-info-title">작업자</div>
                        <div>
                            ${b.filWorker}
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
        <div class="community-house-content" id="first-img">
            <!--집들이 게시글 내용에 들어갈 사진-->                  
            <!-- <div class="community-img-area">
                <img class="community-house-content-img" src="${pageContext.request.contextPath}/resources/img/community/communityPage/contentImg1.png" alt="">
                <button class="cummunity-scrap-button" onclick="bookmarkToggle(this, 1, mediaId, ${loginUser.membersNo})">
                    <img class="cummunity-scrap-img" src="${contextPath}/resources/img/community/communitybookmark.png" alt="">
                    <img class="cummunity-scrap-img hidden" src="${contextPath}/resources/img/community/communityPage/pm-bookmark-checked.png" alt="">
                </button>
            </div> -->
        </div>
        <div class="community-house-content">
            <p class="community-house-content-write" align="left">
                ${b.introduction}
            </p>
        </div>
        <div align="left">
            <p id="community-house-content-3cut">⚡ 3초 컷! 집들이 미리보기</p>
        </div>
        <div class="community-house-content" id="img-list">
            <!-- <div class="community-img-area">
                <img class="community-house-content-img" src="${pageContext.request.contextPath}/resources/img/community/communityPage/contentImg1.png" alt="">
                <button class="cummunity-scrap-button">
                    <img class="cummunity-scrap-img" src="${pageContext.request.contextPath}/resources/img/community/communitybookmark.png" alt="">
                </button>
                <div class="community-house-content-tag">
                    <button class="community-house-content-tag-button">
                        <span class="community-house-content-tag-plus">+</span>
                    </button>
                </div>
            </div> -->

            <!-- <div class="list-wrap" >
                <div id="back-button" class="wrap-button-container">
                    <img class="wrap-button" src="${pageContext.request.contextPath}/resources/img/community/backbutton.png" >
                </div>
                <div class="community-tag-info">
                    <div class="community-tag-info-list">
                        <div class="community-tag-info-product">
                            <img class="community-tag-info-product-img" src="${pageContext.request.contextPath}/resources/img/community/communityPage/tag1.png" alt="">
                        </div>
                    </div>
                    <div class="community-tag-info-list">
                        <div class="community-tag-info-product">
                            <img class="community-tag-info-product-img" src="${pageContext.request.contextPath}/resources/img/community/communityPage/tag1.png" alt="">
                        </div>
                    </div>
                    <div class="community-tag-info-list">
                        <div class="community-tag-info-product">
                            <img class="community-tag-info-product-img" src="${pageContext.request.contextPath}/resources/img/community/communityPage/tag1.png" alt="">
                        </div>
                    </div>
                    <div class="community-tag-info-list">
                        <div class="community-tag-info-product">
                            <img class="community-tag-info-product-img" src="${pageContext.request.contextPath}/resources/img/community/communityPage/tag1.png" alt="">
                        </div>
                    </div>
                    <div class="community-tag-info-list">
                        <div class="community-tag-info-product">
                            <img class="community-tag-info-product-img" src="${pageContext.request.contextPath}/resources/img/community/communityPage/tag1.png" alt="">
                        </div>
                    </div>
                </div>
            </div> -->
        </div>
        <div class="community-house-content">
            <p class="community-house-content-write" align="left">
                ${b.description}
            </p>
        </div>
        <div class="community-img-area">
            <img class="community-house-content-img" src="${pageContext.request.contextPath}/resources/img/community/communityPage/copyright.png" alt="">
            <button class="cummunity-scrap-button">
                <img class="cummunity-scrap-img" src="${pageContext.request.contextPath}/resources/img/community/communitybookmark.png" alt="">
            </button>
        </div>


        <div class="post-information">
            <span>${b.boardCreateTime}&nbsp;</span>
            <span>&#183; 스크랩&nbsp;</span>
            <span class="scrap-count">18</span>
            <span>&nbsp;&#183; 조회 ${b.boardViews} </span>
        </div>


        <div align="left" id="last-user-profile">
            <div>
                <img class="user-profile-img" src="${pageContext.request.contextPath}/resources/img/community/communityPage/userProfile.png" alt="">
                <span id="user-name">${b.boardWriterName}</span>
            </div>
        </div>

        <div id="comment-area" align="left">
            <div class="comment-count">
                <span id="comment">댓글&nbsp;</span>
                <span id="count">558</span>
            </div>
            <div class="comment-write" align="left">
                <div id="comment-writer-profile">
                    <img class="comment-writer-profile-img" src="${pageContext.request.contextPath}/resources/img/community/basicprofile.jpg" alt="">
                </div>
                <div id="comment-detail-area">
                    <div class="comment-detail">
                        <div id="comment-detail-input">
                        <input type="text" id="comment-detail-input-area" name="" cols="80" rows="1.5" style="resize: none; border: none;" placeholder="칭찬과 격려의 댓글은 작성자에게 큰 힘이 됩니다:)">
                        </div>
                        <div class="comment-input">
                            <button class="comment-input-button" onclick="insertReply('${loginUser.membersNo}');">
                                입력
                            </button>
                        </div>  
                    </div>
                </div>
            </div>
            <div class="comment-and-answer">
                <div class="comment-area"></div>
            </div>
            <!-- <div class="comment-page">
                <button id="back-page-button">
                    <img id="back-page-img" src="${pageContext.request.contextPath}/resources/img/community/backbutton.png" alt="">
                </button>
                <button class="page-button">1</button>
                <button class="page-button">2</button>
                <button id="next-page-button">
                    <img id="next-page-img" src="${pageContext.request.contextPath}/resources/img/community/nextbutton.png" alt="">
                </button>
            </div> -->
        </div>
    </div>
    <script>
        let selectReplyList = null;
        $(function() {
            selectReplyList = function() {
                getItems("listReply.co", { bid: "${b.boardId}" }, function (result) {
                    getReply(result, "${contextPath}", "${loginUser.membersNo}");
                    for (let item of result) {
                        getItems("profile.co", { mNo: item.replyMembersNo }, function (result) {
                            getProfile(result, "${contextPath}", "#comment-" + item.replyId);
                        })
                    }
                });
            };

            selectReplyList();

            getItems("listMedia.co", {bid: "${b.boardId}"}, function(result) {
                getPhoto(result, "${contextPath}", "${loginUser.membersNo}");
            });

            getItems("profile.co", {mNo: "${b.membersNo}"}, function(result) {
                getProfile(result, "${contextPath}", ".user-profile-img");
            })

            getItems("profile.co", {mNo: "${loginUser.membersNo}"}, function(result) {
                getProfile(result, "${contextPath}", "#comment-writer-profile > img");
            })

            getItems("boardScrap.co", {bid: "${b.boardId}"}, function(result) {
                getBoardScrap(result, "${loginUser.membersNo}");
            })

            getItems("mediaScrap.co", { bid: "${b.boardId}" }, function (result) {
                getMediaScrap(result, "${loginUser.membersNo}");
            })
        })

        function getItems(url, data, callback) {
            $.ajax({
                url: url,
                data: data,
                success: function(result) {
                    callback(result);
                },
                error: function() {
                    console.log("실패");
                }
            });
        }

        function getPhoto(result, contextPath, memNo) {
            const thumbnail = document.querySelector(".thumbnail");
            const first = document.querySelector("#first-img");
            const photos = document.querySelector("#img-list");
            let i = 0;
            for(let item of result) {
                let str = `
                    <div class="community-img-area">
                        <input type="hidden" value="` + item.mediaId + `">
                        <img class="community-house-content-img" src="` + contextPath + "/" + item.filePath + item.changeName + `" alt="">
                        <button class="cummunity-scrap-button scrap" onclick = "bookmarkToggle(this, 1, ` + item.mediaId + `, ` + memNo + `);">
                            <img class="cummunity-scrap-img" src="` + contextPath + `/resources/img/community/communitybookmark.png" alt="" >
                            <img class="cummunity-scrap-img hidden" src="` + contextPath + `/resources/img/community/communitybookmark-checked.png" alt="">
                        </button>
                    </div>
                    `;
                if(i === 0) {
                    $(thumbnail).attr({src: contextPath + "/" + item.filePath + item.changeName});
                } else if(i === 1) {
                    first.innerHTML += str;
                } else {
                    photos.innerHTML += str;
                }
                i++;
            }
        }

        function getReply(result, contextPath, mNo){
            $("#count").html(result.length);
            $(".side-bar-comment-count").html(result.length);
            const commentArea = document.querySelector(".comment-area");
            commentArea.innerHTML = "";
            for(let item of result) {
                commentArea.innerHTML += `
                    <div id="commentid` + item.replyId + `">
                        <div class="comment-user" align="left">
                            <img class="comment-user-profile" id="comment-` + item.replyId + `" src="` + contextPath + `/resources/img/community/communityPage/userProfile2.png" alt="">
                        </div>
                        <div class="comment-content">
                            <div class="comment-user-name">` + item.replyWriter + `</div>
                            <div class="Comments">` + item.replyContent + `</div>
                            <div class="comment-date" id="commentFunc-` + item.replyId + `">
                                    <span>` + item.replyCreateDate + `&nbsp;</span>
                            </div>
                        </div>
                    </div>
                    <br>
                `;
                if(mNo !== null && mNo === item.replyMembersNo) {
                    $("#commentFunc-" + item.replyId).append("<span onclick='deleteReply(" + item.replyId + ");'>삭제</span>")
                }
            }
        }

        function insertReply(membersNo) {
            const replyContent = document.querySelector("#comment-detail-input-area").value;
            const boardId = document.querySelector("#hidden-no").value;
            console.log(boardId + " " + membersNo);
            $.ajax({
                url: "insertReply.co",
                type: "POST",
                data: {
                    replyContent: replyContent,
                    boardId: boardId,
                    membersNo: membersNo
                },
                success: function (result) {
                    selectReplyList();
                },
                fail: function () {
                    console.log("실패")
                }
            })
        }

        function deleteReply(id) {
            $.ajax({
                url: "deleteReply.co",
                data: {replyId: id},
                success: function(result) {
                    if(result === 'Y') {
                        $(".comment-area").remove("#commentid" + id);
                    } else {
                        console.log("삭제 실패");
                    }
                    selectReplyList();
                },
                fail: function() {
                    console.log("실패")
                }
            })
        }

        function getProfile(result, contextPath, path) {
            if(result == null) {
                $(path).attr("src", contextPath + `/resources/img/common/user.png`);
            } else {
                $(path).attr({ src: contextPath + "/" + result.filePath});
            }
        }

        function getBoardScrap(result, memNo) {
            const scrap = document.querySelector(".side-bar-scrap-button");
            $(".scrap-count").html(result.length);
            $()
            for(let item of result) {
                if(item.scrapMembersNo == memNo) {
                    scrap.children[0].classList.toggle("hidden");
                    scrap.children[1].classList.toggle("hidden");
                    break;
                }
            }
        }

        function getMediaScrap(result, memNo) {
            const scrap = document.getElementsByClassName("community-img-area");
            for(let item of result) {
                for(let pic of scrap) {
                    if($(pic).children().eq(0).val() == item.scrapMediaId && item.scrapMembersNo == memNo) {
                        $(pic).children().eq(2).children().eq(0).toggleClass("hidden");
                        $(pic).children().eq(2).children().eq(1).toggleClass("hidden");
                        break;
                    }
                }
            }
        }

        
        
        function bookmarkToggle(_this, type, id, mNo) {
            console.log("안녕");
            if(mNo === "" || mNo === null) return;

            const bookmark = _this.children;
            bookmark[0].classList.toggle("hidden");
            bookmark[1].classList.toggle("hidden");

            if(type === 0) {
                $.ajax({
                    type: "POST",
                    url: "scrap.co",
                    data: {
                        membersNo: mNo,
                        boardId: id,
                    },
                    success: function(result) {
                        console.log(result.length)
                        document.getElementById("sc").innerHTML = result.length; 
                    },
                    error: function() {
                        console.log("실패");
                    }
                });
            } else {
                $.ajax({
                    type: "POST",
                    url: "scrap.co",
                    data: {
                        membersNo: mNo,
                        mediaId: id,
                    },
                    success: function(result) {
                        document.getElementById("sc").innerHTML = result.length;
                    },
                    error: function() {
                        console.log("실패");
                    }
                });
            }
        }
        
    </script>
</div>

<br><br><br><br><br><br><br><br><br>
<footer>
    <%@ include file="../common/footer.jsp" %> 
</footer>

</body>
</html>