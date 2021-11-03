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
                    <h2>Add new product</h2>
                    <form name="addProduct" method="post" action="addProduct">
                        <div class="row">
                            <div class="col-4" style="margin-bottom: 10px">
                                <input name="name" class="form-control" type="text" placeholder="Nazwa produktu">
                            </div>
                            <div class="col-4" style="margin-bottom: 10px">
                                <input name="description" class="form-control" type="text" placeholder="Opis produktu">
                            </div>
                            <div class="col-4" style="margin-bottom: 10px">
                                <input name="price" class="form-control" type="text" placeholder="Cena produktu">
                            </div>
                            <div class="col-4" style="margin-bottom: 10px">
                                <select name="author" class="form-control">
                                    <option value="">select an author</option>
                                    <c:forEach items="${authorList}" var="author">
                                        <option value="${author.id}">${author.name} ${author.surname}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-4" style="margin-bottom: 10px">
                                <select name="category" class="form-control">
                                    <option value="">select categories</option>
                                    <c:forEach items="${categoryList}" var="category">
                                        <option value="${category.id}">${category.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-4" style="margin-bottom: 10px">
                                <input name="photo" class="form-control" type="text" placeholder="zdjecie">
                            </div>

                        </div>
                        <button type="submit" class="btn btn-dark">Add</button>
                    </form>
                </div>

            </div>
            <nav id="navbar" class="navbar">
                <ul>
                    <li class="dropdown"><a><span>The current category tree</span> <i
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
    </section><!-- End About Section -->

    <section>
        <div class="container">
            <table class="table">
                <thead class="thead-light">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Category</th>
                    <th scope="col">Price</th>
                    <th scope="col">Author</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${productsList}" var="product">
                    <tr>
                        <th scope="row">${product.id}</th>
                        <td>${product.name}</td>
                        <td>${product.category.name}</td>
                        <td>${product.price}</td>
                        <td>${product.author.name} ${product.author.surname}</td>
                        <td>
                            <div id="content" data-bs-toggle="modal" data-bs-target="#product${product.id}">
                                <button type="button" class="btn btn-secondary"><i class="bi bi-pencil"></i></button>
                            </div>
                        </td>


                        <td>
                            <form name="deleteProduct" method="post"
                                  action='<c:url value="/deleteProduct/${product.id}"/>'>
                                <button type="submit" class="btn btn-secondary"><i class="bi bi-trash"></i></button>
                            </form>
                        </td>


                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </section>

    <c:forEach items="${productsList}" var="product">
        <!-- Modal -->
        <div class="modal fade" id="product${product.id}" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">

                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Change value</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form name="editProduct" method="post" action='<c:url value="/editProduct/${product.id}"/>'>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-6"><p>Name</p></div>
                                <div class="col-6"><p>Description</p></div>
                            </div>
                            <div class="row" style="margin-bottom: 10px">
                                <div class="col-6">
                                    <input name="name" value="${product.name}">
                                </div>
                                <div class="col-6">
                                    <input name="description" value="${product.description}">
                                </div>
                            </div>
                            <div class="row" s>
                                <div class="col-6"> <p>Price</p></div>
                                <div class="col-6"><p>Category</p></div>
                            </div>
                            <div class="row" style="margin-bottom: 10px">
                                <div class="col-6">
                                    <input name="price" value="${product.price}">
                                </div>
                                <div class="col-6">
                                    <select name="category" class="form-control">
                                        <option value="${product.category.id}">${product.category.name}</option>
                                        <c:forEach items="${categoryList}" var="category">
                                            <option value="${category.id}">${category.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6"> <p>Photo</p></div>
                                <div class="col-6"><p>Author</p></div>
                            </div>
                            <div class="row" style="margin-bottom: 10px">
                                <div class="col-6">
                                    <input name="photo" value="${product.photo}">
                                </div>
                                <div class="col-6">
                                    <select name="author" class="form-control">
                                        <option value="${product.author.id}">${product.author.name} ${product.author.surname}</option>
                                        <c:forEach items="${authorList}" var="author">
                                            <option value="${author.id}">${author.name}</option>
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