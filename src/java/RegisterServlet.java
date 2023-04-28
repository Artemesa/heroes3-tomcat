import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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

@WebServlet(urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String r  = """
                    <!DOCTYPE>
                    <html>
                        <head>
                            <title>Resgister</title>
                        </head>
                        <body>
                            <p>SUIIIIII</p>
                        </body>
                    </html>
                    """;
        String db = "jdbc:mariadb://localhost/heroes3";
        String reqName;
        String reqPass;
        String reqMail;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn = DriverManager.getConnection(db);
            Statement stmt = conn.createStatement();
            String query = """
                   INSERT INTO potrebiteli(name, pass, mail)
                   VALUES (\"rtyu\", \"wer\", \"sdfg\");
                            """;
            ResultSet rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.getWriter().println(r);
        
    }
}
