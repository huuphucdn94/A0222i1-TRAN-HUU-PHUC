package controller;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserController",urlPatterns = "/controller")
class UserController extends HttpServlet {
    private  static final long serialVersionUID = 1L;
    private static UserDAO userDAO = new UserDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createUser(request,response);
                break;
            case "edit":
                editUser(request,response);
                break;
            case "delete":
                deleteUSer(request,response);
                break;
        }

    }

    private void deleteUSer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
//            userDAO.deleteUser(id);
            userDAO.spDeleteUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/controller");
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(id,name,email,country);
        try {
//            userDAO.updateUser(user);
            userDAO.spUpdateUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        response.sendRedirect("/controller");

    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(name,email,country);
        try {
//            userDAO.insertUser(user);
            userDAO.insertUserStore(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        response.sendRedirect("/controller");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showNewForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                confirmDelete(request,response);
                break;
            case "Search":
                selectByCountry(request,response);
                break;
            case "order":
                orderByName(request,response);
                break;
            case "view":
                viewUser(request,response);
                break;
            case "permission":
                addUserPermission(request,response);
                break;
            case "test-without-transaction":
                testWithoutTransaction(request,response);
                break;
            case "test-with-transaction":
                testWithTransaction(request,response);
                break;
            default:
                listUser(request,response);
                break;
        }

    }

    private void testWithTransaction(HttpServletRequest request, HttpServletResponse response) {
        userDAO.insertUpdateUseTransaction();
    }

    private void testWithoutTransaction(HttpServletRequest request, HttpServletResponse response) {
        userDAO.insertUpdateWithoutTransaction();
    }

    private void addUserPermission(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("an","quan.nguyen@codegym.vn","VN");
        int[] permissions = {1,2,4};

        userDAO.addUserTransaction(user,permissions);
    }

    private void viewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.selectUser(id);

        request.setAttribute("user",user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/view.jsp");
        dispatcher.forward(request,response);
    }

    private void orderByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String asc_desc = request.getParameter("choose");
        List<User> userList = new ArrayList<>();


        try{
            userList = userDAO.sortByName(asc_desc);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("userList",userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request,response);

    }

    private void selectByCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchCountry = request.getParameter("searchCountry");
        List<User> userList = new ArrayList<>();
        try {
            userList = userDAO.searchByCountry(searchCountry);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("userList",userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request,response);

    }

    private void confirmDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.selectUser(id);

        request.setAttribute("user",user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/deleteConfirm.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("id",id);
//        User user = userDAO.selectUser(id);
        User user = userDAO.getUserById(id);

        request.setAttribute("user",user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/editForm.jsp");
        dispatcher.forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/newForm.jsp");
        dispatcher.forward(request,response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<User> userList = userDAO.selectAllUser();
        List<User> userList = userDAO.spSelectUsers();

        request.setAttribute("userList",userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request,response);
    }


}