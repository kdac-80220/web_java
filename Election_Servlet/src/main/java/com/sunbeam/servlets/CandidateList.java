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

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;
import com.sunbeam.pojos.User;


@WebServlet("/candlist")
public class CandidateList extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidates</title>");
		out.println("</head>");
		out.println("<body>");
		HttpSession session=req.getSession();
		User user=(User) session.getAttribute("curUser");
		out.println("Hello "+user.getFirstName()+" "+" "+user.getLastName());
		out.println("<h3>Candidate List</h3>");
		out.println("<form method='post' action='vote'>");
		try(CandidateDao candDao=new CandidateDaoImpl())
		{
			List<Candidate> list=candDao.findAll();
			for(Candidate c:list)
			{
				out.printf("<input type='radio' name='candidate' value='%d'/>%s %s",c.getId(),c.getName(),c.getParty());
				out.println("<br>");
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		out.println("<input type='submit' value='vote'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		out.println("</body>");
		out.println("</html>");
	}
}
