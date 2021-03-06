import javax.jms.Session;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yaroslav on 09.07.14.
 */
public class LoginServlet extends HttpServlet {
    private MyDBHelper helper;
    private String status;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        helper = new MyDBHelper();
        status = "You entered wrong email or password. Try again";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        List list = helper.get((String) request.getParameter("email"),
                               (String) request.getParameter("pass"));
        if (list.size() == 0){
            request.setAttribute("status", status);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else {
            String user = (String) list.get(0);
            session.setAttribute("list", list);
            session.setAttribute("user", user);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            helper.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
