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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/community/communityMain.css">
</head>
<body>
    <header> 
        <%@ include file="../common/headerCommunity.jsp" %>    
    </header>
    <div align="center">
      <div class="content">
        <div id="sort" align="left">
            <!-- <div class="dropdown">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                    정렬
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">최신순</a>
                    <a class="dropdown-item" href="#">최근 인기순</a>
                    <a class="dropdown-item" href="#">역대 인기순</a>
                    <a class="dropdown-item" href="#">과거순</a>
                </div>
            </div> -->
            <!-- <div class="dropdown">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                    주거형태
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Link 1</a>
                    <a class="dropdown-item" href="#">Link 2</a>
                    <a class="dropdown-item" href="#">Link 3</a>
                </div>
            </div>
            <div class="dropdown">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                    평수
                </button>
                <div class="dropdown-menu">
                    <form class="area-form">
                        <span>최소&nbsp;&nbsp;</span>
                        <input type="number" placeholder="0" name="min" min="0" max="70">
                        <span>최대&nbsp;&nbsp;</span>
                        <input type="number" placeholder="70" name="max" min="0" max="70">
                    </form>
                </div>
            </div>
            <div class="dropdown">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                    예산
                </button>
                <div class="dropdown-menu">
                    <form class="area-form">
                        <span>최소&nbsp;&nbsp;</span>
                        <input type="number" placeholder="0(만원)" name="min" min="0" max="4000">
                        <span>최대&nbsp;&nbsp;</span>
                        <input type="number" placeholder="4000(만원)" name="max" min="0" max="4000">
                    </form>
                </div>
            </div>
            <div class="dropdown">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                    가족형태
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Link 1</a>
                    <a class="dropdown-item" href="#">Link 2</a>
                    <a class="dropdown-item" href="#">Link 3</a>
                </div>
            </div>
            <div class="dropdown">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                    스타일
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Link 1</a>
                    <a class="dropdown-item" href="#">Link 2</a>
                    <a class="dropdown-item" href="#">Link 3</a>
                </div>
            </div>
            <div class="dropdown">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                    컬러
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Link 1</a>
                    <a class="dropdown-item" href="#">Link 2</a>
                    <a class="dropdown-item" href="#">Link 3</a>
                </div>
            </div>
            <div class="dropdown">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                    세부공사
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Link 1</a>
                    <a class="dropdown-item" href="#">Link 2</a>
                    <a class="dropdown-item" href="#">Link 3</a>
                </div>
            </div>
            <div class="dropdown">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                    분야
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Link 1</a>
                    <a class="dropdown-item" href="#">Link 2</a>
                    <a class="dropdown-item" href="#">Link 3</a>
                </div>
            </div>
            <div class="dropdown">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                    작업자
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Link 1</a>
                    <a class="dropdown-item" href="#">Link 2</a>
                    <a class="dropdown-item" href="#">Link 3</a>
                </div>
            </div> -->
        </div>
        <div id="content-page"> 
            <c:forEach var="b" items="${bList}" varStatus="st">
                <c:set var="m" value="${mList.get(st.index)}"/>
                <div class="page" onclick="location.href='${contextPath}/detail.co?bid=${b.boardId}'">
                    <img class="content-img" src="${contextPath}/${b.boardThumbnail}" alt="" >
                    <div>
                        <div class="page-text">
                            <div class="page-text-title">${b.boardTitle}</div>
                            <div class="page-text-name">
                                <c:choose>
                                    <c:when test="${empty m}">
                                        <img class="page-text-img" src="${contextPath}/resources/img/common/user.png" alt="">
                                    </c:when>
                                    <c:otherwise>
                                        <img class="page-text-img" src="${contextPath}/${m.filePath}" alt="">
                                    </c:otherwise>
                                </c:choose>
                                
                                <span>${b.boardWriter}</span>
                            </div>
                            <div class="page-text-scrap-count">
                                <span>스크랩 ${b.scrapCount}</span>
                                <span>&#183; 조회 ${b.boardViews}</span>
                            </div>
                        </div>  
                    </div>
                </div>
            </c:forEach>
        </div>
      </div>
    </div>
    <footer>
        <%@ include file="../common/footer.jsp" %> 
    </footer>
</body>
</html>