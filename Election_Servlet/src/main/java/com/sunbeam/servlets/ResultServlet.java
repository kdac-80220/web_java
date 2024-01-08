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

@WebServlet("/result")

public class ResultServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(CandidateDao candDao=new CandidateDaoImpl())
		{
			List<Candidate> list=candDao.getCandidatewiseVotes();
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>candidatelist</title>");
			out.println("</head>");
			out.println("<body>");
			
			HttpSession session=req.getSession();
			User curUser=(User) session.getAttribute("curUser");
			out.println("Hello "+curUser.getFirstName()+" "+curUser.getLastName());
			
			
			out.println("<table>");
			out.println("<thead>");
			out.println("<th>Id</th>");
			out.println("<th>Name</th>");
			out.println("<th>Party</th>");
			out.println("<th>Votes</th>");
			out.println("</thead>");
			out.println("<tbody>");
			
			for(Candidate c:list)
			{
				out.println("<tr>");
				out.printf("<td>%s</td>",c.getId());
				out.printf("<td>%s</td>",c.getName());
				out.printf("<td>%s</td>",c.getParty());
				out.printf("<td>%s</td>",c.getVotes());
				out.println("</tr>");
			}
			out.println("</tbody>");
			out.println("</table>");
			out.println("<a href='logout'>Logout</a>");
			out.println("</html>");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
