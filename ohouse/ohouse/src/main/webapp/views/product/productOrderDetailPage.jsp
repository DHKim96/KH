<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/product/productOrderDetail.css">
    </head>

    <body>
      <header>
        <%@ include file="../common/headerNone.jsp" %>
      </header>
      <c:set var="totalProductPrice" scope="request">
        ${(p.productPrice + o.price) * ordpd.amount * (100 - p.sale) / 100}
      </c:set>
      <c:set var="totalPrice" scope="request">
        ${totalProductPrice + p.productDeliveryPrice}
      </c:set>
      <div class="main">
        <div class="wrapper">
          <div id="main-header-content">
            <p class="main_header_text">주문상세</p>
            <p id="order-date">${order.ordersDate} 주문 &#40;주문번호 ${order.ordersId}&#41; </p>
          </div>
        </div>
        <div>
          <div class="wrapper">
            <div class="padding20">
              <div class="header-text"><span>배송지정보</span></div>
              <ul class="recipient-info">
                <li class="recipient-info-list">
                  <span>받는 사람</span>
                  <p>${order.recipientName}</p>
                </li>
                <li class="recipient-info-list">
                  <span>연락처</span>
                  <p>${order.recipientPhone}</p>
                </li>
                <li class="recipient-info-list">
                  <span>주소</span>
                  <p>&#40;${order.recipientPostcode}&#41;${order.recipientAddress}</p>
                </li>
                <li class="recipient-info-list">
                  <span>배송 메모</span>
                  <p>${order.requirement}</p>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div>
          <div class="wrapper">
            <div class="padding20">
              <div class="header-text">
                <span>주문상품</span>
              </div>
              <div>
                <div class="wrapper" style="padding: 0;">
                  <div class="recipient-info">
                    <div class="padding20">
                      <div class="margin-bottom20">
                        <div id="product-order-header">
                          <p>
                            <b style="font-weight: 700;">${order.deliveryStatus}</b>
                            <span style="font-size: 15px; line-height: 24px;">&middot;${order.arrivalDate} 도착</span>
                          </p>
                        </div>
                      </div>
                      <div id="product-order-info-container">
                        <div id="product-thumbnail-container">
                          <img src="${p.productThumbnail}" alt="">
                        </div>
                        <div id="product-order-info">
                          <p id="product-order-name">${p.productName}</p>
                          <p id="product-order-optionName">${o.optionsName}</p>
                          <p class="product-order-info-text">
                            <span>
                              <fmt:formatNumber value="${(p.productPrice + o.price) * (100 - p.sale) / 100}" />원
                            </span>
                            <span>&middot;${ordpd.amount}개</span>
                          </p>
                          <p class="product-order-info-text">
                            <span>${order.deliveryStatus}</span>
                          </p>
                        </div>
                      </div>
                    </div>
                    <div class="margin-bottom20">
                      <div id="delivery-info">
                        <div style="padding: 16px 12px;">
                          <ul style="list-style: none;">
                            <li class="delivery-info-list" style="margin-bottom: 6px;">
                              <span>배송비</span>
                              <div class="delivery-info-list-price">
                                <p>
                                  <fmt:formatNumber value="${p.productDeliveryPrice}" />원
                                </p>
                              </div>
                            </li>
                            <li class="delivery-info-list">
                              <span>판매자</span>
                              <div class="delivery-info-list-price">${p.companyName}</div>
                            </li>
                          </ul>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

            </div>
          </div>
        </div>
        <div class="wrapper">
          <div id="price-orderer-info">
            <div class="price-orderder-info-container">
              <div class="header-text"><span>결제정보</span></div>
              <div class="recipient-info">
                <ul>
                  <li class="price-orderer-info-content" style="margin-bottom: 8px;">
                    <p>총 상품금액</p>
                    <p class="text-align-end"><fmt:formatNumber value="${totalProductPrice}"/>원</p>
                  </li>
                  <li class="price-orderer-info-content">
                    <p>배송비</p>
                    <p class="text-align-end"><fmt:formatNumber value="${p.productDeliveryPrice}"/>원</p>
                  </li>
                </ul>
                <hr>
                <div>
                  <div class="price-orderer-info-content">
                    <p id="total-price">주문금액</p>
                    <p class="text-align-end" style="font-size: 18px; line-height: 24px; font-weight: 700;"><fmt:formatNumber value="${totalProductPrice}"/>원</p>
                  </div>
                  <ul>
                    <li id="payment">
                      <p>${paymentMethod}</p>
                      <p><fmt:formatNumber value="${totalProductPrice}"/>원</p>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
            <div class="price-orderder-info-container">
              <div class="header-text"><span>주문자정보</span></div>
              <ul class="recipient-info">
                <li>
                  <span>주문자</span>
                  <p style="margin-left: 15px;">${loginUser.membersName}</p>
                </li>
                <li>
                  <span>연락처</span>
                  <p style="margin-left: 15px;">${loginUser.membersPhone}</p>
                </li>
                <li>
                  <span>이메일</span>
                  <p style="margin-left: 15px;">${loginUser.membersEmail}</p>
                </li>
              </ul>
              <p id="customer-service-center-phone">
                오늘의집 고객센터&nbsp;
                <span style="color: rgb(47, 52, 56);">1111-2222</span>
              </p>
            </div>
          </div>
        </div>
      </div>
      <footer>
        <%@ include file="../common/footer.jsp" %>
      </footer>
    </body>

    </html>