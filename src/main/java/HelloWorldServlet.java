import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

    private int hitCount = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1> Hello, World! </h1>");

        // Page Counter
        String title = "Total Number of Hits";

        hitCount++;

        out.println("<h3> Current Page Count: " + hitCount);

        // Input If/Else
        if (name != null) {
            out.println("<h3> Hello, " + name + "!</h3>");
        } else {
            out.println("<h3>Hey, what's your name?</3>");
        }
    }

}

