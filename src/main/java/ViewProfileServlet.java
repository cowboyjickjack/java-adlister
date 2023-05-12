import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // TO ENSURE USER CAN'T GO TO /profile via the URL
        boolean isLoggedIn = session.getAttribute("username") != null;
        if (!isLoggedIn){
            response.sendRedirect("/login");
            return;
        }
        // LECTURE EXAMPLE
//        String user = (String) session.getAttribute("username");
//        System.out.println(user + " just logged in.");
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }
}
