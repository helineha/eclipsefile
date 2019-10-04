package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.model.Option;
import com.lti.model.Question;
import com.lti.model.QuestionBankLoader;


@WebServlet("/QuestionLoaderServlet")
public class QuestionLoaderServlet extends HttpServlet {
	private List<Question>  questions;
	private int noOfQuestions;
	
	@Override
	public void init() throws ServletException {
	
		questions = QuestionBankLoader.loadQuestionsOnJava();
		noOfQuestions = questions.size();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Integer questionNo = (Integer)session.getAttribute("qNo");//wrapper class created
		if(questionNo == null)
			questionNo = 0;
		else
			questionNo++;
		session.setAttribute("qNo", questionNo);
		
		Question q = questions.get(questionNo);
		session.setAttribute("currentQs", q);//to get the current question
		
		
		response.setContentType("text/html"); //for server to recognize that this is a html page
		
		PrintWriter out = response.getWriter();
		
		out.print("<form action='CalculateScoreServlet'>");
		out.print("<h3>" + q.getQuestion() + "</h3>");
		
		int optionNo=0;
		
		for(Option o : q.getOptions()){
			
			out.print("<h4><input type='radio' name='select' value='"+(optionNo++)+"' />" + o.getOption() + "</h4>");
			//value is needed to know what the user selects, in this case each option is given a different value,starting from 0.
		}
		
			out.println("<button type='submit' value='0' name='button'> Continue </button>");
			//if(questionNo==noOfQuestions-1){
			out.println("<button type='submit' value='1' name='button'> Finish </button>");
			//} if you want only 1 button to get displayed then use  if-else,which is commented now.
			
		out.print("</form>");
		
	} 

	

}
