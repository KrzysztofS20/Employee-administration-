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
          <li><a  href='<c:url value="/index"/>'>Home</a></li>
          <li><a href='<c:url value="/about"/>'>About</a></li>
          <li><a href='<c:url value="/products"/>'>Products</a></li>
          <li><a class="active" href='<c:url value="/controlPanel"/>'>Control Panel</a></li>
          <li><a href='<c:url value="/contact"/>'>Contact</a></li>
          
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->
      <div class="h3" style="margin-bottom: 0px;">
      <a href='<c:url value="/basket"/>'><i class="bi bi-cart text-dark" ></i></a>
    </div></div>
  </header><!-- End Header -->

  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
      <div class="container">
        <h2>Control Panel</h2>

      </div>
    </section><!-- End Breadcrumbs -->

     <!-- ======= Services Section ======= -->
     <section id="services" class="services">
      <div class="container">

        <div class="row">
          <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
            <a href='<c:url value="/controlPanelCategory"/>'>
            <div class="icon-box">
              <div class="icon"></div>
              <h4><a>Categorys</a></h4>
              <p>Miejsce do dodania, usuniecia lub modyfikacji Kategori</p>
            </div>
          </a>
          </div>

          <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
            <a href='<c:url value="/controlPanelAuthor"/>'>
            <div class="icon-box">
              <div class="icon"></div>
              <h4><a>Authors</a></h4>
              <p>Miejsce do dodania, usuniecia lub modyfikacji Autora</p>
            </div>
          </a>
          </div>

          <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
            <a href='<c:url value="/controlPanelProduct"/>'>
            <div class="icon-box">
              <div class="icon"></div>
              <h4><a>Products</a></h4>
              <p>Miejsce do dodania, usuniecia lub modyfikacji Produktu</p>
            </div>
          </a>
          </div>
        </div>

      </div>
    </section

    

    
   

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