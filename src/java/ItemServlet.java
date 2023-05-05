import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/ItemServlet"})
public class ItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String r  = """
                    <!DOCTYPE>
                    <html>
                        <head>
                            <title>Items</title>
                        </head>
                        <body>
                            <p>SUIIIIII</p>
                        </body>
                    </html>
                    """;
        String db = "jdbc:mariadb://localhost/heroes3";
        String reqName = request.getParameter("name");
        String reqPass = request.getParameter("pass");
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn = DriverManager.getConnection(db);
            Statement stmt = conn.createStatement();
            String query = """
                   SELECT * FROM potrebiteli;
                            """;
            ResultSet rs = stmt.executeQuery(query);
            conn.close();
            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String mail = rs.getString(4);
                //response.getWriter().println(id + " " + name + " " + pass); 
                if (reqName.equals(name) && reqPass.equals(pass));
                    response.getWriter().println("vutre si 006");
                    Cookie c = new Cookie("name", name);
                    response.addCookie(c);
                    response.sendRedirect("index.html");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.getWriter().println(r);
        
    }
}
