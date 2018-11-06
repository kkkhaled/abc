package com.khaled.caching;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
    	 
    	alien a1=null;
    	
    	
    	  Configuration con=new Configuration().configure().addAnnotatedClass(alien.class);
          ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

          SessionFactory sf=con.buildSessionFactory(sr);
  		  Session s1=sf.openSession();
  	      s1.beginTransaction();
  	      
  	      Query q1= s1.createQuery("from alien where aid=101");
  	      a1=(alien)q1.uniqueResult();
  	      q1.setCacheable(true);
  	      System.out.println(a1);
  	      s1.getTransaction().commit();
  	      s1.close();
  	      
		  Session s2=sf.openSession();
		  s2.beginTransaction();
		  Query q2= s2.createQuery("from alien where aid=101");
		  q2.setCacheable(true);
  	      a1=(alien)q2.uniqueResult();	     
  	      System.out.println(a1);
  	      s2.getTransaction().commit();
  	      s2.close();
  		 

  	     
    }
}
