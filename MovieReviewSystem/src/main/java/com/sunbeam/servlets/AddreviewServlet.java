package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.pojo.ReviewPojo;
import com.sunbeam.pojo.UserPojo;


@WebServlet("/addreviews")
public class AddreviewServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		HttpSession session=req.getSession();
		UserPojo user=(UserPojo)session.getAttribute("user");
		
		ServletContext ctx=req.getServletContext();
		String title=ctx.getInitParameter("applicationName");
		out.println("<h1>"+title+"</h1>");
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>myreviews</title>");
		out.println("</head>");
		out.println("<body>");
			out.println("<form method='post' action='addreviews'>");
			out.println("Movie Id:<input type='number' name='movieid'/><br><br>");
			out.println("Review: <input type='textarea' name='review'/><br><br>");
			out.println("Rating: <input type='number' name='rating'/><br><br>");
			//out.println("UserId: <input type='text' name='userid'/><br><br>");
			out.println("<input type='submit' value='Add'/>");
			out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		HttpSession session=req.getSession();
		UserPojo user=(UserPojo)session.getAttribute("user");
		
		ReviewPojo reviewPojo=new ReviewPojo();
		
		String movieid=req.getParameter("movieid");
		System.out.println("Id"+movieid);
		int mid=Integer.parseInt(movieid);
		reviewPojo.movieId=mid;
		
		reviewPojo.review=req.getParameter("review");
		String rating=req.getParameter("rating");
		int rat=Integer.parseInt(rating);
		reviewPojo.rating=rat;
		
//		String userid=req.getParameter("userid");
//		int uid=Integer.parseInt(userid);
		reviewPojo.userId=user.getId();
		try(ReviewDao reviewDao=new ReviewDao())
		{
			int op=0;
			op=reviewDao.addReviewById(reviewPojo);
			
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
		
//		RequestDispatcher rd = req.getRequestDispatcher("moviehome"); 
//		rd.forward(req, resp);
		
		resp.sendRedirect("moviehome");
		
	}
}
