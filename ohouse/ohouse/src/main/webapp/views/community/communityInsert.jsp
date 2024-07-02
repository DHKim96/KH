<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/community/communityInsert.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/main.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/common/header.css">
    <script src="${contextPath}/resources/js/headerInit.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <header id="insert-header" align="center"> 
        <div align="center">
            <c:if test="${not empty alertMsg}">
                <script>
                    alert("${alertMsg}");
                </script>
                <c:remove var="alertMsg" />
            </c:if>
            <div class="sticky-container" style="height: 80px;">
                <div class="header-logo" onclick="location.href='${pageContext.request.contextPath}'">
                    오늘의집
                </div>
                <div class="header-main">
                    <a href="${contextPath}"><span>쇼핑</span></a>
                    <a href="${contextPath}/list.co"><span>커뮤니티</span></a>
                </div>
                <div class="header-menu">
                    <c:choose>
                        <c:when test="${empty loginUser}">
                            <!-- 로그인X -->
                            <div class="header-others">
                                <a href="${pageContext.request.contextPath}/loginForm.me">로그인</a>|
                                <a href="${pageContext.request.contextPath}/enrollForm.me">회원가입</a>
                                <a href="${contextPath}/loginForm.me" style="background-color: #35C5F0; color: white; border-radius: 5px;">작성하기</a>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <!-- 로그인O -->
                            <div class="header-others">
                                <img src="${pageContext.request.contextPath}/resources/img/common/pm-bookmark.png" alt="" onclick="">
                                <!-- <img src="${pageContext.request.contextPath}/resources/img/common/shopping-cart.png" alt="" onclick=""> -->
                                <img src="${contextPath}/resources/img/common/logout.png" alt=""
                                    onclick="location.href='${contextPath}/logout.me';">
                                <img src="${pageContext.request.contextPath}/resources/img/common/user.png" alt="" 
                                    onclick="location.href='${contextPath}/profile.me';" id="header-profile">
                                <a onclick="document.getElementById('submit-btn').click();" style="background-color: #35C5F0; color: white; border-radius: 5px;">작성하기</a>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div style="border: 1px solid #f7f9fa; min-width: 1136px;"></div>
        </div>   
    </header>
    <form action="${contextPath}/insert.co" method="POST" enctype="multipart/form-data">
        <div align="center">
            <div class="cummunity-insert-area">
                <div class="required-information-area-content">
                    <div class="required-information-area">
                        <div class="pencil-img-area">
                            <img class="pencil-img" src="${pageContext.request.contextPath}/resources/img/community/pencil.png" alt="">
                        </div>
                        <div class="required-information-input-area">
                            <span class="required-information-input">필수 정보 입력</span>
                        </div>
                        <div class="required-information-input-text-area">
                            <span class="required-information-input-text">공간을 이해하는데 필요한 정보이니 최대한 꼼꼼하게 입력해주세요.</span>
                        </div>
                    </div>
                </div>
                <div class="cummunity-insert-text-input-area">
                    <div class="housing-type-area">
                        <div class="housing-type-text text-width">
                            <div class="type-text-title">주거형태</div>
                            <span class="type-text-star">*</span>
                        </div>
                        <div class="housing-type-coice">
                            <select name="type" id="housing-type-coice-select">
                                <option value="null" readonly selected>선택해주세요.</option>
                                <option value="본인 방">본인 방</option>
                                <option value="원룸">원룸</option>
                                <option value="오피스텔">오피스텔</option>
                                <option value="아파트">아파트</option>
                            </select>
                        </div>
                    </div>
                    <div class="house-size-area">
                        <div class="house-size-text text-width">
                            <div class="type-text-title">평수</div>
                            <span class="type-text-star">*</span>
                        </div>
                        <div class="family-member-input-area">
                            <input type="number" name="area">
                            <span>평</span>
                        </div>
                    </div>
                    <div class="room-number-area">
                        <div class="room-number-text text-width">
                            <div class="room-number-title">방 개수</div>
                        </div>
                        <div class="room-number-coice">
                            <select name="num" id="room-number-coice-select">
                                <option value="null" readonly selected>선택해주세요.</option>
                                <option value="1">1개</option>
                                <option value="1.5">1.5개</option>
                                <option value="2">2개</option>
                            </select>
                        </div>
                    </div>
                    <div class="direction-area">
                        <div class="direction-text text-width">
                            <div class="direction-title">방향</div>
                        </div>
                        <div class="direction-coice">
                            <select name="direction" id="direction-coice-select">
                                <option value="null" readonly selected>선택해주세요.</option>
                                <option value="남향">남향</option>
                                <option value="서향">서향</option>
                                <option value="동향">동향</option>
                            </select>
                        </div>
                    </div>
                    <div class="completion-area">
                        <div class="completion-text text-width">
                            <div class="completion-title">준공연차</div>
                        </div>
                        <div class="completion-coice">
                            <select name="past" id="completion-coice-select">
                                <option value="null" readonly selected>선택해주세요.</option>
                                <option value="입주예정">입주예정</option>
                                <option value="~2년 미만">~2년 미만</option>
                                <option value="2~4년">2~4년</option>
                            </select>
                        </div>
                    </div>
                    <div class="location-area">
                        <div class="location-text text-width">
                            <div class="location-title">지역</div>
                        </div>
                        <div class="location-coice">
                            <select name="local" id="location-coice-select">
                                <option value="null" readonly selected>선택해주세요.</option>
                                <option value="서울특별시">서울특별시</option>
                                <option value="부산광역시">부산광역시</option>
                                <option value="기타">인천광역시</option>
                            </select>
                        </div>
                    </div>
                    <div class="family-form-area">
                        <div class="family-form-text text-width">
                            <div class="family-form-title">가족형태</div>
                            <span class="type-text-star">*</span>
                        </div>
                        <div class="family-form-coice">
                            <select name="family" id="family-form-coice-select">
                                <option value="null" readonly selected>선택해주세요.</option>
                                <option value="싱글라이프">싱글라이프</option>
                                <option value="신혼/부부가 사는 집">신혼/부부가 사는집</option>
                                <option value="자녀가 있는 집">자녀가 있는 집</option>
                            </select>
                        </div>
                    </div>
                    <div class="animal-area">
                        <div class="animal-text text-width">
                            <div class="animal-title">반려동물 유무</div>
                        </div>
                        <div class="animal-coice">
                            <select name="pet" id="animal-coice-select">
                                <option value="null" readonly selected>선택해주세요.</option>
                                <option value="없어요.">없어요.</option>
                                <option value="강아지">강아지</option>
                                <option value="고양이">고양이</option>
                                <option value="어류">어류</option>
                            </select>
                        </div>
                    </div>
                    <div class="family-member-area">
                        <div class="family-member-text text-width">
                            <div class="family-member-title">가족 구성원수</div>
                        </div>
                        <div class="family-member-input-area">
                            <input type="number" name="familyMemCnt">
                            <span>명</span>
                        </div>
                    </div>
                    <div class="work-field-area">
                        <div class="work-field-text text-width">
                            <div class="work-field-title">작업분야</div>
                            <span class="type-text-star">*</span>
                        </div>
                        <div class="work-field-coice">
                            <select name="field" id="work-field-coice-select">
                                <option value="null" readonly selected>선택해주세요.</option>
                                <option value="홈스타일링">홈스타일링</option>
                                <option value="리모델링">리모델링</option>
                                <option value="부분시공">부분시공</option>
                            </select>
                        </div>
                    </div>
                    <div class="worker-area">
                        <div class="worker-text text-width">
                            <div class="worker-title">작업자</div>
                            <span class="worker-star">*</span>
                        </div>
                        <div class="worker-choice-area">
                            <input type="radio" id="self" name="worker" value="셀프/DIY">
                            <label for="self">셀프&#183;DIY</label>
                            <input type="radio" id="half-self" name="worker" value="반셀프">
                            <label for="half-self">반셀프</label>                         
                            <input type="radio" id="expert" name="worker" value="전문가">
                            <label for="expert">전문가</label>
                        </div>
                    </div>
                    <div class="detailed-construction-area">
                        <div class="detailed-construction-text text-width">
                            <div class="detailed-construction-title">세부 시공 범위</div>
                        </div>
                        <div class="detailed-construction-coice">
                            <select name="range" id="detailed-construction-coice-select">
                                <option value="null" readonly selected>선택해주세요.</option>
                                <option value="폴딩도어">폴딩도어</option>
                                <option value="주방 리모델링">주방 리모델링</option>
                                <option value="욕실 리모델링">욕실 리모델링</option>
                            </select>
                        </div>
                    </div>
                    <div class="period-area">
                        <div class="period-text text-width">
                            <div class="period-title">기간</div>
                        </div>
                        <div class="family-member-input-area">
                            <input type="number" name="period">
                            <span>주</span>
                        </div>
                    </div>
                    <div class="budget-area">
                        <div class="budget-text text-width">
                            <div class="budget-title">예산</div>
                        </div>
                        <div class="budget-input-area">
                            <input type="number" name="constructionPrice">
                            <span>만원</span>
                        </div>
                    </div>
                    <div class="link-area">
                        <div class="link-text text-width">
                            <div class="link-title">링크</div>
                        </div>
                        <div class="link-input-area">
                            <input type="text" placeholder="URL 주소를 입력해주세요." name="url">
                        </div>
                    </div>
                    <div class="copyright-area">
                        <div class="copyright-text text-width">
                            <div class="copyright-title">저작권 표기(c)</div>
                        </div>
                        <div class="copyright-input-area">
                            <input type="text" placeholder="사진 저작자를 입력해주세요." name="copyright">
                        </div>
                    </div>
                </div>
            </div>
            <div class="img-area" id="file1" onclick="imgChange('cover-img-hidden');">
                <!--사진이 없는 초기 화면-->
                <h5>커버사진 추가하기 버튼으로</h5>
                <h5>커버사진을 업로드해주세요.</h5>
                <button type="button" class="btn btn-secondary btn-lg">
                    커버사진 추가하기
                </button>
            </div>
            <input type="file" value="커버사진 추가하기" onchange="showImg(this, '#file1', '커버사진');" id="cover-img-hidden" name="file1" class="hidden">
            
            <div id="content-title">
                <input id="content-title-input" type="text" name="title" placeholder="제목을 입력하세요.">
            </div>
            <div id="content-area">
                <!--대표 사진-->
                <div class="img-area" id="file2" onclick="imgChange('first-img-hidden');">
                    <!--사진이 없는 초기 화면-->
                    <h5>대표사진 추가하기 버튼으로</h5>
                    <h5>대표사진을 업로드해주세요.</h5>
                    <button type="button" class="btn btn-secondary btn-lg">
                        대표사진 추가하기
                    </button>
                </div>
                <input type="file" value="대표사진 추가하기" onchange="showImg(this, '#file2', '대표사진');" id="first-img-hidden" name="file2" class="hidden">
                <!--대표 글-->
                <textarea name="introduction" id="textarea" align="left" placeholder="내용을 입력하세요."></textarea>
                <!--3초 컷! 집들이 미리보기-->
                <p id="community-house-content-3cut">
                    ⚡ 3초 컷! 집들이 미리보기
                    <button type="button" class="btn btn-light btn-lg" onclick="addImgArea();">사진추가</button>
                    <button type="button" class="btn btn-danger btn-lg" onclick="deleteImgArea();">사진삭제</button>
                </p>
                <div id="img-wrapper">
                    <div class="img-area" onclick="imgChange('id3');" id="file3">
                        <!--사진이 없는 초기 화면-->
                        <h5>사진 추가하기 버튼으로</h5>
                        <h5>사진을 업로드해주세요.</h5>
                        <button type="button" class="btn btn-secondary btn-lg">
                            사진 추가하기
                        </button>
                    </div>
                    <input type="file" value="대표사진 추가하기" name="file3" class="hidden" id="id3" onchange="showImg(this, '#file3', '사진');">
                    <!-- 태그 -->
                    <!--
                    <div class="tag-flex" align="left">
                        <c:forEach var="i" begin="1" end="6">
                            <button type="button" class="btn btn-default tag-product" data-toggle="modal" data-target="#id3-modal${i}" id="id3-tag${i}" name="tag3"></button>
                            <div id="id3-modal${i}" class="modal fade" role="dialog">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title"></h4>
                                        </div>
                                        <div class="modal-body">
                                            <input type="text" onkeyup="productSearch(this.value, 3, '${i}', '${contextPath}');">
                                            <button type="button" class="btn btn-default btn-sm">검색</button>
                                            <div id="id3${i}"></div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    -->
                </div>
                <!--본문 내용-->
                <textarea name="description" id="textarea" align="left" placeholder="내용을 입력하세요."></textarea>
            </div>
        </div>
        <button type="submit" id="submit-btn" class="hidden">제출</button>
    </form>
    <script>
        let idx = 4;

        $(function () {
            init("${loginUser.membersNo}", function (result) {
                if (result == null) {
                    $("#header-profile").attr("src", `${contextPath}/resources/img/common/user.png`);
                } else {
                    $("#header-profile").attr("src", `${contextPath}/` + result.filePath);
                }
            })
        })

        function imgChange(id) {
            const imgInput = document.getElementById(id);
            imgInput.click();
        }

        function showImg(inputFile, id, msg) {
            if (inputFile.files.length == 1) {
                const reader = new FileReader();
                reader.readAsDataURL(inputFile.files[0]);
                reader.onload = function (ev) {
                    $(id).html(`<img src=` + ev.target.result + `>`);
                    $(id + ">img").css("height", "90%");
                }
            } else {
                $(id).html(
                    '<h5>' + msg + ' 추가하기 버튼으로</h5>' +
                    '<h5>' + msg + '을 업로드해주세요.</h5>' +
                    '<button type="button" class="btn btn-secondary btn-lg">' + msg + ' 추가하기</button>'
                );
            }
        }
        
        // function inputTag(idNum, contextPath) {
        //     const tagFlex = document.createElement('div');
        //     const imgWapper = document.getElementById('img-wrapper');

        //     tagFlex.setAttribute("class", "tag-flex");
        //     tagFlex.setAttribute("align", "left");

        //     for(let i = 1; i <= 6; i++) {
        //         let btn = `<button type="button" class="btn btn-default tag-product" data-toggle="modal" 
        //                             data-target="#id` + idNum + `-modal` + i + `" id="id` + idNum + `-tag` + i + `" name="tag`+ idNum +`"></button>`;
        //         let modal = `<div id="id` + idNum + `-modal` + i + `" class="modal fade" role="dialog">
        //                         <div class="modal-dialog">
        //                             <div class="modal-content">
        //                                 <div class="modal-header">
        //                                     <button type="button" class="close" data-dismiss="modal">&times;</button>
        //                                     <h4 class="modal-title"></h4>
        //                                 </div>
        //                                 <div class="modal-body">
        //                                     <input type="text" onkeyup="productSearch(this.value, ` + idNum + `, ` + i + `, '` + contextPath + `');">
        //                                     <button type="button" class="btn btn-default btn-sm">검색</button>
        //                                     <div id="id` + idNum + `` + i + `"></div>
        //                                 </div>
        //                                 <div class="modal-footer">
        //                                     <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        //                                 </div>
        //                             </div>
        //                         </div>
        //                     </div>`;
        //         tagFlex.innerHTML += btn;
        //         tagFlex.innerHTML += modal;
        //     }

        //     imgWapper.appendChild(tagFlex);
        // }

        function productSearch(key, idNum, order, contextPath) {
            $.ajax({
                url: "selectProduct.co",
                data: {key: key},
                success: function(result) {
                    selectList(result, idNum, order, contextPath);
                },
                error: function() {
                    console.log("검색 실패");
                }
            });
        }

        function selectList(result, idNum, order, contextPath) {
            const tag = document.getElementById(('id' + idNum) + order);
            const btn = document.getElementById('id' + idNum + '-tag' + order);

            if(result.length === 0) {
                // tag.innerHTML = "<div>검색 결과가 없습니다.</div>";
            } else {
                // tag.innerHTML = "";

                for(let ele of result) {
                    const div = document.createElement('div');
                    div.innerHTML += ele.productName;
                    div.innerHTML += `<input type="hidden" value="` + ele.productThumbnail + `">`;
                    div.innerHTML += `<input type="hidden" value="` + ele.productId + `">`;

                    div.addEventListener("click", function(ev) {
                        const now = ev.target.children;
                        btn.innerHTML = `<img src="` + contextPath + `/` + now[0].value + `">`;
                        btn.innerHTML += `<input type="hidden" value="` + now[1].value + `">`
                    });

                    // tag.appendChild(div);
                }
            }
        }
        
        const DEFAULT_HEIGHT = 30; // textarea 기본 height
        const $textarea = document.querySelector('#textarea');

        $textarea.oninput = (event) => {
            const $target = event.target;

            $target.style.height = 0;
            $target.style.height = DEFAULT_HEIGHT + $target.scrollHeight + 'px';
        };


        function addImgArea() {
            const imgWapper = document.querySelector("#img-wrapper")
            const wrapper = document.createElement('div');
            const input = document.createElement('input');
            const tag = document.createElement('div');

            if(idx === 7) {
                alert("대표사진을 제외하고 4장까지만 첨부 가능합니다.");
                return;
            }
            
            wrapper.setAttribute("id", "file" + idx);
            wrapper.setAttribute("class", "img-area");

            input.setAttribute("type", "file");
            input.setAttribute("id", "id" + idx);
            input.setAttribute("class", "hidden");
            input.setAttribute("name", "file" + idx);

            wrapper.innerHTML += `
                <h5>사진 추가하기 버튼으로</h5>
                <h5>사진을 업로드해주세요.</h5>
                <button type="button" class="btn btn-secondary btn-lg">
                사진 추가하기
                </button>
            `;

            imgWapper.append(wrapper);
            imgWapper.append(input);

            wrapper.addEventListener("click", (ev) => {
                console.log("id" + ev.target.id[4]);
                imgChange("id" + ev.target.id[4]);
            });
            input.addEventListener("change", (ev) => {
                showImg(input, "#file" + ev.target.id[2], "사진")
            });

            // inputTag(idx, contextPath)

            idx++;
        }

        function deleteImgArea() {
            if(idx === 3) {
                alert("삭제할 사진이 없습니다.");
                return;
            }

            idx--;
            const wrapper = document.getElementById("file" + idx);
            const input = document.getElementById("id" + idx);
            // const tag = document.querySelector(".tag-flex:nth-last-child(1)");

            wrapper.remove();
            input.remove();
            // tag.remove();
        }
        </script>
    <footer>
        <%@ include file="../common/footer.jsp" %> 
    </footer>
</body>
</html>