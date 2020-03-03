import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/sinscrire")
public class InscriptionClient extends HttpServlet {

    private String name ;
    private String lastname ;
    private String email ;
    private String password;
    private int i=0;

    boolean identique (String recu, String cookie) {
        return ((recu != null) && (recu.length() >3) && (cookie != null) && (recu.equals(cookie) ));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException {
        HttpSession session = request.getSession(true);
        String nomRecu = request.getParameter("nom"), motPasseRecu = request.getParameter("motdepasse");;
        String nomCookie =(String) session.getAttribute("nom"), motPasseCookie = (String) session.getAttribute("motdepasse");
// initialisation cookies et paramètres
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        session.setAttribute("nom",nomRecu);
        session.setAttribute("motdepasse",motPasseRecu);



        if (nomCookie == null && nomRecu == null) {

// Cas 1 : cas où il n'y a ni de cookies ni de parametres
            out.println("<html>");
            out.println("<body align = 'center'>");
            out.println("<head>");
            out.println("<title> Welcome USER </title>");
            out.println("</head>");
            out.println("<body bgcolor='white' >");
            out.println(nomRecu + " | " + motPasseRecu + " | " + nomCookie + " | " + motPasseCookie);
            out.println("<h3>" + "Salut dans le 1er CAS</h3>");
            out.println("<h3>" + "Attention mettre nom et le mot de passe avec plus de 3 caracteres" + "</h3>");
            out.print(" <form action='sinscrire' method='GET' > ");
            out.println("nom");
            out.println("<input type='text' size='20' name='nom' >");
            out.println("<br>");
            out.println("mot de passe");
            out.println("<input type='password' size='20' name='motdepasse'> <br>");
            out.println("<input type='submit' value='inscription'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            nomRecu=request.getParameter("nom");
            motPasseRecu=request.getParameter("motdepasse");

            String url = response.encodeURL(request.getContextPath()+"/formulaire");
        } else if (nomCookie==null && nomRecu != null){
            i++;
            String nomRecu2 = request.getParameter("nom"), motPasseRecu2 = request.getParameter("motdepasse");;
            String nomCookie2 =(String) session.getAttribute("nom"), motPasseCookie2 = (String) session.getAttribute("motdepasse");
            System.out.println("TRUE");
            out.println("<HTML>" +
                            "<BODY>\n" +
                            "<H1 ALIGN=CENTER>" + "Salut dans le 2eme CAS</H1><br>" +
                            "<div align=\"center\"><h2>Your information : </h2>"+
                            "<L1><B>Nom:" +nomRecu2+ "<br>" +
                            "<L1><B>Mot de passe:" +motPasseCookie2+ "<br>" +
//                            "<a href="+url+" >Click</a>"+
                            "</div>" + "\n" +
                            "</BODY>" +
                            "</HTML>"
            );
            log("----------------------------INFO "+i+"------------------------------");
            log( " le nom Recu : "+ session.getAttribute("nom"));
            log( " mot de passe Recu : "+ session.getAttribute("motdepasse"));
            log( " Cookie : "+ session.getId());
            log( " name Cookie : "+ nomCookie2);
            log( " pass Cookie : "+ motPasseCookie2 );
            log("----------------------------END------------------------------");

        }
        else if (identique(nomRecu,nomCookie) && identique(motPasseRecu,motPasseCookie))
        {
            i++;
            String nomCookie2 =(String) session.getAttribute("nom"), motPasseCookie2 = (String) session.getAttribute("motdepasse");

            System.out.println("TRUE");
            out.println("<HTML>" +
                            "<BODY>\n" +
                            "<H1 ALIGN=CENTER>Salut dans le 3eme CAS</H1><br>" +
                            "<div align=\"center\"><h2> les informations est identique : </h2>"+
                            "<L1><B>Nom:" + nomCookie2 + "<br>" +
                            "<L1><B>Mot de passe:" + motPasseCookie2 + "<br>" +
//                            "<a href="+url+" >Click</a>"+
                            "</div>" + "\n" +
                            "</BODY>" +
                            "</HTML>"
            );        }
        else {
            i++;
            System.out.println("TRUE");
            out.println("<HTML>" +
                            "<BODY>\n" +
                            "<H1 ALIGN=CENTER>Salut dans le CAS 4 </H1><br>" +
                            "<div align=\"center\"><h2>Your information : </h2>"+
                            "<L1><B>NOTHING TO SHOWN<br>" +
                            "</div>" + "\n" +
                            "</BODY>" +
                            "</HTML>"
            );
        }
        }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {



    }







}
