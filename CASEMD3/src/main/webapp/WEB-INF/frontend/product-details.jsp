<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Lugx Gaming - Product Detail</title>
    <jsp:include page="/WEB-INF/layout/head_css.jsp"></jsp:include>


</head>

<body>

<!-- ***** Preloader Start ***** -->
<%--  <jsp:include page="layout/preloader.jsp"></jsp:include>--%>
<!-- ***** Preloader End ***** -->

<!-- ***** Header Area Start ***** -->
<jsp:include page="/WEB-INF/layout/header_js.jsp"></jsp:include>
<!-- ***** Header Area End ***** -->

<div class="page-heading header-text">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h3>Modern Warfare® II</h3>
                <span class="breadcrumb"><a href="/homes">Home</a>  >  <a href="/shop">Shop</a>  >  Assasin Creed</span>
            </div>
        </div>
    </div>
</div>

<div class="single-product section">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="left-image">
                    <img src="${p.getImg()}" alt="">
                </div>
            </div>
            <div class="col-lg-6 align-self-center">
                <h4>${p.name}</h4>
                <span class="price">${p.price} €</span>
                <p>LUGX Gaming Template is based on the latest Bootstrap 5 CSS framework. This template is provided by
                    TemplateMo and it is suitable for your gaming shop ecommerce websites. Feel free to use this for any
                    purpose. Thank you.</p>
                <form method="post" action="/cart?action=add&id=${p.id}">
                    <input class="form-control" type="number" name="qty" value="1" min="1" max="100">
                    <button class="button" type="submit"><i style="margin-bottom: 5px; margin-right: 10px" class="fa fa-shopping-bag"></i> ADD TO CART
                    </button>
                </form>
                <ul>
                    <li><span>Game ID:</span> COD MMII</li>
                    <li><span>Genre:</span> <a href="#">Action</a>, <a href="#">Team</a>, <a href="#">Single</a></li>
                    <li><span>Multi-tags:</span> <a href="#">War</a>, <a href="#">Battle</a>, <a href="#">Royal</a></li>
                </ul>
            </div>
            <div class="col-lg-12">
                <div class="sep"></div>
            </div>
        </div>
    </div>
</div>

<div class="more-info">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="tabs-content">
                    <div class="row">
                        <div class="nav-wrapper ">
                            <ul class="nav nav-tabs" role="tablist">
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link active" id="description-tab" data-bs-toggle="tab"
                                            data-bs-target="#description" type="button" role="tab"
                                            aria-controls="description" aria-selected="true">Description
                                    </button>
                                </li>
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link" id="reviews-tab" data-bs-toggle="tab"
                                            data-bs-target="#reviews" type="button" role="tab" aria-controls="reviews"
                                            aria-selected="false">Reviews (3)
                                    </button>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="description" role="tabpanel"
                                 aria-labelledby="description-tab">
                                <p>You can search for more templates on Google Search using keywords such as "templatemo
                                    digital marketing", "templatemo one-page", "templatemo gallery", etc. Please tell
                                    your friends about our website. If you need a variety of HTML templates, you may
                                    visit Tooplate and Too CSS websites.</p>
                                <br>
                                <p>Coloring book air plant shabby chic, crucifix normcore raclette cred swag artisan
                                    activated charcoal. PBR&B fanny pack pok pok gentrify truffaut kitsch helvetica jean
                                    shorts edison bulb poutine next level humblebrag la croix adaptogen. Hashtag poke
                                    literally locavore, beard marfa kogi bruh artisan succulents seitan tonx waistcoat
                                    chambray taxidermy. Same cred meggings 3 wolf moon lomo irony cray hell of bitters
                                    asymmetrical gluten-free art party raw denim chillwave tousled try-hard succulents
                                    street art.</p>
                            </div>
                            <div class="tab-pane fade" id="reviews" role="tabpanel" aria-labelledby="reviews-tab">
                                <p>Coloring book air plant shabby chic, crucifix normcore raclette cred swag artisan
                                    activated charcoal. PBR&B fanny pack pok pok gentrify truffaut kitsch helvetica jean
                                    shorts edison bulb poutine next level humblebrag la croix adaptogen. <br><br>Hashtag
                                    poke literally locavore, beard marfa kogi bruh artisan succulents seitan tonx
                                    waistcoat chambray taxidermy. Same cred meggings 3 wolf moon lomo irony cray hell of
                                    bitters asymmetrical gluten-free art party raw denim chillwave tousled try-hard
                                    succulents street art.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="section categories related-games">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="section-heading">
                    <h6>Action</h6>
                    <h2>Related Games</h2>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="main-button">
                    <li>
                        <a class="is_active" href="/shop" data-filter=".*">VIEW ALL</a>
                    </li>
                </div>
            </div>
            <c:forEach items="${requestScope.products}" var="product">
                <div class="col-lg col-sm-6 col-xs-12">
                    <div class="item">
                        <h4>Action</h4>
                        <div class="thumb">
                            <a href="/product?id=${product.id}">
                                <img style="height: 240px" src="${product.getImg()}" alt="">
                            </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>



<div class="separator wide"></div>

<jsp:include page="/WEB-INF/layout/footer_container.jsp"></jsp:include>

<jsp:include page="/WEB-INF/layout/java_script.jsp"></jsp:include>

</body>
</html>