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

  

    <!-- ======= Portfolio Details Section ======= -->
    <section id="portfolio-details" class="portfolio-details">
      <div class="container">

        <div class="row gy-4">


          <div class="col-lg-4">
            <div class="portfolio-info">
              <h3>${product.name}</h3>
              <ul>
                <li><strong>Category</strong>: ${product.category.name}</li>
                <li><strong>Price</strong>: ${product.price} <i class="bi bi-currency-euro"></i></li>
                <li><strong>Autor</strong>: ${product.author.name} ${product.author.surname}</li>
              </ul>
              <form method="post"  action='<c:url value="/addItem/${product.id}"/>'>
                <div class="form-group">
                  <label for="quantity">choose quantity </label>
                  <select name="quantityOfProduct" class="form-control" id="quantity">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                  </select>
                </div>
                <button type="submit"  class="btn btn-dark ">Add to basket</button>

          </form>
          </div>
            
            <div class="portfolio-description">
              <h2>Description</h2>
              <p>
                ${product.description}
              </p>
            </div>
          </div>


          <div class="col-lg-8">
            <div class="portfolio-details-slider swiper-container">
              <div class="swiper-wrapper align-items-center">

                <div >
                  <img src="../resources/img/portfolio/portfolio-1.jpg" alt="">
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
    </section><!-- End Portfolio Details Section -->

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