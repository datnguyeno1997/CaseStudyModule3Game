<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Lugx Gaming Template - Bill Page</title>

    <jsp:include page="/WEB-INF/layout/head_css.jsp"></jsp:include>
</head>

<body>

<jsp:include page="/WEB-INF/layout/header_js.jsp"></jsp:include>

<div class="pagee-heading header-text">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="login-page section d-flex justify-content-center">
                    <div class="bill_form_container">
                        <div class="login_form">
                            <h2>Sample Bill</h2>
                            <div>
                                <div class="bill_type">
                                    <h5>Full Name: ${bill.name}</h5>
                                    <h5>SĐT: ${bill.phone}</h5>
                                </div>
                                <div class="bill_type">
                                    <h5>Address: ${bill.address}</h5>
                                    <h5>Email: ${bill.email}</h5>
                                </div>
                            </div>
                            <table class="table_bill table-bordered">
                                <thead>
                                    <tr>
                                        <th>STT</th>
                                        <th>Tên Hàng</th>
                                        <th>Số Lượng</th>
                                        <th>Đơn giá</th>
                                        <th>Thành tiền</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.cart.getCartItems()}" var="cartItem">
                                        <tr style="text-align: center;">
                                            <td>1</td>
                                            <td>${cartItem.product.name}</td>
                                            <td>${cartItem.quantity}</td>
                                            <td>${cartItem.price} €</td>
                                            <td>${cartItem.price * cartItem.quantity} €</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <td colspan="4" class="text-right">Total Bill:</td>
                                        <td id="totalBill">${cart.total} €</td>
                                    </tr>
                                </tfoot>
                            </table>
                            <div class="end">
                                <h4>CẢM ƠN QUÝ KHÁCH</h4>
                                <h5>HẸN GẶP LẠI</h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/layout/footer_container.jsp"></jsp:include>

<jsp:include page="/WEB-INF/layout/java_script.jsp"></jsp:include>

</body>

</html>

<%--<div class="page-heading header-text">--%>
<%--    <div class="container">--%>
<%--        <div class="row">--%>
<%--            <div class="col-lg-12">--%>
<%--                <h3></h3>--%>
<%--                <span></span>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--    <div class="bill_container mt-5">--%>
<%--        <h2 style="text-align:center">Sample Bill</h2>--%>
<%--        <div class="bill_type">--%>
<%--            <h5>Full Name: ${bill.name}</h5>--%>
<%--            <h5>SĐT: ${bill.phone}</h5>--%>
<%--        </div>--%>
<%--        <div class="bill_type">--%>
<%--            <h5>Address: ${bill.address}</h5>--%>
<%--            <h5>Email: ${bill.email}</h5>--%>
<%--        </div>--%>
<%--        <table class="table_bill table-bordered">--%>
<%--            <thead>--%>
<%--                <tr>--%>
<%--                    <th>STT</th>--%>
<%--                    <th>Tên Hàng</th>--%>
<%--                    <th>Số Lượng</th>--%>
<%--                    <th>Đơn giá</th>--%>
<%--                    <th>Thành tiền</th>--%>
<%--                </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--                <c:forEach items="${requestScope.cart.getCartItems()}" var="cartItem">--%>
<%--                    <tr style="text-align: center;">--%>
<%--                        <td>1</td>--%>
<%--                        <td>${cartItem.product.name}</td>--%>
<%--                        <td>${cartItem.quantity}</td>--%>
<%--                        <td>${cartItem.price} €</td>--%>
<%--                        <td>${cartItem.price * cartItem.quantity} €</td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
<%--            </tbody>--%>
<%--            <tfoot>--%>
<%--                <tr>--%>
<%--                    <td colspan="4" class="text-right">Total Bill:</td>--%>
<%--                    <td id="totalBill">${cart.total} €</td>--%>
<%--                </tr>--%>
<%--            </tfoot>--%>
<%--        </table>--%>
<%--    <div style="text-align: center;">--%>
<%--        <h4>CẢM ƠN QUÝ KHÁCH</h4>--%>
<%--        <h5>HẸN GẶP LẠI</h5>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
