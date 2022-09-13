package controller;

import modle.Category;
import modle.Product;
import repository.IProductRepository;
import service.ICategoryService;
import service.IProductService;
import service.Impl.CategoryService;
import service.Impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {

    private IProductService productService = new ProductService();
    private ICategoryService categoryService = new CategoryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                addNew(request,response);
                //
                break;
            case "delete":
                delete(request,response);
                break;
        }
    }

    private void addNew(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String describe = request.getParameter("describe");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Product product = new Product(name,price,quantity,color,describe,categoryId);
        Map<String,String> map = productService.add(product);
        String mess = "Add new complete";
        if (!map.isEmpty()){
            mess = "Add new failed";
            request.setAttribute("error",map);
        }
        request.setAttribute("mess", mess);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/createProduct.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int idDelete = Integer.parseInt(request.getParameter("deleteId"));
        boolean check = productService.delete(idDelete);
        String mess = "Delete success";
        if (!check){
            mess = "Delete failed";
        }
        request.setAttribute("mess",mess);
        request.setAttribute("productList",this.productService.findAll());
        request.setAttribute("categoryList",this.categoryService.findListCategory());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/listProduct.jsp");
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
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request,response);
                // thêm mới
                break;
            case "edit":
                //sua
                break;
//            case "delete":
//                // xoá
//                showFormDelete(request,response);
//                break;
            default:
                // trả về trang list
                ShowListProduct(request, response);
                break;
        }

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = categoryService.findListCategory();
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/createProduct.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.findAll();
        List<Category> categoryList = categoryService.findListCategory();
        request.setAttribute("productList",productList);
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/listProduct.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



