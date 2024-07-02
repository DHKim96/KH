<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/product/productCategoryPage.css">
</head>
<body>
    <header>
        <%@ include file="../common/header.jsp" %>
    </header>
    <div align="center">
        <div id="pc-content">
            <div class="pc-sale pc-header" id="pc-deal-header">
                <span class="pc-category" align="center">오늘의딜</span>
            </div>
            <div class="pc-sale pc-header" id="pc-deal-header">
                <h4 class="pc-gray">전체 <span class="pc-gray">${listCount}</span>개</h4>
            </div>
            <div class="pc-sale" id="pc-deal-contents">
                <c:forEach var="ps" items="${psList}">
                    <div class="pc-sale-content">
                        <div class="pc-sale-img">
                            <img src="${contextPath}/${ps.productThumbnail}" onclick='location.href="${contextPath}/detail.pr?productId=${ps.productId}"'>
                            <button type="button">
                                <img src="${contextPath}/resources/img/product/pm-bookmark.png" width="40px" onclick="changeBookmark(this, '${ps.productId}')">
                            </button>
                        </div>

                        <div class="pc-sale-text">
                            <div class="pc-company">
                                ${ps.companyName}
                            </div>
                            <div class="pc-title">
                                ${ps.productName}
                            </div>
                            <div class="pc-price">
                                <span class="pc-color">${ps.sale}%</span>
                                <span><fmt:formatNumber value="${ps.productPrice}" /></span>
                            </div>
                            <div class="pc-review">
                                <img src="${pageContext.request.contextPath}/resources/img/product/star.png" width="15px">
                                <span class="pc-score">${ps.ratingAvg}</span>
                                <span class="pc-gray">리뷰</span>
                                <span class="pc-gray">${ps.reviewCount}</span>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <script>
                    function changeBookmark(_this, pNo){
                        const contextPath = "${pageContext.request.contextPath}";
                        const src = _this.src;
                        const bookmarkImage = contextPath + "/resources/img/product/pm-bookmark.png";
                        const checkedBookmarkImage = contextPath + "/resources/img/product/pm-bookmark-checked.png";
                      
                        const membersNo = "${loginUser.membersNo}"
                        if (src.includes("pm-bookmark.png")) {
                            _this.src = checkedBookmarkImage;
                        } else {
                            _this.src = bookmarkImage;
                        }

                        $.ajax({
                                url : "scrap.pr",
                                data : {
                                    mNo : membersNo,
                                    pNo : pNo,
                                    status : src.includes("pm-bookmark.png") ? "Y" : "N"
                                },
                                success : function(result){
                                    console.log("스크랩 성공.")
                                },
                                error : function(){
                                    console.log("스크랩 실패")
                                }       
                            })
                    }
                    
					let pageNum = 2;
					
                    function addproductList(maxPage, saleDesc){
                    	if(pageNum > maxPage) {
                    		$("#nextbutton").remove();
                    		return;
                    	}
						
                        $.ajax({
                            url : "ajaxSaleList.pr",
                            data : {
                                cpage : pageNum,
                                condition : saleDesc
                            },
                            success : function(list){
                            	console.log("성공")
                                drawSaleProductList(list)
                                pageNum += 1;
                            },
                            error : function(){
                                console.log("실패")
                            }
                        })
                    }

                    function drawSaleProductList(list){
                        
                        const saleArea = document.getElementById("pc-deal-contents");

                        for (let i = 0; i < list.length; i++) {
                            const saleproduct = list[i];
            
                            if (saleproduct) {
                                saleArea.innerHTML += `<div class="pc-sale-content">
                                    <div class="pc-sale-img">
                                        <img src="${pageContext.request.contextPath}/` +  saleproduct.productThumbnail + `" width="260px"
                                         onclick="location.href='${pageContext.request.contextPath}/detail.pr?productId=` + saleproduct.productId + `'">
                                        <button type="button" onclick="changeBookmark(this, `+saleproduct.productId+`)">
                                            <img src="${pageContext.request.contextPath}/resources/img/product/pm-bookmark.png" width="40px">
                                        </button>
                                    </div>
                                    <div class="pc-sale-text">
                                        <div class="pc-company">
                                            `+saleproduct.companyName +`
                                        </div>
                                        <div class="pc-title">
                                            `+ saleproduct.productName +`
                                        </div>
                                        <div class="pc-price">
                                            <span class="pc-color">`+ saleproduct.sale+`%</span>
                                            <span>`+ saleproduct.productPrice+`</span>
                                        </div>
                                        <div class="pc-review">
                                            <img src="${pageContext.request.contextPath}/resources/img/product/star.png" width="15px">
                                            <span class="pc-score">`+ saleproduct.ratingAvg +`</span>
                                            <span class="pc-gray">리뷰</span>
                                            <span class="pc-gray">`+ saleproduct.reviewCount +`</span>
                                        </div>
                                    </div>
                                </div>`
                            }
                        }
                    }

                </script>
            </div> 
            <div id="paging-area">
            	<a onclick="addproductList('${pi.maxPage}', 'saleDesc')">
            		<img id="nextbutton" src="${pageContext.request.contextPath}/resources/img/product/angle-small-down.png" alt="">
            	</a>
            </div> 
        </div>
    </div>
    <footer>
        <%@ include file="../common/footer.jsp" %>
    </footer>
</body>
</html>