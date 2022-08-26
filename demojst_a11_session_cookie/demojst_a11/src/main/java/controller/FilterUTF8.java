package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FilterUTF8",urlPatterns = "/*")
public class FilterUTF8 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        chain.doFilter(req, resp);

        HttpServletRequest request = (HttpServletRequest)req; // ép kiểu
        // lấy đường dẫn request
        String uriLogin = request.getRequestURI();
        System.out.println(uriLogin);
        HttpServletResponse response = (HttpServletResponse) resp;// ép kiểu
        // lấy session
        HttpSession session = request.getSession();
        if (uriLogin.equals("/login")||session.getAttribute("sessionUser")!=null){
            chain.doFilter(req, resp);
        } else {
            request.getRequestDispatcher("/login").forward(request,response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
