import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// must extend HttpServlet to achieve 'servlet-tude'

@WebServlet("/welcome") // url pattern. This class will get instantiated when the url = /welcome
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String car = req.getParameter("car");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        if (car != null) {
            out.println("<h3>Your " + car + " is awesome!</h3>");
        } else {
            out.println("<h3> Tell me about your car! </h3>");
        }
        // This is sending query strings to a get request
        // welcome?car=Hyundai+Elantra+GT --->>> would be at the end of the 8080 url
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h2>Welcome, " + username + "!</h2>");

    }
}

