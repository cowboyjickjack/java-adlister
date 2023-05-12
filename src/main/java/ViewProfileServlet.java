import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the user's input from the login form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // validate the user's input
        if (username.equals("admin") && password.equals("password")) {
            // if the input is valid, redirect the user to the profile page
            response.sendRedirect("/profile");
        } else {
            // if the input is invalid, redirect the user to the login page with an error message
            response.sendRedirect("/login.jsp?error=1");
        }
    }

}
