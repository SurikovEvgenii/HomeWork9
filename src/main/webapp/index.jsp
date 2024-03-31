<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <title>JSP - Hello World</title>
</head>
<body style="padding: 100px">

<h1>Считаем количество вопросительных предложений!</h1><br/>

    <form action="text-servlet" method="POST">
      <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">Введите текст для проверки</label>
        <textarea class="form-control" id="exampleFormControlTextarea1" rows="4" maxlength="5000" name="text"></textarea>
      </div>
      <button type="submit" class="btn btn-primary" style="align-content: center">Поверить</button><br>
    </form>
<br>
<p><b>Количество вопросительных предложений:</b> ${requestScope.get("counter")}</p>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>