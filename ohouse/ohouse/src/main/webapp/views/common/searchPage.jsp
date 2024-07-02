<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <% String contextPath=request.getContextPath(); %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html lang="ko">

            <head>
                <meta charset="UTF-8">
                <title>Insert title here</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
                <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
                <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/searchPage.css">
            </head>

            <body>
                <header>
                    <%@ include file="./header.jsp" %>
                </header>
                <article id="search-container">
                    <c:choose>
                        <c:when test="${ products.size() == 0 && boards.size() == 0}">
                            <section class="search-content-empty">
                                <div>
                                    <img src="${pageContext.request.contextPath}/resources/img/common/emptyCat.png">
                                    <p>앗 찾으시는 결과가 없네요.</p>
                                </div>
                            </section>
                        </c:when>
                        <c:otherwise>
                            <c:if test="${ products.size() != 0}">
                                <!-- 상품 결과 검색 존재 시 상품 섹션 노출 -->
                                <section class="search-content">
                                    <header class="search-content-header">
                                        <h1 class="search-title">
                                            쇼핑
                                            <span class="count">${products.size()}</span>
                                        </h1>
                                        <a class="search-add" href="${contextPath}/list.pr?cpage=1">더보기</a>
                                    </header>
                                    <c:forEach var="p" items="${products}">
                                        <div class="pm-sale pm-content" id="pm-deal-contents">
                                            <div class="pm-sale-content">
                                                <div class="pm-sale-img">
                                                    <img class="img-hover" src="${p.productThumbnail}" width="260px" onclick='location.href="${contextPath}/detail.pr?productId=${p.productId}"'>
                                                    <button type="button" class="button-scrap">
                                                        <img src="${pageContext.request.contextPath}/resources/img/product/pm-bookmark.png"
                                                            width="40px" onclick="changeBookmark(this)">
                                                    </button>
                                                </div>
                                                <div class="pm-sale-text">
                                                    <div class="pm-company">
                                                        ${p.companyName}
                                                    </div>
                                                    <div class="pm-title">
                                                        ${p.productName}
                                                    </div>
                                                    <div class="pm-price">
                                                        <c:if test="${p.sale != 0}">
                                                            <span class="pm-color">${p.sale}%</span>
                                                        </c:if>
                                                        <span>
                                                            <fmt:formatNumber value="${p.productPrice}" />
                                                        </span>
                                                    </div>
                                                    <div class="pm-review">
                                                        <img src="${pageContext.request.contextPath}/resources/img/product/star.png"
                                                            width="15px">
                                                        <span class="pm-score">${p.ratingAvg}</span>
                                                        <span class="pm-gray">리뷰</span>
                                                        <span class="pm-gray">${p.reviewCount}</span>
                                                    </div>
                                                </div>
                                            </div>
                                    </c:forEach>
                                </section>
                            </c:if>
                            <c:if test="${ boards.size() != 0}">
                                <!-- 집들이 컨텐츠 섹션 -->
                                <section class="search-content" id="search-content-project">
                                    <header class="search-content-header">
                                        <h1 class="search-title">
                                            집들이 콘텐츠
                                            <span class="count">${boards.size()}</span>
                                        </h1>
                                        <a class="search-add" href="${contextPath}/list.co">더보기</a>
                                    </header>
                                    <div class="row">
                                        <c:forEach var="b" items="${boards}">
                                            <c:set var="m" value="${mList.get(st.index)}" />
                                            <div class="search-project-content" onclick='location.href="${contextPath}/detail.co?bid=${b.boardId}"'>
                                                <article class="search-project-item">
                                                    <div class="search-project-item-img-wrap">
                                                        <div class="search-project-item-img">
                                                            <img class="img-hover" src="${b.boardThumbnail}">
                                                            <button type="button" class="button-scrap">
                                                                <img src="${pageContext.request.contextPath}/resources/img/product/pm-bookmark.png"
                                                                    width="40px" onclick="changeBookmark(this)">
                                                            </button>
                                                        </div>
                                                    </div>
                                                    <div class="search-project-item-info">
                                                        <p class="search-project-info-title">
                                                            <span style="font-size: 17px;">${b.boardTitle}</span>
                                                        </p>
                                                        <div class="search-project-item-info-user">
                                                            <img src="${contextPath}/${m.filePath}">
                                                            <span
                                                                class="search-project-item-info-user-nickname">${b.boardWriter}</span>
                                                            <div class="search-project-item-info-status">스크랩
                                                                ${b.scrapCount}
                                                                &#183; 조회 ${b.boardViews}
                                                            </div>
                                                        </div>
                                                    </div>
                                                </article>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </section>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </article>
                <script>
                    // product-bookmark-img 클릭 시 이미지 변경
                    // pm-bookmark.png -> pm-bookmark-checked.png 또는
                    // pm-bookmark-checked.png -> pm-bookmark.png
                    function changeBookmark(_this){
                        const contextPath = "${pageContext.request.contextPath}";
                        const src = _this.src;
                        const bookmarkImage = contextPath + "/resources/img/product/pm-bookmark.png";
                        const checkedBookmarkImage = contextPath + "/resources/img/product/pm-bookmark-checked.png";

                        if (src.includes("pm-bookmark.png")) {
                            _this.src = checkedBookmarkImage;
                        } else {
                            _this.src = bookmarkImage;
                        }
                    }
                   </script>
                <footer>
                    <%@ include file="./footer.jsp" %>
                </footer>
            </body>

            </html>