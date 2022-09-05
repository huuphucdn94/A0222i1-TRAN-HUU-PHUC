import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DSKHcontroller", urlPatterns = "/")
public class DSKHcontroller extends HttpServlet {
    public static List<KhachHang> danhSachKhachHang = new ArrayList<>();
    public void init() {
        danhSachKhachHang.add(new KhachHang("Mai Văn Hoàn","20/08/1983","Hà Nội","https://img4.thuthuatphanmem.vn/uploads/2020/07/05/hinh-anh-background-mang-mau-tam-giac-xanh-trang_034911863.jpg"));
        danhSachKhachHang.add(new KhachHang("Nguyễn Văn Nam","21/08/1983","Đà Nẵng","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOZskxzbZ_boL3pQrY9Vjhk7xW1KfyFVzPzQ&usqp=CAU"));
        danhSachKhachHang.add(new KhachHang("Nguyễn Thái Hòa","22/08/1983","Sài Gòn","https://img.freepik.com/free-vector/hand-painted-background-violet-orange-colours_23-2148427578.jpg?w=2000"));
        danhSachKhachHang.add(new KhachHang("Trần Đăng Khoa","23/08/1983","Đà Lạt","https://img2.thuthuatphanmem" +
                ".vn/uploads/2018/12/30/background-dep-ppt_110341618.jpg"));
        danhSachKhachHang.add(new KhachHang("Nguyễn Đình Thi","24/08/1983","Vũng Tàu","https://nghialagi" +
                ".org/wp-content/uploads/2020/03/background-la-gi.jpg"));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ds",danhSachKhachHang);
        RequestDispatcher dispatcher = request.getRequestDispatcher("danhSach.jsp");
        dispatcher.forward(request,response);
    }
}
