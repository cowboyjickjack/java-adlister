import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
        HttpSession session = request.getSession();
        String language = (String) session.getAttribute("language");
        // need to specify how it's coming back,
        // as a STRING
        System.out.println("Language preference: " + language);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(); // to start session
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("password") || username.equals("cowboyjickjack") && password.equals("password");

        if (validAttempt) {
            // now we're customizing session data, that is specific to the user, like their username
            // and we can save whatever data we need on a user using conditional logic
            session.setAttribute("username", username);
            session.removeAttribute("language");
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
