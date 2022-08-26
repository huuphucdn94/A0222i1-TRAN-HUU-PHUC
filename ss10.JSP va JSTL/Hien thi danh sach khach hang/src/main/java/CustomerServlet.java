
import modle.Customer;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    private static List<Customer> customerList = new ArrayList<>();
//    private List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer(1,"PHUC","1/1/2020","Da Nang",1));
        customerList.add(new Customer(2,"CHIEN","1/1/2020","Hue",2));
        customerList.add(new Customer(3,"BINH","3/3/2020","Quang Nam",3));
        customerList.add(new Customer(4,"TIEN","4/4/2020","Quang Tri",4));
        customerList.add(new Customer(5,"CHIEN","2/2/2020","Ha Noi",5));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/listCustomer.jsp");
        request.setAttribute("customerList",customerList);
        requestDispatcher.forward(request,response);
    }
}
