package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.MovieInterfaceDao;
import com.sunbeam.pojo.MoviePojo;
import com.sunbeam.pojo.UserPojo;

@WebServlet("/moviehome")

public class HomeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		HttpSession session=req.getSession();
		UserPojo user=(UserPojo) session.getAttribute("user");
		
		ServletContext ctx=req.getServletContext();
		String title=ctx.getInitParameter("applicationName");
		out.println("<h1 style='text-align:center'>"+title+"</h1>");
		
		out.printf("<h5>Hello: %s</h5>",user.getFirstName());
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Home</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method='get' action='myreviews'><input type='submit' value='My Reviews'></form>");
		out.println("<form method='get' action='allreviews'><input type='submit' value='All Reviews'></form>");
		out.println("<form method='get' action='addreviews'><input type='submit' value='Add Reviews'></form>");
		
		
		out.println("<h3>Movies</h3>");
		out.println("<table border='1'>");
		out.println("<thead>");
			out.println("<th>Id</th>");
			out.println("<th>Title</th>");
			out.println("<th>Relese Date</th>");
		out.println("</thead>");
			out.println("<tbody>");
			try(MovieDao movieDao=new MovieDao())
			{
				List<MoviePojo> list=movieDao.findAll();
				
				for(MoviePojo mpj:list) {
					out.println("<tr><td>"+mpj.getId()+"</td><td>"+mpj.getName()+"</td><td>"+mpj.getDate()+"</td></tr>");
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			out.println("</tbody>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
