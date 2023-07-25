<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Lugx Gaming - Shop Page</title>
    <jsp:include page="/WEB-INF/layout/head_css.jsp"></jsp:include>
</head>

<body>

<jsp:include page="/WEB-INF/layout/header_js.jsp"></jsp:include>

<div class="page-heading header-text">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h3>Our Shop</h3>
                <span class="breadcrumb"><a href="#">Home</a> > Our Shop</span>
            </div>
        </div>
    </div>
</div>

<div class="section trending">
    <div class="container">
        <ul class="trending-filter">
            <li>
                <a class="is_active" href="/shop" data-filter=".*">SHOW ALL</a>
            </li>
            <li>
                <a class="is_active" href="/shop?kw=&product-type=1" data-filter=".*">ACTION</a>
            </li>
            <li>
                <a class="is_active" href="/shop?kw=&product-type=2" data-filter=".adv">LOGIC</a>
            </li>
            <li>
                <a class="is_active" href="/shop?kw=&product-type=3" data-filter=".str">RACING</a>
            </li>
        </ul>
        <div class="row trending-box">
            <c:forEach items="${requestScope.products}" var="p">
                <div class="col-lg-3 col-md-6 align-self-center mb-30 trending-items col-md-6 adv">
                    <div class="item">
                        <div class="thumb">
                            <a href="/product?id=${p.id}"><img src="${p.getImg()}" alt=""></a>
                            <span class="price">${p.getPrice()} €</span>
                        </div>
                        <div class="down-content">
                            <span class="category">Action</span>
                            <h4>${p.getName()}</h4>
                            <a href="/product?id=${p.id}"><i style="margin-top: 30%" class="fa fa-shopping-bag"></i></a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <ul class="pagination">
                    <c:if test="${pageable.getPage() > 1}">
                        <li class="page-item"><a href="/shop?kw=${pageable.kw}&page=${pageable.page-1}&product-type=${pageable.productType}">&lt;</a></li>
                    </c:if>
                    <c:forEach begin="1" end="${pageable.getTotal()}" var="i">
                        <li class="page-item ${pageable.page == i ? 'active' : ''}">
                            <a href="/shop?kw=${pageable.kw}&page=${i}&product-type=${pageable.productType}">${i}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${pageable.getPage() < pageable.getTotal()}">
                        <li class="page-item"><a href="/shop?kw=${pageable.kw}&page=${pageable.page+1}&product-type=${pageable.productType}">&gt;</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</div>


<div class="separator wide"></div>

<jsp:include page="/WEB-INF/layout/footer_container.jsp"></jsp:include>

<jsp:include page="/WEB-INF/layout/java_script.jsp"></jsp:include>
</body>
</html>