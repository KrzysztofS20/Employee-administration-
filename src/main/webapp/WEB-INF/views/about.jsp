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
        <li><a class="active" href='<c:url value="/about"/>'>About</a></li>
        <li><a href='<c:url value="/products"/>'>Products</a></li>
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
        <h2>About me and shop</h2>

      </div>
    </section><!-- End Breadcrumbs -->

    <!-- ======= About Section ======= -->
    <section id="about" class="about">
      <div class="container">

        <div class="row">
          <div class="col-lg-6">
            <img src="../resources/img/about.jpg" class="img-fluid" alt="">
          </div>
          <div class="col-lg-6 pt-4 pt-lg-0 content">
            <h3>Hi, I'm Christopher a young java developer.</h3>
            <p class="fst-italic">

            </p>
            <ul>
              <li>I have created the whole backend myself. It was not an easy task and I encountered many problems that I am trying to solve so far. I learn on my own, which gives me a lot of satisfaction, but unfortunately the project does not move forward quickly. It's long-term project and I will develop many new features in future.</li>
              <li>The frontend is bootstrapped from the web. It's available on <a href="https://bootstrapmade.com/eterna-free-multipurpose-bootstrap-template/">here</a> and titled Eterna. I created some pages myself, others I changed or matched for better functionality. The whole frontend in this project will be changed to mine, but you still have to wait for that.</li>
                <li>In the future I want to become a full stack Java developer. I know there is a lot to improve, but I'm eager to learn more.</li>
            </ul>
            <ul>
              <li>Technologies used in the project:</li>
              <li>Java</li>
              <li>JSP</li>
              <li>HTML CSS JS</li>
              <li>Spring Boot</li>
              <li>Hibernate</li>
              <li>JDBC</li>
              <li>JPA</li>
              <li>MySQl/Postgresql</li>
            </ul>
          </div>
        </div>

      </div>
    </section><!-- End About Section -->

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