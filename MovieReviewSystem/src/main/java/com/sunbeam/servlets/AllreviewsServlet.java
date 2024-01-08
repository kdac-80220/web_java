package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.pojo.ReviewPojo;
import com.sunbeam.pojo.UserPojo;


@WebServlet("/allreviews")
public class AllreviewsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		UserPojo user=(UserPojo)session.getAttribute("user");
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>myreviews</title>");
		out.println("</head>");
		out.println("<body>");
			out.println("<table border='1'>");
			out.println("<thead>");
				out.println("<th>Review Id</th>");
				out.println("<th>Movie Id</th>");
				out.println("<th>Review</th>");
				out.println("<th>Rating</th>");
				out.println("<th>User Id</th>");
				out.println("<th>Modified Time</th>");
				out.println("<th>Action</th>");
			out.println("</thead>");
			out.println("<tbody>");
			System.out.println("my id:"+user.getId());
				try(ReviewDao rd=new ReviewDao())
				{
					List<ReviewPojo> list=rd.displayAllReviews();
					
					for(ReviewPojo rp:list)
					{
						out.println("<tr><td>"+rp.getId()+"</td><td>"+rp.getMovieId()+"</td><td>"+rp.getReview()+"</td><td>"+rp.getRating()+"</td><td>"+rp.getUserId()+"</td><td>"+rp.getModified()+"</td>"+ "<td><img src='edit.png' alt='Edit' width='35' height='35'/><img src='delete.png' alt='delete' width='35' height='35'/></td></tr>");
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
