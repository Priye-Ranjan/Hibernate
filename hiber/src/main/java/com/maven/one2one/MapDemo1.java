package com.maven.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo1 {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Question q1=new Question();
		//q1.setQuestion_id(121);
		q1.setQuestion("How many continents in world");
		
		Answer ans1=new Answer();
		//ans1.setAnswer_id(201);
		ans1.setAnswer("7");
		
		q1.setAnswer(ans1);
		
		Question q2=new Question();
	//	q2.setQuestion_id(122);
		q2.setQuestion("Which is the largest country?");
		
		Answer ans2=new Answer();
		//ans2.setAnswer_id(202);
		ans2.setAnswer("Russia");
		
		q2.setAnswer(ans2);
		
		Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(q1);
        session.save(q2);
        
        session.save(ans1);
        session.save(ans2);
        
        tx.commit();
        
        //fetching data
        Question qn=(Question)session.get(Question.class,121);
        System.out.println(qn.getQuestion());
        System.out.println(qn.getAnswer().getAnswer());
        session.close();
		
		
		
	}
}
