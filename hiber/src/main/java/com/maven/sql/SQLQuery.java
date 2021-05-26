package com.maven.sql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLQuery {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session s=factory.openSession();
		
		String q="Select * from student";
		NativeQuery nq=s.createSQLQuery(q);
		List<Object[]> list=nq.list();
		
		for(Object[] stud:list)
			System.out.println(Arrays.deepToString(stud));
		
		s.close();
		factory.close();
	}
	
}
