<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/15/2022
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh SACH SAN PHAM</title>
</head>
<body>
<center>
    <h1>DANH SACH SAN PHAM</h1>
    <h2>
        <a href="/sanPham?action=create" >THEM SAN PHAM MOI</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>PRODUCT LIST</h2></caption>
        <tr>
            <th>ID</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        <c:forEach var="user" items="${listSanPham}">
            <tr>
                <td><c:out value="${user.idSanPham}"/></td>
                <td><c:out value="${user.ten}"/></td>
                <td><c:out value="${user.gia}"/></td>
                <td><c:out value="${user.soLuong}"/></td>
                <td><c:out value="${user.mauSac}"/></td>
                <td><c:out value="${user.moTa}"/></td>
                <td><c:out value="${user.danhMuc}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.idSanPham}">Edit</a>
                    <a href="/users?action=delete&id=${user.idSanPham}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
