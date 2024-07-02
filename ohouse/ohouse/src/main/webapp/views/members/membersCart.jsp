<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/memberCart.css">
</head>
<body>
    <header>
        <%@ include file="../common/headerNone.jsp" %>
    </header>
    <div align="center" style="min-width: 1136px; background: #F5F5F5;">
        <div class="cart-content">
            <div id="cart-item">
                <div id="cart-item-head">
                    <div id="cart-all-check">
                        <input type="checkbox" name="all" id="all">
                        <label for="all">모두 선택</label>
                    </div>
                    <span>선택삭제</span>
                </div>
                <div id="cart-product-list">
                    <div class="cart-product">
                        <input type="checkbox" class="card-check">
                        <div>
                            <div class="cart-product-main">
                                <img class="cart-product-img" src="${pageContext.request.contextPath}/resources/img/member/example.png" alt="">
                                <div class="cart-product-content" align="left">
                                    <div class="cart-product-title">[상도가구] 더메종 화이트 인테리어 식착 테이블 2인 1200 책상 테이블</div>
                                    <div class="cart-product-deliver">배송비 14,500원 착불</div>
                                </div>
                            </div>
                            <div class="cart-product-option" align="left">
                                <div class="cart-option">
                                    <span>화이트 1200_CO_M45</span>
                                    <img src="${pageContext.request.contextPath}/resources/img/member/close.png" alt="">
                                </div>
                                <div class="cart-count">
                                    <form class="cart-num-input">
                                        <button>-</button>
                                        <input type="number" name="middle" value="1">
                                        <button>+</button>
                                    </form>
                                    <span>65,900원</span>
                                </div>
                            </div>
                        </div>
                        <img class="cart-close-one" src="${pageContext.request.contextPath}/resources/img/member/close.png" alt="">
                    </div>
                    <div class="cart-total-price">
                        <div>
                            <a>옵션변경</a> |
                            <a>바로구매</a>
                        </div>
                        <h3>65,900원</h3>
                    </div>
                    <hr>
                    <div class="cart-fee">
                        <span>배송비 착불 <span>14,500</span>원</span>
                    </div>
                </div>
            </div>  
            <div id="cart-payment">
                <div id="cart-price">
                    <ul>
                        <li>
                            <span>총 상품금액</span>
                            <span>210,000원</span>
                        </li>
                        <li>
                            <span>총 배송비</span>
                            <span>+0원</span>
                        </li>
                        <li>
                            <span>총 할인금액</span>
                            <span>-144,100원</span>
                        </li>
                        <li>
                            <span>결제금액</span>
                            <h2>65,900원</h2>
                        </li>
                    </ul>
                </div>
                <button type="submit">1개 상품 구매하기</button>
            </div>
        </div>
    </div>
    <footer>
        <%@ include file="../common/footer.jsp" %>
    </footer>
</body>
</html>