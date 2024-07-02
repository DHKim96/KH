<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/product/productOrderPage.css">
</head>
<body>
 	<header>
        <%@ include file="../common/headerNone.jsp" %>
    </header>
    <div align="center">
        <!-- 주문자 정보 전달-->
        <form id="orderForm" action="insert.or" method="post">
            <div id="order-and-payment-area">
                <div id="order-area">
                    <h1 align="left" id="order-and-payment-text">주문/결제</h1>
                    <div id="orderer-area">
                        <div class="order-and-payment-information-text-area">
                            주문자
                        </div>
                        <div class="orderer-information-input-text">
                            <div id="orderer-info-text-area">
                                <span id="orderer-info-text">이름</span>
                            </div>
                            <div class="orderer-information-input-area">
                                <input type="text" class="orderer-information-input" value="${loginUser.membersName}">
                            </div> 
                        </div>
                        <div class="orderer-information-input-text">
                            <div id="orderer-info-text-area">
                                <span id="orderer-info-text">이메일</span>
                            </div>
                            <div class="orderer-information-input-area">
                                <input type="text" class="orderer-information-input" value="${loginUser.membersEmail}">
                            </div>
                        </div>
                        <div class="orderer-information-input-text">
                            <div id="orderer-info-text-area">
                                <span id="orderer-info-text">전화번호</span>
                            </div>
                            <div class="orderer-information-input-area">
                                <div class="orderer-phone-input-area">
                                    <input type="text" class="orderer-information-input" value="${loginUser.membersPhone}">
                                </div>
                            </div>
                        </div>
                        <div id="gap"></div>
                        <div class="order-and-payment-information-text-area between">
                            배송지
                            <span>위와 동일하게 채우기</span>
                        </div>
                        <div class="orderer-information-input-text">
                            <div id="orderer-info-text-area">
                                <span id="orderer-info-text">배송지명</span>
                            </div>
                            <div class="orderer-information-input-area">
                                <input type="text" class="orderer-information-input">
                            </div>
                        </div>
                        <div class="orderer-information-input-text">
                            <div id="orderer-info-text-area">
                                <span id="orderer-info-text">받는사람</span>
                            </div>
                            <div class="orderer-information-input-area">
                                <input type="text" class="orderer-information-input" name="recipientName">
                            </div>
                        </div>
                        <div class="orderer-information-input-text">
                            <div id="orderer-info-text-area">
                                <span id="orderer-info-text">전화번호</span>
                            </div>
                            <div class="orderer-information-input-area">
                                <div class="orderer-information-input-area">
                                    <div class="orderer-phone-input-area">
                                        <input type="text" class="orderer-information-input" name="recipientPhone" placeholder="'-'를 포함한 전화번호 입력">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="orderer-information-input-text">
                            <div id="orderer-info-text-area">
                                <span id="orderer-info-text">주소</span>
                            </div>
                            <div class="orderer-address-input-area">
                                <input type="text" class="orderer-address-input" name="recipientMainAddress">
                            </div>
                        </div>
                        <div class="orderer-information-input-text">
                            <div id="orderer-info-text-area">
                                <span id="orderer-info-text"></span>
                            </div>
                            <div class="orderer-address-input-area">
                                <input type="text" class="orderer-address-input" name="recipientSubAddress" placeholder="상세주소 입력">
                            </div>
                        </div>
                        <div id="default-shipping-destination">

                        </div>
                        <c:set var="totalProductPrice" scope="request">
                        	${(p.productPrice + o.price) * amount * (100 - p.sale) / 100}
                        </c:set>
                        <c:set var="totalPrice" scope="request">
                        	${totalProductPrice + p.productDeliveryPrice}
                        </c:set>
                        <div id="request-for-delivery">
                            <select name="requirement" id="request-for-delivery-choice">
                                <option value="배송시 요청사항을 선택해주세요" selected>배송시 요청사항을 선택해주세요</option>
                                <option value="부재시 문앞에 놓아주세요">부재시 문앞에 놓아주세요</option>
                                <option value="배송전에 미리 연락주세요">배송전에 미리 연락주세요</option>
                                <option value="부재시 경비실에 맡겨 주세요">부재시 경비실에 맡겨 주세요</option>
                                <option value="부재시 전화주시거나 문자 남겨 주세요">부재시 전화주시거나 문자 남겨 주세요</option>
                            </select>
                        </div>
                        <div class="order-and-payment-information-text-area">
                            주문상품
                            <span class="order-product-count1">1건</span>
                        </div>
                        <div id="order-product-information-area">
                            <div id="order-product-information-header">
                                <div id="order-product-information-text1">
                                    <span>${p.companyName}</span>
                                    <span>배송비 <fmt:formatNumber value="${p.productDeliveryPrice}"/>원</span>
                                </div>
                                <hr id="hr1">
                                <div id="order-product-information-text2">
                                    <span>업체직접배송</span>
                                </div>
                            </div>
                            <div id="order-product-information-footer">
                                <div id="order-product-img-area">
                                    <img id="order-product-img" src="${p.productThumbnail}" alt="">
                                </div>
                                <div id="order-product-information-text3">
                                    <p id="text1">${p.productName}</p>
                                    <p id="text2">${o.optionsName}</p>
                                    <p id="text3">
                                        <fmt:formatNumber value="${(p.productPrice + o.price) * (100 - p.sale) / 100}"/>원
                                        <span class="order-product-count2">${amount}개</span>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="order-and-payment-information-text-area">
                            결제수단
                        </div>
                        <div id="payment-method-area">
                            <div id="payment-method-choice-area">
                                <input type="hidden" name="paymentMethod" id="payment-method" value="">
                                <div class="choice-area" id="payment-method-choice1" onclick="choice(this)">
                                    <span>카드</span>
                                    <img class="choice-img" src="${pageContext.request.contextPath}/resources/img/product/productOrderCard.png" alt="">
                                </div>
                                <div class="choice-area" id="payment-method-choice2" onclick="choice(this)">
                                    <span>무통장입금</span>
                                    <img class="choice-img" src="${pageContext.request.contextPath}/resources/img/product/productOrderNOBankbook.png" alt="">
                                </div>
                                <div class="choice-area" id="payment-method-choice3" onclick="choice(this)">
                                    <span>카카오페이</span>
                                    <img class="choice-img" src="${pageContext.request.contextPath}/resources/img/product/productOrderkakao.png" alt="">
                                </div>
                                <div class="choice-area" id="payment-method-choice4" onclick="choice(this)">
                                    <span>토스</span>
                                    <img class="choice-img" src="${pageContext.request.contextPath}/resources/img/product/productOrderToss.png" alt="">
                                </div>
                                <div class="choice-area" id="payment-method-choice5" onclick="choice(this)">
                                    <span>네이버페이</span>
                                    <img class="choice-img" src="${pageContext.request.contextPath}/resources/img/product/productOrderNaverPay.png" alt="">
                                </div>
                                <div class="choice-area" id="payment-method-choice6" onclick="choice(this)">
                                    <span>페이코</span>
                                    <img class="choice-img" src="${pageContext.request.contextPath}/resources/img/product/productOrderPayco.png" alt="">
                                </div>
                                <div class="choice-area" id="payment-method-choice7" onclick="choice(this)">
                                    <span>핸드폰</span>
                                    <img class="choice-img" src="${pageContext.request.contextPath}/resources/img/product/productOrderPhone.png" alt="">
                                </div>
                            </div>

                            <script>
                                function choice(_this){
                                    const hiddenInput = document.getElementById("payment-method");
                                    const choiceArr = document.getElementsByClassName("choice-area");
                            
                                    for(let i = 0; i < choiceArr.length; i++){
                                        choiceArr[i].style.background="none";
                                        choiceArr[i].style.border="1px solid #eaedef";
                                    }
                            
                                    _this.style.background="#effbff";
                                    _this.style.border="1px solid #35c5f0";
                            
                                    if(hiddenInput.value.trim() === ""){
                                        hiddenInput.value = _this.querySelector("span").innerHTML;
                                    } else {
                                        hiddenInput.value = "";
                                        hiddenInput.value = _this.querySelector("span").innerHTML;
                                    }
                                }
                            </script>
                        </div>
                    </div>
                </div>
            <div id="payment-area">
                <div id="payment-info-area">
                    <div id="payment-info-text">
                        <div id="payment-amount-area">
                            <span>결제금액</span>
                        </div>
                        <div class="payment-amount-info-text">
                            <span>총 상품 금액</span>
                            <span><fmt:formatNumber value="${totalProductPrice}"/>원</span>
                        </div>
                        <div class="payment-amount-info-text margin-bottom-20px">
                            <span>배송비</span>
                            <span><fmt:formatNumber value="${p.productDeliveryPrice}"/>원</span>
                        </div>
                        <hr>
                        <div class="payment-amount-info-text total-payment-amount">
                            <span>최종 결제 금액</span>
                            <span><fmt:formatNumber value="${totalPrice}"/>원</span>
                            <input type="hidden" name="totalPrice" value="${totalPrice}">
                        </div>
                    </div>
                </div>
                <div id="paying">
                    <span onclick="submitForm()"><fmt:formatNumber value="${totalPrice}"/>원 결제하기</span>
                </div>
                <input type="hidden" name="productId" value="${p.productId}">
                <input type="hidden" name="optNameNo" value="${o.optionsNameNo}">
                <input type="hidden" name="amount" value="${amount}">
                <input type="hidden" name="deliveryDate" value="${p.deliveryDate}">
            </div>
        </div>
        </form>
        <script>
            function submitForm() {
                document.getElementById("orderForm").submit();
            }
        </script>
    </div>
    <footer>
        <%@ include file="../common/footer.jsp" %>
    </footer>
</body>
</html>