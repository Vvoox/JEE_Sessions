import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/SimpleServlet")
public class SimpleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomRecu = request.getParameter("nom"), motPasseRecu = request.getParameter("motdepasse");
        String nomCookie = null, motPasseCookie = null;
        PrintWriter out = response.getWriter();
        out.println("<HTML>" +
                        "<BODY>\n" +
                        "<H1 ALIGN=CENTER>" + "Hello " + nomRecu + "</H1><br>" +
                        "<div align=\"center\"><h2>Your information : </h2>" +
                        "<L1><B>username:" + nomRecu + "<br>" +
                        "<L1><B>password:" + motPasseRecu + "<br>" +
//                            "<a href="+url+" >Click</a>"+
                        "</div>" + "\n" +
                        "</BODY>" +
                        "</HTML>"
        );
        }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nomRecu =null, motPasseRecu = null;
        String nomCookie = null, motPasseCookie = null;
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        session.setAttribute("name ", nomRecu);
        session.setAttribute("password ", motPasseRecu);
        String url = response.encodeURL(request.getContextPath() + "/HOME");
        PrintWriter out = response.getWriter();
        String title = "Simple Servlet Output";
        response.setContentType("text/html");
        String token = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                log("Your current cookie is : " + cookie.getName() + " : " + cookie.getValue());
                token = cookie.getValue();
            }
        }

        out.println("<HTML>" + "<HEAD>" + "<title>Home</title>" + "</HEAD>" +
                    "<BODY>\n" +
                    "<div align=\"center\"><h1>login in</h1>" +
                    "<form  method=\"post\" name=\"login form\" align=\"center\">" +
                    "<table align=\"center\" width=\"232\" border=\"2\">\n" +
                    "<tr>\n" +
                    "<td>Username</td>\n" +
                    "<td><input type=\"text\" name=\"nom\"></td>" +
                    "</tr>" + "\n" +
                    "<tr>\n" +
                    "<td>Password</td>\n" +
                    "<td><input type=\"password\" name=\"motdepasse\"></td>" +
                    "</tr>" + "\n" +
                    "</table>\n" +
                    "<input type=\"submit\" value=\"Submit\" name=\"Submit\">\n" +
                    "</form>\n" +
                    "</form>" +
                    "</div>" +
                    "</BODY>" +
                    "</HTML>"
            );
            out.close();

    }
}
