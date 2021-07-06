

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mypack.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductServ
 */
@WebServlet("/ProductServ")
public class ProductServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	public void init()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mydb";
			con=DriverManager.getConnection(url,"root","1234");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	Product p1 = new Product();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			PreparedStatement pst=con.prepareStatement("insert into Product values(?,?,?,?)");
			p1.setId(3);
			p1.setName("Eraser");
			p1.setPrice(2.50);
			p1.setQty(26);
			pst.setInt(1,p1.getId());
			pst.setInt(4,p1.getQty());
			pst.setDouble(3,p1.getPrice());
			pst.setString(2,p1.getName());
			pst.execute();
			PrintWriter pw=response.getWriter();
			
			Product p2=new Product();
			ResultSet rs=pst.executeQuery("select * from product");
			
			while(rs.next())
			{
				p2.setId(rs.getInt(1));
				p2.setName(rs.getString(2));
				p2.setPrice(rs.getDouble(3));
				p2.setQty(rs.getInt(4));
				pw.println(p2);
				pw.println("<br>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
