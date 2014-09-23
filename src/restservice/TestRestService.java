package restservice;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

@WebServlet(urlPatterns = {"/testRestServlet"})
public class TestRestService extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Get method called");
        out.println("parameters: " + parameters(request));
        out.println("headers: " + headers(request));
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Post method called");
        out.println("parameters: " + parameters(request));
        out.println("headers: " + headers(request));
    }
    public void doDelete(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Delete method called");
    }
    private String parameters(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        for (Enumeration e = request.getParameterNames() ; e.hasMoreElements();)
        {
            String name = (String)e.nextElement();
            builder.append("|" + name + "->" + request.getParameter(name));
        }
        return builder.toString();
    }
    private String headers(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        for (Enumeration e = request.getHeaderNames() ; e.hasMoreElements();) {
            String name = (String)e.nextElement();
            builder.append("|" + name + "->" + request.getHeader(name));
        }
        return builder.toString();
    }
}
