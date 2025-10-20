import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet 
{
    public void service(HttpServletRequest request, HttpServletResponse response)
    {

        response.setContentType("text/html");

        // Get the input from the HTML forms and store in variables

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        PrintWriter out = null;
        // Database connectivity
        try {
            out  = response.getWriter();

            String driver="com.mysql.cj.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/userdb";
            String uname = "root"; 
            String pwd = "root"; 

            // step-1: Register with a driver
                Class.forName(driver);

            // step-2: Get a connection
            Connection con = DriverManager.getConnection(url, uname,pwd);

            // step-3: create a statement object
            String qry = "insert into users(name,email,password) values(?,?,?)";
            PreparedStatement stmt = con.prepareStatement(qry);

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            // step-4: Execute the queries
                int result = stmt.executeUpdate();
            if (result > 0) {
                out.println("<center><body style=\"margin-top:200px;\"><h2>Registration Successful!</h2></body><center>");
                out.println("<center><body style=\"margin-top:200px;\"><a href='login.html'>Login Here</a></body><center>");
            } else {
                out.println("<center><body style=\"margin-top:200px;\"><h3>Registration Failed!</h3></body><center>");
            }
            // step-5: close the connection
                con.close();
        }
        catch(Exception e)
        {
            out.println("<center><body style=\"margin-top:200px;\"><h2>User already registered! please login <h2></body><center>");
            out.println("<center><body style=\"margin-top:200px;\"><a href='login.html'>Login</a></body><center>");
        }
    }
}
