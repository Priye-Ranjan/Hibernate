package com.maven.many2many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Demo2 {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Employee emp1=new Employee();
		emp1.setEmpid(100);
		emp1.setName("John");
		
		Employee emp2=new Employee();
		emp2.setEmpid(101);
		emp2.setName("Beckham");
		
		Employee emp3=new Employee();
		emp3.setEmpid(102);
		emp3.setName("David");
		
		Project proj1=new Project();
		proj1.setPid(201);
		proj1.setPname("Java course");
		
		Project proj2=new Project();
		proj2.setPid(202);
		proj2.setPname("Python course");
		
		Project proj3=new Project();
		proj3.setPid(203);
		proj3.setPname("Library Management course");
		
		List<Project> list1=new ArrayList<Project>();
		list1.add(proj1);
		list1.add(proj3);
		
		List<Employee> list2=new ArrayList<Employee>();
		list2.add(emp2);
		list2.add(emp1);
		
		List<Employee> list3=new ArrayList<Employee>();
		list3.add(emp3);
		list3.add(emp1);
		
		proj3.setEmp(list3);
		
		emp1.setProj(list1);
		
		//proj1.setEmp(list2);
		
		Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(emp1);
        session.save(emp2);
        session.save(emp3);
        
        session.save(proj1);
        session.save(proj2);
        session.save(proj3);
        
        tx.commit();
        session.close();
	}
}
