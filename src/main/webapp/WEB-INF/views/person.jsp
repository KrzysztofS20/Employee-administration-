<%@include file="dynamic/css.jspf" %>

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
          <li><a href='<c:url value="/products"/>'>Products</a></li>
          <li><a href='<c:url value="/controlPanel"/>'>Control Panel</a></li>
          <li><a href='<c:url value="/contact"/>'>Contact</a></li>

        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->
      <div class="h3" style="margin-bottom: 0px;">
        <a href='<c:url value="/person"/>'><i class="bi bi-person-circle text-dark" ></i></a>
        <a href='<c:url value="/basket"/>'><i class="bi bi-cart text-dark"></i></a>
      </div>
    </div>
  </header>

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
    <div class="col">
      <div class="info-box">
        <div class="row">
<div class="col-3" style="margin-left: 10px;">
  <img src="../resources/img/avatar.png" class="img-fluid" alt="">
</div>
<div class="col-4 gy-5">
  <h2>${user.get().userName}</h2>
</div>
<div class="col-3 gy-5">
  <h2>${user.get().surname}</h2>
</div>
</div>
<div class="row">
  <div class="col-6">
<span>Phone number</span>
  </div>
<div class="col-6">
  <span>Email</span>
</div>
</div>
<div class="row">
  <div class="col-6">
<span>${user.get().phoneNumber}</span>
  </div>
<div class="col-6">
  <span>${user.get().email}</span>
</div>
</div>
<div class="row">
  <div class="row">
    <div class="col-6 gy-3">
  <span>Country</span>
    </div>
  <div class="col-6 gy-3">
    <span>City</span>
  </div>
  </div>

  <div class="row ">
    <div class="col-6 ">
  <span>${user.get().address.country}</span>
    </div>
  <div class="col-6">
    <span>${user.get().address.city}</span>
  </div>
  </div>
  <div class="row gy-3">
    <div class="col-6">
  <span>Street</span>
    </div>
  <div class="col-6">
    <span>Post-code</span>
  </div>
  </div>
  <div class="row ">
    <div class="col-6">
  <span>${user.get().address.street}</span>
    </div>
  <div class="col-6">
    <span>${user.get().address.postcode}</span>
  </div>
  </div>
  <div class="d-grid gap-2 col-6 mx-auto gy-3">
    <a href='<c:url value="/personEdit"/>' class="btn btn-secondary" type="button">Edit</a>
    
  </div>
</div>
    </div>
   
  </div>
</div>
  

   

   

   

    

  </main><!-- End #main -->

  <%@include file="dynamic/js.jspf" %>

</body>

</html>