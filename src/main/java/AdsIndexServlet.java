import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.getRequestDispatcher("/ads/index.jsp").forward(request, response);

        // COOKIES!
        HttpSession session = request.getSession();
        // first argument = KEY, second argument = VALUE
        session.setAttribute("language", "en-us");
        // can now access at any point in the session, almost 'global;

        // HOW TO KILL ALL SESSIONS
        // Used when a user logs out, or delete a profile
        session.invalidate();
    }
}
