<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Lugx Gaming Template - Login Page</title>

    <jsp:include page="/WEB-INF/layout/head_css.jsp"></jsp:include>
</head>

<body>

<jsp:include page="/WEB-INF/layout/header_js.jsp"></jsp:include>

<div class="pagee-heading header-text">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="login-page section d-flex justify-content-center">
                    <div class="login_form_container">
                        <div class="login_form">
                            <h2>Login</h2>
                            <form method="post" action="/login">
                                <div class="input_group">
                                    <i class="fa fa-user"></i>
                                    <input type="text" placeholder="Username" name="name" class="input_text" required="required"
                                           autocomplete="off"/>
                                </div>
                                <div class="input_group">
                                    <i class="fa fa-unlock-alt"></i>
                                    <input type="password" placeholder="Password" name="password" class="input_text" required="required"
                                           autocomplete="off"/>
                                </div>
                                <div class="login_button">
                                    <button class="button" type="submit">Submit</button>
                                </div>
                                <div class="fotter_login">
                                    <div><a href="/register">No account yet?</a></div>
                                    <div><a href="/lost_password">Lost your password?</a></div>
                                </div>
                            </form>
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