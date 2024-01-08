package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserInterfaceDao;
import com.sunbeam.pojo.UserPojo;

@WebServlet("/login")

public class LoginServlet extends HttpServlet{

	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			String username=req.getParameter("email");
			String password=req.getParameter("password");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>LoginCheck</title>");
			out.println("<head>");
			out.println("<body>");
			
			try(UserDao userDao=new UserDao())
			{
				UserPojo user=userDao.findByEmail(username);
				if(user != null && user.getPassword().equals(password) )
				{
					out.printf("<h1>Welcome %s %s </h1>",user.getFirstName(),user.getLastName());
					System.out.println("login Successful");
					
					HttpSession session=req.getSession();
					session.setAttribute("user", user);
					resp.sendRedirect("moviehome");
				}
				else {
					System.out.println("login Successful");
					out.println("<h1>Shiv here</h1>");
					out.println("<h1>Login Failed... Inavlid username or passwords</h1>");
					out.println("<button><a href='index.html'>Back to login</a></button>");
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			out.println("</body>");
			out.println("</html>");
		}
		
		
}
