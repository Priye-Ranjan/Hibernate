package com.maven.cascading;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.maven.one2many.Answer1;
import com.maven.one2many.Question1;

public class Demo {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Question1 q1=new Question1();
		q1.setQuestionid(121);
		q1.setQuestion("What is Java");

		Answer1 ans1=new Answer1();
		ans1.setAnswer_id(201);
		ans1.setAnswer("Java is a high level programming language");
		ans1.setQuestion(q1);
		
		Answer1 ans2=new Answer1();
		ans2.setAnswer_id(202);
		ans2.setAnswer("Java is an platform independent");
		ans2.setQuestion(q1);
		
		Answer1 ans3=new Answer1();
		ans3.setAnswer_id(203);
		ans3.setAnswer("Java is Robust and secure");
		ans3.setQuestion(q1);
		
		List<Answer1> list=new ArrayList<Answer1>();
		list.add(ans1);
		list.add(ans2);
		list.add(ans3);
		
		q1.setAnswers(list);
		
		Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(q1);
        
//        session.save(ans1);
//        session.save(ans2);
//        session.save(ans3);
//        
        tx.commit();
        session.close();
		
	}
}
