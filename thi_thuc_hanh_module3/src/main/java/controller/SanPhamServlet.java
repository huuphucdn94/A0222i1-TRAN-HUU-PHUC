package controller;

import model.SanPham;
import repository.SanPhamRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SanPhamServlet",urlPatterns = "/sanPham")

public class SanPhamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SanPhamRepository sanPhamRepository;

    public void init(){
        sanPhamRepository = new SanPhamRepository();
    };


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action ="";
        }
        switch (action){
            case "create":
                insertSanPham(request,response);
                break;
            case "edit":
                updateSanPham(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteSanPham(request, response);
                break;
            default:
                listSanPham(request, response);
                break;
        }
    }

    private void listSanPham(HttpServletRequest request, HttpServletResponse response) {
        List<SanPham> listUser = sanPhamRepository.selectAllSanPham();
        request.setAttribute("listSanPham",listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteSanPham(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            sanPhamRepository.deleteSanPham(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<SanPham> sanPhamList = sanPhamRepository.selectAllSanPham();
        request.setAttribute("listSanPham", sanPhamList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        SanPham existingUser = sanPhamRepository.selectSanPham(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        request.setAttribute("user",existingUser);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateSanPham(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id_san_pham"));
        String ten = request.getParameter("ten_san_pham");
        int gia = Integer.parseInt(request.getParameter("gia_san_pham"));
        int soLuong = Integer.parseInt(request.getParameter("so_luong_san_pham"));
        String mauSac = request.getParameter("mau_sac_san_pham");
        String moTa = request.getParameter("mo_ta_san_pham");
        String danhMuc = request.getParameter("danh_muc");

        request.setAttribute("mess","Cap nhat thanh cong");
        SanPham sanPham = new SanPham(id, ten, gia, soLuong,mauSac,moTa,danhMuc);
        try {
            sanPhamRepository.updateSanPham(sanPham);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void insertSanPham(HttpServletRequest request, HttpServletResponse response) {
        String ten = request.getParameter("ten_san_pham");
        String gia = request.getParameter("gia_san_pham");
        String soLuong = request.getParameter("so_luong_san_pham");
        String mauSac = request.getParameter("mau_sac_san_pham");
        String moTa = request.getParameter("mo_ta_san_pham");
        String danhMuc = request.getParameter("danh_muc");
        SanPham sanPham = new SanPham(ten, gia, soLuong,mauSac,moTa,danhMuc);
        try {
            sanPhamRepository.insertSanPham(sanPham);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
