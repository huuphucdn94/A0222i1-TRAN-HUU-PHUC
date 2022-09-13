<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Phuc
  Date: 9/4/2022
  Time: 10:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListProduct</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<h2 align="center">Product List</h2>
<a href="/product?action=create">Add New User</a>
<br>
<C:if test="${mess!= null}">
    <span style="color: #ff0000">${mess}</span>
</C:if>
<div>
    <table class="table table-silver">
        <tr>
            <th>ID</th>
            <th>Product Name</th>
            <th>Price ($)</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        <C:forEach var="product" items="${productList}" >
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.quantity}</td>
                <td>${product.color}</td>
                <c:forEach var="category" items="${categoryList}">
                    <C:if test="${product.categoryId == category.id}">
                            <td>${category.name}</td>
                    </C:if>
                </c:forEach>

                <td>
                    <button type="button" onclick="deleteInfo('${product.id}','${product.name}')"  class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        Delete
                    </button>
                    <a href="/product?action=edit&id=${product.id}">
                        <button type="button"  class="btn btn-danger">
                            Edit
                        </button>
                    </a>
                </td>
            </tr>
        </C:forEach>
    </table>
</div>

<%--modan--%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <%--            ---------thêm thẻ form - chu y phuong thuc get or pot---------%>
        <form action="/product" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Xac nhan xoa</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" hidden name="deleteId" id="deleteId">
                    <input hidden name="action" value="delete">
                    <span>Bạn có muốn xoá sản phẩm </span><span id="deleteName"></span><span> Không?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">OK</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function deleteInfo(id,name) {
        document.getElementById("deleteId").value=id;
        document.getElementById("deleteName").innerText=name;
    }

</script>
</body>
</html>
