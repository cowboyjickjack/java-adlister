import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="PageCounter", urlPatterns = "/pagecount")
public class PageCounter extends HttpServlet {

    private int hitCount;

    public void  init(FilterConfig config) throws ServletException {
        // Reset hit counter.
        hitCount = 0;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String title = "Total Number of Hits";

        hitCount++;

        out.println("<h3> Current Page Count: " + hitCount);

    }
}
