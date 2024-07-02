<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/product/productPage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/footer.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <header>
        <%@ include file="../common/header.jsp" %>
    </header>
    <div align="center">
        <div class="productPageCenter">
            <div class="product-Info">
                <div class="productMainImg">
                    <img src="${contextPath}/${product.productThumbnail}"
                        alt="">
                </div>
                <div class="productMainInfo">
                    <div class="productMainInfo-product-name">${product.productName}</div>
                    <div class="product-origin-price">
                        <span id="sale">${product.sale}</span>%
                        <del id="origin">${product.productPrice}</del>원
                    </div>
                    <c:set var="price" value="${product.productPrice * (100 - product.sale) / 100}"/>
                    <c:set var="total" value="${product.productDeliveryPrice + price}"/>
                    <div class="product-discount-price">
                        <span class="product-price-number" id="price">${price}</span>
                        <span class="product-price-won">원</span>
                    </div>
                    <div class="product-delivery">
                        <span>배송</span> &nbsp;
                        <span>
                            <span>
                                <b id="deliver">${product.productDeliveryPrice}</b>원
                            </span>
                        </span>
                    </div>
                    <div class="product-options">
                    </div>
                    <form class="product-num" action="orderForm.pr">
                        <input type="hidden" name="pNo" value="${product.productId}">
                        <input type="hidden" name="optNameNo" id="param">
                        <div class="product-num-input">
                            <button type="button" onclick="calc('-'); changePrice();">-</button>
                            <input type="number" id="middle" value="1" name="amount">
                            <button type="button" onclick="calc('+'); changePrice();">+</button>
                        </div>
                        <div class="product-order-price">
                            <p>
                                <span class="product-order-price-text">주문금액
                                </span>
                                <span class="product-order-total-price">
                                    <span id="total">${total}</span>원
                                    <input type="hidden" name="order" id="input-hidden" value="${total}">
                                </span>
                            </p>
                        </div>
                        <div class="product-ScrabAndOrder">
                            <!-- <button class="button-basket" type="button">장바구니</button> -->
                            <button class="button-buynow" type="submit">바로구매</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script>
        $(function(){
            options("option.pr", {productId: '${product.productId}'}, function(result){
                drawOption(result);
                $("select").change(function(){
                    $("#param").val($(this).val());
                });
            })
            addComma('${product.sale}', '#sale');
            addComma('${product.productPrice}', '#origin');
            addComma('${price}', '#price');
            addComma('${product.productDeliveryPrice}', '#deliver');
            addComma('${total}', '#total');
            // addParam();
        })

        function options(url, data, callback) {
            $.ajax({
                url: url,
                data: data,
                success: function(result) {
                    // console.log(result);
                    callback(result);
                },
                error: function() {
                    console.log("옵션 불러오기 실패")
                }
            });
        }

        function drawOption(result) {
            if(result.length === 0) return;
            const parent = document.querySelector(".product-options");

            for(let ele of result) {
                const child = document.createElement("select");
                child.setAttribute("class", "product-option");

                child.innerHTML += `<option>` + ele.optionsCategory + `</option>`;
                const category = {cgNo : ele.optionsNo};
                options("detailOption.pr", category, function(list) {
                    for(let e of list) {
                        child.innerHTML += `<option value="` + e.optionsNameNo + `">` + e.optionsName + `</option>`
                    }
                })
                parent.appendChild(child);
            }
        }

        function addComma(price, id){
            let comma = /\B(?=(\d{3})+(?!\d))/g;
            price = Math.round(price);
            $(id).html(price.toString().replace(comma, ','));
        }

        function addParam() {
            const parent = document.querySelector(".product-options");
            console.log(parent.options[parent.selectedIndex].value);
            // $("#param").val($(parent))
        }

        function changePrice() {
            const c = parseInt(document.getElementById("middle").value);
            addComma('${total}' * c, '#total');
            $('#input-hidden').val('${total}' * c);
        }

        function calc(type) {
            let value = document.getElementById("middle").value;
            if(type === '+') {
                $('#middle').val(parseInt(value) + 1);
            } else {
                $('#middle').val(parseInt(value) - 1);
            }
        }
    </script>
</body>
<footer>
    <%@ include file="../common/footer.jsp" %>
</footer>
</body>
</html>