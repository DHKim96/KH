<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String contextPath = request.getContextPath();
	
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/product/productMain.css">
</head>
<body>
    <header>
        <%@ include file="../common/header.jsp" %>
    </header>
    <div align="center">
        <img id="pm-ad" width="100%" src="${pageContext.request.contextPath}/resources/img/product/productMainAd.png">
        <div id="pm-content">
            <div class="pm-sale pm-header" id="pm-deal-header">
                <span class="pm-category">오늘의 딜</span>
                <span class="pm-add" onclick="location.href='${contextPath}/saleList.pr?cpage=1&condition=saleDesc'">더보기</span>
            </div>
            <div class="pm-sale pm-content" id="pm-deal-contents">
                <!-- 제품들을 그려주는 공간 -->




            </div>
            <div class="pm-sale pm-header" id="pm-best-header">
                <span class="pm-category">인기 상품</span>
                <span class="pm-add" onclick="location.href='${contextPath}/list.pr?cpage=1'">더보기</span>
            </div>
            <div class="pm-sale pm-content" id="pm-best-contents">
                
                <!--제품을 그려주는 공간-->
            </div>
        </div>
    </div>
    <script>
        
        window.onload = function(){ 
        
            $.ajax({
                url : "msList.pr",
                data : {
                    condition : 'saleDesc'
                },
                success : function(list){
                    drawSaleProductList(list)
                    
                },
                error : function(){
                    console.log("실패")
                }
            })

            $.ajax({
                url : "mList.pr",
                data : {
                    condition : 'saleDesc'
                },
                success : function(list){
                    drawProductList(list)
                   
                    
                },
                error : function(){
                    console.log("실패")
                }
            })
            
            
            function drawProductList(list){
            	

                const saleArea = document.getElementById("pm-best-contents");

                for (let i = 0; i < 4; i++) {
                    const product = list[i];
                    	saleText = "";
                    if (product.sale > 0) {
                
                        saleText = '<span class="pm-color">' + product.sale + '%</span>';
                    }
                    
                    var price = product.productPrice;
                    price = AddComma(price);
                    
                    if (product) {
                        saleArea.innerHTML += `<div class="pm-sale-content">
                            <div class="pm-sale-img">
                                <img src="${pageContext.request.contextPath}/` +  product.productThumbnail + `" width="260px" onclick="location.href='${pageContext.request.contextPath}/detail.pr?productId=` + product.productId + `'">
                                <button type="button" onclick="changeBookmark(this, `+product.productId+`)">
                                    <img src="${pageContext.request.contextPath}/resources/img/product/pm-bookmark.png" width="40px">
                                </button>
                            </div>
                            <div class="pm-sale-text">
                                <div class="pm-company">
                                    `+product.companyName +`
                                </div>
                                <div class="pm-title">
                                    `+ product.productName +`
                                </div>
                                <div class="pm-price">                                    
	                                `+ saleText +`
                                    <span>`+ price+`</span>
                                </div>
                                <div class="pm-review">
                                    <img src="${pageContext.request.contextPath}/resources/img/product/star.png" width="15px">
                                    <span class="pm-score">`+ product.ratingAvg +`</span>
                                    <span class="pm-gray">리뷰</span>
                                    <span class="pm-gray">`+ product.reviewCount +`</span>
                                </div>
                            </div>
                        </div>`
                    }
                }
            }



            function drawSaleProductList(list){

                const saleArea = document.getElementById("pm-deal-contents");

                for (let i = 0; i < 4; i++) {
                    const saleproduct = list[i];
                    
                    var price = saleproduct.productPrice;
                    price = AddComma(price);
                    
                    if (saleproduct) {
                        saleArea.innerHTML += `<div class="pm-sale-content">
                            <div class="pm-sale-img">
                                <img src="${pageContext.request.contextPath}/` +  saleproduct.productThumbnail + `" width="260px"
                                onclick="location.href='${pageContext.request.contextPath}/detail.pr?productId=` + saleproduct.productId + `'">
                                <button type="button" onclick="changeBookmark(this, `+saleproduct.productId+`)">
                                    <img src="${pageContext.request.contextPath}/resources/img/product/pm-bookmark.png" width="40px">
                                </button>
                            </div>
                            <div class="pm-sale-text">
                                <div class="pm-company">
                                    `+saleproduct.companyName +`
                                </div>
                                <div class="pm-title">
                                    `+ saleproduct.productName +`
                                </div>
                                <div class="pm-price">
                                    <span class="pm-color">`+ saleproduct.sale+`%</span>
                                    <span>`+ price+`</span>
                                </div>
                                <div class="pm-review">
                                    <img src="${pageContext.request.contextPath}/resources/img/product/star.png" width="15px">
                                    <span class="pm-score">`+ saleproduct.ratingAvg +`</span>
                                    <span class="pm-gray">리뷰</span>
                                    <span class="pm-gray">`+ saleproduct.reviewCount +`</span>
                                </div>
                            </div>
                        </div>`
                    }
                }
            }
        }

        function AddComma(price){
            var comma = /\B(?=(\d{3})+(?!\d))/g;                
            return price.toString().replace(comma, ',');
        }

	    function changeBookmark(button, pNo){    
	        const contextPath = "${pageContext.request.contextPath}";
	        const img = button.querySelector('img');
	        let src = img.src;
	        const bookmarkImage = contextPath + "/resources/img/product/pm-bookmark.png";
	        const checkedBookmarkImage = contextPath + "/resources/img/product/pm-bookmark-checked.png";
	     
	        const membersNo = "${loginUser.membersNo}"
	        if (src.includes("pm-bookmark.png")) {
	            img.src = checkedBookmarkImage;
	        } else {
	            img.src = bookmarkImage;
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
    </script>
    <footer>
        <%@ include file="../common/footer.jsp" %>
    </footer>
</body>
</html>