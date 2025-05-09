package servelets;
import util.DBConnection;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/testServelet")
public class testServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
	            Connection conn = DBConnection.getInstance().getConnection();
	            PreparedStatement st = conn.prepareStatement("SELECT firstName,lastName FROM register LIMIT 1");
	            ResultSet rs = st.executeQuery();
	            
	            String username = "";
	            String lastName = "";
	            if(rs.next()) {
	                username = rs.getString("firstName");
	                lastName = rs.getString("lastName");
	            }
	            
	            request.setAttribute("user", username); 
	            request.setAttribute("lastName",lastName); 
	            
	            // Send to JSP
	            request.getRequestDispatcher("/WEB-INF/Views/Admin/test.jsp").forward(request, response);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
