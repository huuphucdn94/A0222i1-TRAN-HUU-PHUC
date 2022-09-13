<%--
  Created by IntelliJ IDEA.
  User: Phuc
  Date: 9/7/2022
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CREATE PRODUCT</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>


<h4 align="left">ADD NEW PRODUCT</h4>

<a href="/product">list Product</a>
<br>
<C:if test="${mess != null}">
<p style="color: red">${mess}</p>
</C:if>

<form action="/product?action=create" method="post">

    <form >
        <div class="form-group">
            <label >Product Name</label>
            <input type="text" class="form-control" name="name" placeholder="Product Name">
        </div>
        <div class="form-group">
            <label >Price</label>
            <input type="text" class="form-control" name="price"  placeholder="Price">
        </div>
        <div class="form-group">
            <label >Quantity</label>
            <input type="text" class="form-control" name="quantity" placeholder="Quantity">
        </div>
        <div class="form-group">
            <label >Color</label>
            <input type="text" class="form-control" name="color"  placeholder="Color">
        </div>
        <div class="form-group">
            <label >Describe</label>
            <input type="text" class="form-control" name="describe" placeholder="Describe">
        </div>
        <br>
        <div class="form-group">
            <label >Category Type</label>
            <select name="categoryId" id="" >
                <option value="">Select</option>
                <C:forEach items="${categoryList}" var="category">
                    <option value="${category.id}">${category.name}</option>
                </C:forEach>
            </select>

        </div>
        <br>
        <div>
            <button type="submit"   class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Create
            </button>
            <a href="/product">
                <button type="button"  class="btn btn-danger">
                    Back To Product List
                </button>
            </a>
        </div>
    </form>

</form>

</body>
</html>
