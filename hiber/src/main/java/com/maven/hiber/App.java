package com.maven.hiber;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        //System.out.println( "Hello World!" );
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
       // System.out.println(factory);
        Student st=new Student();
        st.setId(101);
        st.setName("Aahana");
        st.setCity("Bankerwa");
        System.out.print(st);
        
        Address ad=new Address();
        ad.setStreet("street 1");
        ad.setCity("Delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(15.56);
         
        FileInputStream fis=new FileInputStream("src/main/java/pic.png");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        //To save in DB these steps need to be followed
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(st);
        session.save(ad);
        
        tx.commit();
        session.close();
        
    }
}
