package JavaApplication.myhibernet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import myhiber.model.Products;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
 	        System.out.println("Project started..");
 	 
 	        Configuration cfg = new Configuration();
 	        cfg.configure("hibernate.xml");
 	        SessionFactory factory = cfg.buildSessionFactory();

 	        Products p=new Products();

 	        p.setPrice(2000);
 	        p.setProductCompany("Dell");
 	        p.setProductId(234569);
 	        p.setRating(5);
 	        p.setProductName("Mouse");



 	    System.out.println(p);
 	    Session session =factory.openSession();

 	    Transaction x=session.beginTransaction();
 	    session.save(p);
 	    x.commit();

 	    session.close();
 	    System.out.println("Done..");
 	 
 	    }
 	 
    }

