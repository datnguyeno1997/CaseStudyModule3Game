<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Lugx Gaming Template - Contact Page</title>

    <jsp:include page="/WEB-INF/layout/head_css.jsp"></jsp:include>

</head>

<body>

    <!-- ***** Preloader Start ***** -->
<%--    <jsp:include page="layout/preloader.jsp"></jsp:include>--%>
    <!-- ***** Preloader End ***** -->

    <!-- ***** Header Area Start ***** -->
    <jsp:include page="/WEB-INF/layout/header_js.jsp"></jsp:include>
    <!-- ***** Header Area End ***** -->

    <div style="display: flex; justify-content: center;" class="page-heading header-text">
        <div class="lostpassword-container">
            <h3>Lost your password?</h3>
            <p class="readable"> Please enter the address which you used to register. We will send you an email
                with your new password. Check your spam box if you do not receive it. In case of any
                complications, please contact us at this address: hungvo@gmail.com</p>
            <form method="post">
                <div class="actions">
                    <input placeholder="Your email:" class="ig-lostpassword-fields" name="email" tabindex="6"
                        type="text">
                    <div>
                        <button class="button g-recaptcha" id="lost-password-submit">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>



    <div class="separator wide"></div>
    <jsp:include page="/WEB-INF/layout/footer_container.jsp"></jsp:include>

    <jsp:include page="/WEB-INF/layout/java_script.jsp"></jsp:include>

</body>

</html>