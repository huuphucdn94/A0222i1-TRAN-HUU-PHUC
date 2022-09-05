<%--
  Created by IntelliJ IDEA.
  User: Phuc
  Date: 9/4/2022
  Time: 11:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  < <head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  </head>
  <body>
  <form class="col-md-3" method="post" action="/calculate">
    <div class="mb-3">
      <label for="op1" class="form-label">First Operand</label>
      <input type="number" class="form-control" id="op1" name="op1">
    </div>
    <div class="mb-3">
      <label for="operator" class="form-label">Operator</label>
      <select id="operator" name="operator">
        <option>+</option>
        <option>-</option>
        <option>x</option>
        <option>:</option>
      </select>
    </div>
    <div class="mb-3 form-check">
      <label for="op2" class="form-label">Second Operand</label>
      <input type="number" class="form-control" id="op2" name="op2">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
  </body>
</html>
