import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        float op1 = Float.parseFloat(request.getParameter("op1"));
        float op2 = Float.parseFloat(request.getParameter("op2"));
        String operator = request.getParameter("operator");

        Calculator calculator = new Calculator();
        try{
            float result = calculator.calculate(op1,op2,operator);

            request.setAttribute("op1",op1);
            request.setAttribute("op2",op2);
            request.setAttribute("operator",operator);
            request.setAttribute("result",result);
            RequestDispatcher dispatcher = request.getRequestDispatcher("calculate.jsp");
            dispatcher.forward(request,response);
        }catch (ArithmeticException e) {
            PrintWriter writer = response.getWriter();
            writer.println("<h1 style=\"color:red;\">/by zero<h1>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
