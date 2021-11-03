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
            <a href='<c:url value="/person"/>'><i class="bi bi-person-circle text-dark" ></i></a>
            <a href='<c:url value="/basket"/>'><i class="bi bi-cart text-dark"></i></a>
        </div>
    </div>
</header>
<!-- End Header -->

<main id="main">



    <script>
        function setParam() {
            document.getElementById("paramForParentCategory").action = "/action_page.php";
        }
    </script>




    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
        <div class="container">
            <h2>Control Panel</h2>

        </div>
    </section>
    <!-- End Breadcrumbs -->

    <!-- ======= Add Category Section ======= -->
    <section id="about" class="about">
        <div class="container">
            <div class="row">

                <div class="col-12">
                    <h2>Add new category</h2>
                    <form method="post" id="paramForParentCategory" action='<c:url value="/addCategory"/>' >
                    <div class="row">
                            <div class="col-4">
                                <select  name="category" class="form-control" >
                                    <option value="" >wybierz kategorie nadrzedna</option>
                                    <c:forEach items="${categoryList}" var="listOfCategory">
                                        <option value="${listOfCategory.id}">${listOfCategory.name}</option>

                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-4" style="margin-bottom: 10px">

                                <input class="form-control" type="text" name="name" placeholder="podaj nazwe kategori">
                                <input  type="hidden" name="id" value="">
                            </div>
                            <div class="col-2">
                                <button type="submit"  class="btn btn-dark">dodaj</button>
                            </div>




                    </div>
                    </form>

                    <nav id="navbar" class="navbar">
                        <ul>
                            <li class="dropdown"><a><span>Obecne drzewo kategori</span> <i
                                    class="bi bi-chevron-down"></i></a>
                                <ul>
                                    <c:forEach items="${categoryList}" var="category1">
                                    <c:if test="${category1.category == null}">
                                    <li class="dropdown"><a><span>${category1.name}</span></a>

                                        <ul>
                                            <c:forEach items="${category1.categories}" var="child">
                                                <li class="dropdown"><a><span>${child.name}</span></a>
                                                <ul>
                                                    <c:forEach items="${child.categories}" var="subChild">
                                                        <li><a>${subChild.name}</a></li>
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
        </div>
    </section>
    <!-- ======= End Add Category Section ======= -->

    <section>
        <div class="container">
            <table class="table">
                <thead class="thead-light">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">name</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${categoryList}" var="listOfCategory">
                    <tr>
                        <th scope="row">${listOfCategory.id}</th>
                        <td>${listOfCategory.name}</td>
                        <td>
                            <div id="content" data-bs-toggle="modal" data-bs-target="#category${listOfCategory.id}">
                            <button type="button" class="btn btn-secondary"><i class="bi bi-pencil"></i></button>
                            </div>
                        </td>


                        <td>
                            <form name="deleteCategory" method="post" action='<c:url value="/deleteCategory/${listOfCategory.id}"/>'>
                            <button type="submit" class="btn btn-secondary"><i class="bi bi-trash"></i></button>
                            </form>
                        </td>


                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </section>

</main><!-- End #main -->




<c:forEach items="${categoryList}" var="listOfCategory">
    <!-- Modal -->
    <div class="modal fade" id="category${listOfCategory.id}" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">

            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Change value</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form name="editCategory" method="post" action='<c:url value="/editCategory/${listOfCategory.id}"/>'  modelAttribute="abc">
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-6">

                                <input name="name" value="${listOfCategory.name}">
                            </div>
                            <div class="col-6">
                                <select   name="category" class="form-control" >
                                    <option value="" >wybierz kategorie nadrzedna</option>
                                    <c:forEach items="${categoryList}" var="listOfCategory">
                                        <option value="${listOfCategory.id}">${listOfCategory.name}</option>

                                    </c:forEach>
                                </select>
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