<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/product/productReview.css">
    </head>
    

    <div class="review-modal">
        <div class="review-modal__title">리뷰 쓰기<button type="button" class="review-modal__close">
            <svg
                    class="review-modal__close__icon" width="20" height="20" viewBox="0 0 20 20" fill="currentColor"
                    preserveAspectRatio="xMidYMid meet">
                    <path fill-rule="nonzero"
                        d="M11.6 10l7.1 7.1-1.6 1.6-7.1-7.1-7.1 7.1-1.6-1.6L8.4 10 1.3 2.9l1.6-1.6L10 8.4l7.1-7.1 1.6 1.6z">
                    </path>
                </svg></button></div>
        <form class="review-modal__form">
            <div class="review-modal__form__product"><img class="review-modal__form__product__image"
                    src="https://image.ohou.se/i/bucketplace-v2-development/uploads/productions/170202405808667729.png?gif=1&amp;w=144&amp;h=144&amp;c=c&amp;webp=1"
                    srcset="https://image.ohou.se/i/bucketplace-v2-development/uploads/productions/170202405808667729.png?gif=1&amp;w=160&amp;h=160&amp;c=c&amp;webp=1 1.5x,https://image.ohou.se/i/bucketplace-v2-development/uploads/productions/170202405808667729.png?gif=1&amp;w=240&amp;h=240&amp;c=c&amp;webp=1 2x,https://image.ohou.se/i/bucketplace-v2-development/uploads/productions/170202405808667729.png?gif=1&amp;w=320&amp;h=320&amp;c=c&amp;webp=1 3x">
                <div class="review-modal__form__product__contents">
                    <div class="review-modal__form__product__contents__brand">슬립퍼</div>
                    <div class="review-modal__form__product__contents__name">[단독] 티라 패브릭 침대프레임 SS/Q/K/LK/EK</div>
                    <div class="review-modal__form__product__contents__options"></div>
                </div>
            </div>
            <div class="review-modal__section">
                <div class="review-modal__section__title">별점 평가</div>
                <div class="review-modal__form__star__wrap">
                    <div class="review-modal__form__star">
                        <div class="review-modal__form__star__label">만족도</div>
                        <div class="review-modal__form__star__value">
                            <ul class="rating-input">
                                <li><label class="rating-input__star" aria-label="별점 1점" style="float: left;">
                                        <input class="rating-input_star1" type="radio" value="1">
                                        <svg class="star" fill="currentColor" width="1em" height="1em"
                                            preserveAspectRatio="xMidYMid meet" viewBox="0 0 36 36">
                                            <path fill-rule="evenodd"
                                                d="M18 30.7l-9 3.8c-1.5.7-2.6-.2-2.5-1.8l.8-9.7L1 15.6c-1-1.3-.6-2.6 1-3l9.5-2.2 5-8.3c1-1.5 2.3-1.5 3.1 0l5 8.3 9.6 2.2c1.6.4 2 1.7 1 3L28.7 23l.8 9.7c.1 1.6-1 2.5-2.5 1.8l-9-3.8z">
                                            </path>
                                        </svg></label></li>
                                <li><label class="rating-input__star" aria-label="별점 2점" style="float: left;">
                                        <input class="rating-input_star1" type="radio" value="2"><svg class="star"
                                            fill="currentColor" width="1em" height="1em"
                                            preserveAspectRatio="xMidYMid meet" viewBox="0 0 36 36">
                                            <path fill-rule="evenodd"
                                                d="M18 30.7l-9 3.8c-1.5.7-2.6-.2-2.5-1.8l.8-9.7L1 15.6c-1-1.3-.6-2.6 1-3l9.5-2.2 5-8.3c1-1.5 2.3-1.5 3.1 0l5 8.3 9.6 2.2c1.6.4 2 1.7 1 3L28.7 23l.8 9.7c.1 1.6-1 2.5-2.5 1.8l-9-3.8z">
                                            </path>
                                        </svg></label></li>
                                <li><label class="rating-input__star" aria-label="별점 3점" style="float: left;">
                                        <input type="radio" class="rating-input_star1" value="3"><svg class="star"
                                            fill="currentColor" width="1em" height="1em"
                                            preserveAspectRatio="xMidYMid meet" viewBox="0 0 36 36">
                                            <path fill-rule="evenodd"
                                                d="M18 30.7l-9 3.8c-1.5.7-2.6-.2-2.5-1.8l.8-9.7L1 15.6c-1-1.3-.6-2.6 1-3l9.5-2.2 5-8.3c1-1.5 2.3-1.5 3.1 0l5 8.3 9.6 2.2c1.6.4 2 1.7 1 3L28.7 23l.8 9.7c.1 1.6-1 2.5-2.5 1.8l-9-3.8z">
                                            </path>
                                        </svg></label></li>
                                <li><label class="rating-input__star" aria-label="별점 4점" style="float: left;">
                                        <input type="radio" class="rating-input_star1" value="4"><svg class="star"
                                            fill="currentColor" width="1em" height="1em"
                                            preserveAspectRatio="xMidYMid meet" viewBox="0 0 36 36">
                                            <path fill-rule="evenodd"
                                                d="M18 30.7l-9 3.8c-1.5.7-2.6-.2-2.5-1.8l.8-9.7L1 15.6c-1-1.3-.6-2.6 1-3l9.5-2.2 5-8.3c1-1.5 2.3-1.5 3.1 0l5 8.3 9.6 2.2c1.6.4 2 1.7 1 3L28.7 23l.8 9.7c.1 1.6-1 2.5-2.5 1.8l-9-3.8z">
                                            </path>
                                        </svg></label></li>
                                <li><label class="rating-input__star" aria-label="별점 5점" style="float: left;">
                                        <input type="radio" class="rating-input_star1" value="5"><svg class="star"
                                            fill="currentColor" width="1em" height="1em"
                                            preserveAspectRatio="xMidYMid meet" viewBox="0 0 36 36">
                                            <path fill-rule="evenodd"
                                                d="M18 30.7l-9 3.8c-1.5.7-2.6-.2-2.5-1.8l.8-9.7L1 15.6c-1-1.3-.6-2.6 1-3l9.5-2.2 5-8.3c1-1.5 2.3-1.5 3.1 0l5 8.3 9.6 2.2c1.6.4 2 1.7 1 3L28.7 23l.8 9.7c.1 1.6-1 2.5-2.5 1.8l-9-3.8z">
                                            </path>
                                        </svg></label></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="review-modal__section1">
                <div class="review-modal__section1__title">사진 첨부 (선택) </div>
                <div class="review-modal__section1__explain1">사진을 첨부해주세요. (최대 1장)</div>
                <input type="file" id="selectedFile" style="display: none;" />
                <input type="button" value="파일추가" onclick="document.getElementById('selectedFile').click();" class="FileButton">
                
            </div>
            <div class="review-modal__section2">
                <div class="review-modal__section__title2">리뷰 작성</div>
                <textarea placeholder="자세하고 솔직한 리뷰는 다른 고객에게 큰 도움이 됩니다. (최소 20자 이상)" class="review_textarea"
                    style="height: 56px;"></textarea>
                <div class="review-modal__form__review-input__length"><span
                        class="review-modal__form__review-input__length__value">0</span></div>
            </div>
            <button class="review_submit_button" type="submit">완료</button>
        </form>
    </div>