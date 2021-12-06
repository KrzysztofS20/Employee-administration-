<%@include file="dynamic/css.jspf"%>

<body>



  <header id="header" class="d-flex align-items-center">
    <div class="container d-flex justify-content-between align-items-center">

      <div class="logo">
        <h1><a href='<c:url value="/index"/>'>Eterna</a></h1>

      </div>

      <nav id="navbar" class="navbar">
        <ul>
          <li><a href='<c:url value="/index"/>'>Home</a></li>
          <li><a href='<c:url value="/about"/>'>About</a></li>
          <li><a href='<c:url value="/products"/>'>Products</a></li>
          <li><a href='<c:url value="/controlPanel"/>'>Control Panel</a></li>
          <li><a href='<c:url value="/contact"/>'>Contact</a></li>
          
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->
      <div class="h3" style="margin-bottom: 0px;">
        <a href='<c:url value="/person"/>'><i class="bi bi-person-circle text-dark" ></i></a>
      <a class="active" href='<c:url value="/basket"/>'><i class="bi bi-cart text-dark" ></i></a>
    </div></div>
  </header><!-- End Header -->

  <main id="main">

<!-- ======= Breadcrumbs ======= -->
<section id="breadcrumbs" class="breadcrumbs">
  <div class="container">
    <h2>Basket</h2>

  </div>
</section><!-- End Breadcrumbs -->


<section id="contact" class="contact">

<div class="container">
  <div class="row">

    <c:forEach items="${userBasket.productOrderToBasketList}" var="basket">


    <div class="col-9">
      <div class="info-box" style="padding-bottom: 5px;">
<div>
  <div class="row">
    <div class="col-4" style="padding-left: 32px;">
      <img src="../resources/img/portfolio/portfolio-1.jpg" class="img-fluid" alt="">
      
    </div>
    <div class="col-8">
      <h3>${basket.product.name}</h3>
      <div class="col-4">price per item: ${basket.product.price}</div>
    </div>
  </div>
  <div class="row">
    <div class="col-2" style="padding-right: 0;">
      <h6 style="padding-top: 10px;">Quantity:</h6>
    </div>
    <div class="col-1" style="padding-left:0 ;">
      <h2>${basket.quantity}</h2>
    </div>
    <div class="col-2"></div>
    <div class="col-1">
      <h6 style="padding-top: 10px;">Sum:</h6>
    </div>
    <div class="col-1">
      <h2>${basket.toPay}</h2>
    </div>
    
    <div class="col-1 offset-4">
      <form method="post" action='<c:url value="/delete/${basket.id}"/>'>
      <button type="submit"  class="btn btn-light">
        <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
          <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
          <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
        </svg>
    </button>
      </form>
    </div>
  </div>
</div>
</div>
    </div>
    </c:forEach>

    <div class="col-3">
      <div class="info-box" style="padding-bottom: 5px;">
        <div><h2>Summary</h2></div>
        <div class="row">
          <div class="col-6">
            <h5>Total amount</h5>
          </div>
          <div class="col-6">
            <h5>${userBasket.summaryToPay}</h5>
          </div>
        </div>
<div class="row">
  <div class="col-6">
    <h5>Delivery</h5>
  </div>
  <div class="col-6">
    <h5>free</h5>
  </div>
</div>
</div>
      <form method="post" action='<c:url value="/order/${userBasket.id}"/>'>
<div class="row" style="margin: 0; padding-top: 10px;">
<button type="submit" class="btn btn-dark">
<h2>Order</h2>
</button>
</div>
      </form>
    </div>
  </div>
</div>
  
 </section>

  </main><!-- End #main -->

  <%@include file="dynamic/js.jspf"%>

</body>

</html>