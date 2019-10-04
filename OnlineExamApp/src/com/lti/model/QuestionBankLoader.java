package com.lti.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionBankLoader {

	public static List<Question> loadQuestionsOnJava(){
		QuestionBank qb = new QuestionBank();
		
		Subject s1 = new Subject();
		s1.setName("Java");
		qb.addNewSubject(s1);
		
		Question q1 = new Question();
		q1.setQuestion("What is G1 in java?");
		
		List<Option> ops1 = new ArrayList<Option>();
		ops1.add(new Option("G1 is Garbage collector",true));
		ops1.add(new Option("G1 is another name for jeevan",false));
		ops1.add(new Option("G1 is abc",false));
		ops1.add(new Option("G1 is my name",false));
		q1.setOptions(ops1);
		
		qb.addNewQuestion(s1, q1);
		
		Question q2 = new Question();
		q2.setQuestion("What is java?");
		
		List<Option> ops2 = new ArrayList<Option>();
		ops2.add(new Option("Java is OO language",true));
		ops2.add(new Option("Java is scripting",false));
		ops2.add(new Option("Java is English language",false));
		ops2.add(new Option("NONE",false));
		q2.setOptions(ops2);
		
		qb.addNewQuestion(s1, q2);
		
		Question q3 = new Question();
		q3.setQuestion("What is Inheritance in java?");
		
		List<Option> ops3 = new ArrayList<Option>();
		ops3.add(new Option("Inheritance derives the properties from base class",true));
		ops3.add(new Option("Inheritance is a class",false));
		ops3.add(new Option("Both A and B",false));
		ops3.add(new Option("NONE",false));
		q3.setOptions(ops3);
		
		
		qb.addNewQuestion(s1, q3);
		
		Question q4 = new Question();
		q4.setQuestion("JDBC full form");
		
		List<Option> ops4 = new ArrayList<Option>();
		ops4.add(new Option("Java database Connectivity",true));
		ops4.add(new Option("Java data build console",false));
		ops4.add(new Option("Java delete break console",false));
		ops4.add(new Option("Java drop build continue",false));
		q4.setOptions(ops4);
		
		qb.addNewQuestion(s1, q4);
		
		return qb.getQuestionsFor(s1);
		
		
	
	}
}
