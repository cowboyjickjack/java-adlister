import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guess")
public class GuessingServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/guess.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int number = Integer.parseInt(req.getParameter("number"));
        req.setAttribute("number", number);
//        req.getRequestDispatcher("/guess.jsp").forward(req, resp);
        if (number == 2) {
            resp.sendRedirect("/correct.jsp");
        } else if (number == 1 || number == 3) {
            resp.sendRedirect("/incorrect.jsp");
        } else if (number > 3){
            resp.sendRedirect("/guess.jsp");
        } else if (number < 0){
            resp.sendRedirect("/guess.jsp");
        }
    }

}
