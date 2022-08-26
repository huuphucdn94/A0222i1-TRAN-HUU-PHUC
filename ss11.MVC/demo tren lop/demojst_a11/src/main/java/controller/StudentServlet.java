package controller;

import model.bean.ClassCG;
import model.bean.Student;
import model.service.IStudentService;
import model.service.impl.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controller.StudentServlet",urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    // gọi service
    IStudentService studentService = new StudentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                // lưu dữ liệu
                save(request,response);
                break;
            case "edit":
                // chỉnh sửa
                break;
            case "delete":
                // xóa
            default:


        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        boolean gender =Boolean.parseBoolean(request.getParameter("gender"));
        String birthday =request.getParameter("birthday");
        int point =Integer.parseInt(request.getParameter("point"));
        String account =request.getParameter("account");
        int classId=Integer.parseInt(request.getParameter("classId"));
        String email = request.getParameter("email");
        Student student =new Student(id,name,gender,birthday,point,account,classId,email);
        studentService.save(student);
        try {
            response.sendRedirect("/student");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                // trả về một form để điền dữ liệu
                showFormCreate(request,response);
                // code thêm mới
                break;
            case "edit":
                // chỉnh sửa
                break;
            case "delete":
                // xóa
            default:
                // trả về trang list
                showListStudent(request,response);


        }

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/student/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListStudent(HttpServletRequest request, HttpServletResponse response) {
        List<Student> studentList = studentService.getAllStudent();
        request.setAttribute("studentList", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/student/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
