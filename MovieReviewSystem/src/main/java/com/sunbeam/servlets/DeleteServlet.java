package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.pojo.UserPojo;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		HttpSession session=req.getSession();
		UserPojo user=(UserPojo) session.getAttribute("user");
		
		ServletContext ctx=req.getServletContext();
		String title=ctx.getInitParameter("applicationName");
		out.println("<h1>"+title+"</h1>");
		
		try(ReviewDao reviewDao=new ReviewDao())
		{
			int op=reviewDao.deleteById(user.getId());
			
			if(op != 0)
			{
				out.println("<h4>Data added Successfully<h4>");
				
			}
			else {
				out.println("<h4>Somthing went Wrong<h4>");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		resp.sendRedirect("myreviews");
	}
}
