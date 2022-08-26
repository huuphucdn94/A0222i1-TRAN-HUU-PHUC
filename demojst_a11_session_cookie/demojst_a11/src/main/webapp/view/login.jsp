<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/3/2022
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<div style="width: 300px;height: 400px;margin-left: 200px">
    <h2>Đăng nhập</h2>
    <form action="/login" method="post">
        <p class="text-danger font-weight-bold font-italic">${messLogin}</p>
        <div class="form-group">
            <label for="exampleInputEmail1">Tên đăng nhập</label>
            <input type="text" name="username" value="${cookie.get("cookieUsername").getValue()}" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp">
            <small id="emailHelp" class="form-text text-muted">
                We'll never share your email with anyone else.
            </small>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" name="password" value="${cookie.get("cookiePassword").getValue()}" class="form-control" id="exampleInputPassword1">
        </div>
        <div class="form-group form-check">
            <input type="checkbox" name="rememberMe" value="true" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Remember Me</label>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
