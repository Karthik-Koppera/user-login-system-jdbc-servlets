import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
    {

        response.setContentType("text/html");

        try {
            PrintWriter out = response.getWriter();
        // extract and save form inputs into the variables.
            String email = request.getParameter("email");
            String password = request.getParameter("password");


         // database connectivity
             String driver = "com.mysql.cj.jdbc.Driver";
             String url = "jdbc:mysql://localhost:3306/userdb";
             String uname = "root";
             String pwd = "root";

            Class.forName(driver);

            Connection con = DriverManager.getConnection(url, uname, pwd);

            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                out.println("<center><body style=\"margin-top:200px;\"><h2>Welcome, " + rs.getString("name") + "!</h2></body><center>");
                out.println("<center><body style=\"margin-top:200px;\"><a href='login.html'>Logout</a></body><center>");
            } else {
                out.println("<center><body style=\"margin-top:200px;\"><h3>Invalid Email or Password!</h3></body></center>");
                out.println("<center><body style=\"margin-top:200px;\"><a href='login.html'>Try Again</a></body></center>");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
