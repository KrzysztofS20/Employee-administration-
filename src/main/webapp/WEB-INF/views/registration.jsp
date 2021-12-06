<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Please create account</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
    <link id="chromealerabat-link" rel="stylesheet" type="text/css"
          href="chrome-extension://dacdinoicboceafielngnmjjplncljhj/content.css">
</head>
<body>
<div class="container">

    <form name="createUser" method="post" action='<c:url value="/createUser"/>'>
        <h2>Create account</h2>
        <p>
            <label for="personname" class="sr-only">Username</label>
            <input type="text" id="personname" name="personName" class="form-control" placeholder="Username" required=""
                   autofocus="">
        </p>
        <p>
            <label for="surname" class="sr-only">Surname</label>
            <input type="text" id="surname" name="surName" class="form-control" placeholder="Surname" required=""
                   autofocus="">
        </p>
        <p>
            <label for="email" class="sr-only">Email</label>
            <input type="text" id="email" name="email" class="form-control" placeholder="Email" required=""
                   autofocus="">
        </p>
        <p>
            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password"
                   required="">
        </p>
        <p>
            <label for="phone" class="sr-only">Phone</label>
            <input type="text" id="phone" name="phoneNumber" class="form-control" placeholder="Phone number" required=""
                   autofocus="">
        </p>
        <div>
            <button type="submit">Create</button>
        </div>
    </form>
</div>
</body>
</html>