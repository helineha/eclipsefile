package com.lti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.model.Option;
import com.lti.model.Question;

@WebServlet("/CalculateScoreServlet")
public class CalculateScoreServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int optionNo = Integer.parseInt(request.getParameter("select"));
		int isComplete=Integer.parseInt(request.getParameter("button"));
		
		
		HttpSession session = request.getSession();
		Question q = (Question) session.getAttribute("currentQs");
		
		
		Integer score= (Integer) session.getAttribute("score") ;
		
		
		
		if(score == null)
			score=0;
		Option selectedOption = q.getOptions().get(optionNo);
		
		if(selectedOption.isRightAnswer())
			score ++;
		session.setAttribute("score",score);
		
		if(isComplete==1){
			response.sendRedirect("DisplayScoreServlet");
		}
		else{
			response.sendRedirect("QuestionLoaderServlet");
		}
		
		
		//store score in session and boundary condition to change label after exam is done.
	}

}
