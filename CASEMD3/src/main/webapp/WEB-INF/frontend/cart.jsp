<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Lugx Gaming Template - Cart Page</title>

    <jsp:include page="/WEB-INF/layout/head_css.jsp"></jsp:include>


</head>

<body>

<!-- ***** Preloader Start ***** -->
<%--<jsp:include page="layout/preloader.jsp"></jsp:include>--%>
<!-- ***** Preloader End ***** -->

<!-- ***** Header Area Start ***** -->
<jsp:include page="/WEB-INF/layout/header_js.jsp"></jsp:include>
<!-- ***** Header Area End ***** -->

<div class="page-heading header-text">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h3>Cart</h3>
                <span class="breadcrumb"><a href="#">Home</a> > Cart</span>
            </div>
        </div>
    </div>
</div>

<div class="cart-page section">
    <div id="cartpage-app" class="cartpage-container">
        <div class="cartpage-left">
            <div class="cartpage-section" data-select2-id="select2-data-13-9tyk">
                <h2>Cart</h2>
                <c:forEach items="${requestScope.cart.getCartItems()}" var="cartItem">
                    <div class="cart-listing" data-select2-id="select2-data-12-kkm5">
                        <div class="cart-item" data-select2-id="select2-data-11-d37n">
                            <div class="item-container" data-select2-id="select2-data-10-xtlc">
                                <a href="../../dashboard/asset/assets/images/single-game.jpg" class="cover">
                                    <picture>
                                        <img alt="Six Days in fallu" src="${cartItem.product.img}" loading="lazy">
                                    </picture>
                                </a>
                                <div class="information">
                                    <div class="name">
                                        <div class="platform platform-steam">
                                            <div><img class="icon-steam"
                                                      src="../../dashboard/asset/assets/images/steam.png" alt=""></div>
                                        </div>
                                        <span title="Six Days in Fallujah" class="title">${cartItem.product.name}</span>
                                    </div>
                                    <div class="type">Steam</div>
                                    <div class="actions">
                                        <a class="deleteItem">
                                            <a href="javascript:void(0)"
                                               onclick="handleDeleteCartItem(${cartItem.getId()})">
                                                <i class="delete fa-regular fa-trash-can"></i>
                                            </a>
                                        </a>
                                        <a class="moveToWishlist">Move to Wishlist</a>
                                    </div>
                                </div>
                                <div class="price-container" data-select2-id="select2-data-9-7f0z">
                                    <div class="price">${cartItem.price * cartItem.quantity} €</div>
                                    <input onchange="handleQuantityChange(this,${cartItem.product.id})" min="1" max="100" type="number" name="" class="form-control" value="${cartItem.quantity}">
                                    <span class="dropdown-wrapper" aria-hidden="true"></span>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="separator"></div>
        </div>
        <div class="cartpage-right">
            <h2>Summary</h2>
            <div class="cart-summary">

                <div class="summary-row">
                    <span>Subtotal</span>
                    <span>${cart.total} €</span>
                </div>
              <form method="get" action="/payment" style="text-align: center">
                  <button class="button gotopayment">Go to payment
                      <div><i class="fa-solid fa-greater-than"></i></div>
                  </button>
              </form>

                <span class="choice">or</span>
                <a href="/homes" class="back">
                    <div><i class="fa-solid fa-less-than"></i>Continue shopping</div>
                </a>
            </div>
        </div>
    </div>
</div>

<div class="separator wide"></div>

<jsp:include page="/WEB-INF/layout/footer_container.jsp"></jsp:include>

<jsp:include page="/WEB-INF/layout/java_script.jsp"></jsp:include>
<script>
    function handleQuantityChange(eQuantity, idProduct) {
        let url = `/cart?action=update&id=\${idProduct}&quantity=\${eQuantity.value}`;
        window.location.assign(url);
    }

    function handleDeleteCartItem(id) {
        let url = `/cart?action=delete&id=\${id}`;
        window.location.assign(url);
    }
</script>


</body>

</html>