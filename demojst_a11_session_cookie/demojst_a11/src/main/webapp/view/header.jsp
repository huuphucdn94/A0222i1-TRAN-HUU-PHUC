<%@ page import="model.bean.User" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/20/2022
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--thu vien jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/datatables.bootstrap4.min.css">

    <script src="jquery/jquery-3.6.0.min.js"></script>
    <script src="bootstrap4.6.0/js/bootstrap.min.js"></script>

    <script src="datatables/js/jquery.dataTables.min.js"></script>
    <script src="datatables/js/dataTables.bootstrap4.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/student">Quản lý sinh viên</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
                    Quản lý tài chính
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Chính sách tiền lương</a>
                    <c:if test="${sessionUser.role.equals('ADMIN')}">
                        <a class="dropdown-item" href="#">Bảng lương nhân viên</a>
                    </c:if>

                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Thống kê</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <div class="ml-5">
            <c:if test="${sessionUser!=null}">
                <span class="text-white">${sessionUser.username}</span>
                <a href="/logout">Logout</a>
            </c:if>
            <c:if test="${sessionUser==null}">
                <a href="/login">Login</a>
            </c:if>
<%--            <span class="text-white">--%>
<%--                <%=session.getAttribute("userSession")!=null?((User)session.getAttribute("userSession")).getUsername():""%>--%>
<%--            </span>--%>
<%--            <span class="text-white">--%>
<%--                <%=session.getAttribute("userSession")==null?("<a href='/login'>Login</a>"):("<a href='/logout'>Logout</a>")%>--%>
<%--            </span>--%>

        </div>

    </div>
</nav>
