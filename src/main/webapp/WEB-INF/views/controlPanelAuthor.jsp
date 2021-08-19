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
                <li><a class="active" href='<c:url value="/controlPanel"/>'>Control Panel</a></li>
                <li><a href='<c:url value="/contact"/>'>Contact</a></li>

            </ul>
            <i class="bi bi-list mobile-nav-toggle"></i>
        </nav><!-- .navbar -->
        <div class="h3" style="margin-bottom: 0px;">
            <a href="basket.html"><i class="bi bi-cart text-dark"></i></a>
        </div>
    </div>
</header><!-- End Header -->

<main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
        <div class="container">
            <h2>Control Panel</h2>

        </div>
    </section><!-- End Breadcrumbs -->


    <section id="about" class="about">
        <div class="container">
            <div class="row">

                <div class="col-12">
                    <h2>Add new author</h2>
                    <form name="addAuthor" method="post" action='<c:url value="/addAuthor"/>'>
                        <div class="row">

                            <div class="col-4" style="margin-bottom: 10px">

                                <input name="name" class="form-control" type="text" placeholder="podaj imie autora">
                            </div>

                            <div class="col-4" style="margin-bottom: 10px">
                                <input name="surname" class="form-control" type="text"
                                       placeholder="podaj nazwisko autora">
                            </div>
                            <div class="col-2">
                                <button type="submit" class="btn btn-dark">Add</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>


    <section>
        <div class="container">
            <table class="table">
                <thead class="thead-light">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">name</th>
                    <th scope="col">surname</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${authorsList}" var="author">
                    <tr>
                        <th scope="row">${author.id}</th>
                        <td>${author.name}</td>
                        <td>${author.surname}</td>
                        <td>
                            <div id="content" data-bs-toggle="modal" data-bs-target="#author${author.id}">
                                <button type="button" class="btn btn-secondary"><i class="bi bi-pencil"></i></button>
                            </div>
                        </td>


                        <td>
                            <form name="deleteAuthor" method="post"
                                  action='<c:url value="/deleteAuthor/${author.id}"/>'>
                                <button type="submit" class="btn btn-secondary"><i class="bi bi-trash"></i></button>
                            </form>
                        </td>


                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </section>

    <c:forEach items="${authorsList}" var="authory">
        <!-- Modal -->
        <div class="modal fade" id="author${authory.id}" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">

                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Change value</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form name="editAuthor" method="post" action='<c:url value="/editAuthor/${authory.id}"/>'>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-6">

                                    <input name="name" value="${authory.name}">
                                </div>
                                <div class="col-6">
                                    <input name="surname" value="${authory.surname}">
                                </div>
                            </div>
                        </div>
                        <button style="margin: 5px" type="submit" class="btn btn-dark button-rouded justify-content-center">Save
                        </button>
                    </form>
                </div>
            </div>
        </div>

    </c:forEach>


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

<%@include file="dynamic/js.jspf" %>

</body>

</html>