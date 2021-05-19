package com.maven.hiber;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
	public static void main(String args[])
	{
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Student st=new Student();
        st.setId(101);
        st.setName("Aahana");
        st.setCity("Bankerwa");
        
        Certificate certificate=new Certificate();
        certificate.setCourse("Hibernate");
        certificate.setDuration("3 months");
        st.setCertificate(certificate);
        
        Student st1=new Student();
        st1.setId(102);
        st1.setName("Kumar");
        st1.setCity("Patna");
        
        Certificate certificate1=new Certificate();
        certificate1.setCourse("Angular");
        certificate1.setDuration("2 months");
        st1.setCertificate(certificate1);
        //System.out.print(st);
        
        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        
        s.save(st);
        s.save(st1);
        
        tx.commit();
        s.close();
        factory.close();
	}
}
