<header class="header-area header-sticky">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <nav class="main-nav">
                    <!-- ***** Logo Start ***** -->
                    <a href="/homes" class="logo-igg"></a>
                    <div class="search mx-5">
                        <form class="form_search" action="#" method="get">
                            <input type="text" placeholder="Type Something" class='searchText' name="kw"
                                   value="${pageable.getKw()}" onkeypress="handle">
                            <button role="button">Search Now</button>
                        </form>
                    </div>
                    <ul class="nav">
                        <li><a href="/homes" class="active">Home</a></li>
                        <li><a href="/shop">Our Shop</a></li>
                        <li>
                            <a style="background-color: #ee626b; font-size: 15px; " href="/cart">
                                <i style="margin-top: 12px" class="icona fa fa-shopping-bag"></i>
                            </a>
                        </li>
                        <form class="d-flex">
                            <% if (session.getAttribute("user") != null) { %>
                            <div class="right-items">
                                <li><a href="/user">${sessionScope.user.getUsername()}</a></li>
                            </div>
                            <div class="right-items">
                                <li><a href="/logout">Logout</a></li>
                            </div>
                            <% } else {%>
                            <div class="right-items">
                                <li><a href="/login">Login</a></li>
                            </div>
                            <% } %>
                        </form>
                    </ul>
                    <a class='menu-trigger'>
                        <span>Menu</span>
                    </a>
                    <!-- ***** Menu End ***** -->
                </nav>
            </div>
        </div>
    </div>
</header>