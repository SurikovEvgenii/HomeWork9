
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Authorization</title>
</head>
<body>
    <div class="position-absolute top-50 start-50 translate-middle">
        <h1>Авторизуйтесь</h1><br>
            <form method="POST" action="auth-servlet" id="authForm">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Введите логин</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="login">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Введите пароль</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" name="password"><br>
                    <% if(request.getAttribute("authResult")=="false") {%>
                        <p style="color: darkred">Неправильный логин или пароль!</p>
                    <%}%>
                </div><br>
                <button type="submit" class="btn btn-primary" style="align-content: center">Войти</button><br>

            </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
