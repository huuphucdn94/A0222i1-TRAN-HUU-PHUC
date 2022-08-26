<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Phuc
  Date: 8/22/2022
  Time: 6:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<body>
<h1 align="center">Customer list</h1>
<table class="table table-silver">
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>TEN</th>
        <th>NGAY SINH</th>
        <th>DIA CHI</th>
        <th>Id-Img</th>
    </tr>
    <c:forEach var="customer" items="${customerList}" varStatus="customerStatus">
        <tr>
            <td>${customerStatus.count}</td>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.ngaySinh}</td>
            <td>${customer.diaChi}</td>
            <td>
                <c:choose>
                    <c:when test="${customer.idImg == 1}">
                        <img src="https://img4.thuthuatphanmem.vn/uploads/2020/07/05/hinh-anh-background-mang-mau-tam-giac-xanh-trang_034911863.jpg" alt="" style="width: 50px; height: 50px;">
                    </c:when>
                    <c:when test="${customer.idImg == 2}">
                        <img src="https://img4.thuthuatphanmem.vn/uploads/2020/07/05/hinh-anh-background-mang-mau-tam-giac-xanh-trang_034911863.jpg" alt="" style="width: 50px; height: 50px;">
                    </c:when>
                    <c:when test="${customer.idImg == 3}">
                        <img src="https://img4.thuthuatphanmem.vn/uploads/2020/07/05/hinh-anh-background-mang-mau-tam-giac-xanh-trang_034911863.jpg" alt="" style="width: 50px; height: 50px;">
                    </c:when>
                    <c:when test="${customer.idImg == 4}">
                        <img src="https://img4.thuthuatphanmem.vn/uploads/2020/07/05/hinh-anh-background-mang-mau-tam-giac-xanh-trang_034911863.jpg" alt="" style="width: 50px; height: 50px;">
                    </c:when>
                    <c:when test="${customer.idImg == 5}">
                        <img src="https://img4.thuthuatphanmem.vn/uploads/2020/07/05/hinh-anh-background-mang-mau-tam-giac-xanh-trang_034911863.jpg" alt="" style="width: 50px; height: 50px;">
                    </c:when>
                </c:choose>
            </td>

        </tr>
    </c:forEach>
</table>

</head>
</body>
</html>
