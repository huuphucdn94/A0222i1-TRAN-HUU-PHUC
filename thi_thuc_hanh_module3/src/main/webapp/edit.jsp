<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/17/2022
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User Management</h1>
<h2>
    <a href="/abc">List All Users</a>
</h2>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <p>${mess}</p>
            <caption>
                <h2>
                    Edit User
                </h2>
            </caption>
            <c:if test="${sanpham != null}">
                <input type="hidden" name="id" value="<c:out value='${sanpham.idSanPham}' />"/>
            </c:if>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${sanpham.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${sanpham.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="<c:out value='${user.country}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
