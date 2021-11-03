<%@include file="dynamic/css.jspf"%>

<body>



  <!-- ======= Header ======= -->
  <header id="header" class="d-flex align-items-center">
    <div class="container d-flex justify-content-between align-items-center">

      <div class="logo">
        <h1><a href='<c:url value="/index"/>'>Eterna</a></h1>
      </div>

      <nav id="navbar" class="navbar">
        <ul>
          <li><a href='<c:url value="/index"/>'>Home</a></li>
          <li><a href='<c:url value="/about"/>'>About</a></li>
          <li><a class="active" href='<c:url value="/products"/>'>Products</a></li>
          <li><a href='<c:url value="/controlPanel"/>'>Control Panel</a></li>
          <li><a href='<c:url value="/contact"/>'>Contact</a></li>
          
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->
      <div class="h3" style="margin-bottom: 0px;">
        <a href='<c:url value="/person"/>'><i class="bi bi-person-circle text-dark" ></i></a>
      <a href='<c:url value="/basket"/>'><i class="bi bi-cart text-dark" ></i></a>
    </div></div>
  </header><!-- End Header -->

  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
      <div class="container">
        <h2>Products</h2>

      </div>
    </section><!-- End Breadcrumbs -->

    <!-- ======= Portfolio Section ======= -->
    <section id="portfolio" class="portfolio">
      <div class="container">

        <div class="row">
          <div class="col-lg-12 d-flex justify-content-center">

            <nav id="navbar" class="navbar">
              <ul>
                <li class="dropdown"><a><span>Category</span> <i
                        class="bi bi-chevron-down"></i></a>
                  <ul>
                    <c:forEach items="${categoryList}" var="category1">
                    <c:if test="${category1.category == null}">
                    <li class="dropdown"><a href='<c:url value="/products/${category1.id}"/>'><span>${category1.name}</span></a>

                      <ul>
                        <c:forEach items="${category1.categories}" var="child">
                        <li class="dropdown"><a href='<c:url value="/products/${child.id}"/>'><span>${child.name}</span></a>
                          <ul>
                            <c:forEach items="${child.categories}" var="subChild">
                              <li><a href='<c:url value="/products/${subChild.id}"/>'>${subChild.name}</a></li>
                            </c:forEach>
                          </ul>
                          </c:forEach>
                      </ul>



                      </c:if>
                      </c:forEach>


                    </li>

                  </ul>
              </ul>
            </nav>

          </div>
        </div>

        <div class="row portfolio-container">
<c:forEach items="${productList}" var="product">
          <div class="col-lg-4 col-md-6 portfolio-item">
            <a href='<c:url value="/products/${product.id}"/>'>
            <div class="portfolio-wrap">
              <img src="../resources/img/portfolio/portfolio-1.jpg" class="img-fluid" alt="">
              <div class="portfolio-info">
                <h4>${product.name}</h4>
                <p>${product.price} <i class="bi bi-currency-euro"></i></p>
              </div>
            </div>
          </a>
          </div>

</c:forEach>
        </div>

      </div>
    </section><!-- End Portfolio Section -->

    

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer">

    
    

    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong><span>Eterna</span></strong>. All Rights Reserved
      </div>
      <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/eterna-free-multipurpose-bootstrap-template/ -->
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
      </div>
    </div>
  </footer><!-- End Footer -->

  <%@include file="dynamic/js.jspf"%>
</body>

</html>