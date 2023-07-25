<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment</title>
    <jsp:include page="/WEB-INF/layout/head_css.jsp"></jsp:include>
</head>

<body class="region">
<header class="header-container">
    <a href="/homes" title="Home" class="logo-ig"></a>
    <div class="progress-steps">
        <a href="/cart" class="step done">
                <span class="number">
                    <div class="icon-check fa-solid fa-check"></div>
                </span>
            <span class="text">Shopping cart</span>
            <span class="spacer"></span>
        </a>
        <span class="step active">
                <span class="number">2</span>
                <span class="text">Payment</span>
            </span>
    </div>
    <div class="secure">
        <div class="fa-solid fa-lock"></div>
        <div class="text">
            <span class="secured">Secure payment</span>
            <span class="ssl">256-bit SSL Secured</span>
        </div>
    </div>
</header>
<div class="main-content">
    <div class="payment-container">
        <div class="payment-app">
            <c:if test="${requestScope.errors != null}">
                <div class="alert alert-danger">
                    <ul>
                        <c:forEach items="${requestScope.errors}" var="e">
                            <li>${e}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
            <form method="post" action="/bill" class="payment-form">
                <div class="platforms">
                    <div class="billing-address-container">
                        <h2>Billing address</h2>
                        <div class="address-form raw ">
                            <label><input placeholder="Full name: (Nguyễn Văn A)" type="text" name="name" required="required"
                                          autocomplete="payment-form" class="name"></label>
                            <label><input placeholder="Address: (28 Nguyễn Trường Tộ)" type="text" name="address" required="required"
                                          autocomplete="payment-form" class="street"></label>
                            <label><input placeholder="Phone: (0123456789)" type="text" name="phone" required="required"
                                          autocomplete="payment-form" class="phone"></label>
                            <label><input placeholder="Email: (nguyena@gmail.com)" type="text" name="email" required="required"
                                          autocomplete="payment-form" class="email"></label>
                            <label class="billing-country-dropdown-container">
                                <select class="form-select" style="height: 55px;">
                                    <option selected="">Viet Nam</option>
                                    <option value="1">Hong Kong</option>
                                    <option value="2">Australia</option>
                                    <option value="3">Thailand</option>
                                </select>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="panel">
                    <h2>Summary</h2>
                    <div class="table">
                        <div class="pay-resume">
                                <div class="games">
                                    <c:forEach items="${requestScope.cart.getCartItems()}" var="cartItem">
                                    <div class="game">
                                        <div class="information">
                                            <span class="name">
                                                <span title="Six Days in Fallujah"
                                                      class="title">${cartItem.product.name}</span>
                                            </span>
                                            <span class="type">Steam</span>
                                        </div>
                                        <span class="price">${cartItem.price * cartItem.quantity} €</span>
                                    </div>
                                    </c:forEach>
                                </div>
                        </div>
                        <div class="pay-button">
                            <div id="ig-vat" data-rate="0" class="summary-row">
                                <span class="ig-vat-percentage">VAT (<span>0</span>%) :</span>
                                <span class="ig-vat-value">
                                        <span>0€</span>
                                    </span>
                            </div>
                            <div class="summary-row total">
                                <span class="texttotal">Total</span>
                                <span class="subtotal">${cart.total} €</span>
                            </div>
                            <div class="payment-platform-submit">
                                <div class="hipay">
                                    <button type="submit" class="button hipay_tpp_submit">Pay</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="separator wide"></div>
<jsp:include page="/WEB-INF/layout/footer_container.jsp"></jsp:include>
</body>

</html>