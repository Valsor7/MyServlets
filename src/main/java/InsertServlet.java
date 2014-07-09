import javax.jms.Session;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class InsertServlet extends HttpServlet {


    private MyDBHelper helper;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        helper = new MyDBHelper();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration data = request.getParameterNames();
        ArrayList<String> paramsArr = new ArrayList<String>();
        while (data.hasMoreElements()){
            String paramName = (String) data.nextElement();
            paramsArr.add(request.getParameter(paramName));
        }
        List list = helper.get((String) request.getParameter("email"), null);
        if (list.size() == 0){
            helper.insert(paramsArr);
            request.getRequestDispatcher("status.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("registrFailed.jsp").forward(request, response);
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
