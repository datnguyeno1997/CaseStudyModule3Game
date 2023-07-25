<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


  <title>Lugx Gaming Template - Create_account Page</title>

  <jsp:include page="/WEB-INF/layout/head_css.jsp"></jsp:include>
</head>

<body>
  <header class="header-area header-sticky">
    <div class="fancybox-container">
      <div class="fancybox-stage">
        <div class="fancybox-slide fancybox-slide--current fancybox-slide--html fancybox-slide--compxplete">
          <div class="loginbox-register open fancybox-content" style="display: flex;">
            <div class="row mx-3 my-3">
              <a href="/homes" class="logo mb-5"><img src="/dashboard/asset/assets/images/logo.png" alt="" style="width: 158px; ;"></a>
              <form class="row" method="post">
              <div class="col-6 mt-4 mb-3">
                <input placeholder="Your Name:" name="name" required="">
              </div>
              <div class="col-6 mt-4 mb-3">
                <input placeholder="Your password:" type="password" name="password" required=""
                  style="margin: 0px; padding-right: 24px;">
              </div>
              <div class="col-6 mt-3 mb-3">
                <input placeholder="Your Email:" name="email" required="" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false">
              </div>
              <div class="col-6 mt-3 mb-3">
                <input placeholder="Full Name:" name="fullname" required="">
              </div>
              <div class="col-6 mt-3 mb-3">
                <input placeholder="Your Phonne" name="phone" required="">
              </div>
              <div class="col-6 mt-3 mb-3">
                <input placeholder="Your Address" name="address" required="">
              </div>
              <div class="button_create d-flex justify-content-center">
                <button class="button" type="submit">Submit</button>
              </div>
                <a href="/login" class="d-flex justify-content-center mt-5 text-white">« Back</a>
              </form>

            </div>
            <div class="wallpaper inactive">
              <img src="/dashboard/asset/assets/images/single-game.jpg"></img>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>
    </body>

</html>