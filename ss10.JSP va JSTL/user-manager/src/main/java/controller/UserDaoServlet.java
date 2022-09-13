package controller;

import model.User;
import repository.IUserRepository;
import repository.UserRepository;
import service.IUserDaoService;
import service.UserDaoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UserDaoServlet", urlPatterns = {"/users"})
public class UserDaoServlet extends HttpServlet {
    private IUserDaoService userDaoService = new UserDaoService();
    private IUserRepository userRepository = new UserRepository();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "creat":
                insertUser(request,response);
                break;
            case "adjust":
                //
                break;
            case "delete":
                delete(request,response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name,email,country);
        userRepository.insertUser(user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/User/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            case "delete":
                //
                break;
            case "add":
                //
            default:
                showListUser(request,response);
                break;
        }

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/User/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/User/userList.jsp");
        request.setAttribute("userList",this.userDaoService.selectAllUser());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
