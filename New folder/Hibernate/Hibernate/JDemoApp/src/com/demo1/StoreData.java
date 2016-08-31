package com.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class StoreData {
public static void main(String[] args) {
	
	
	
	// Note : You should make sure at the time of using annotation instead of mapping file should match setter getter variable names exact equal with database columns name
	// Note : If you are using mapping file there is no restrication of matching criteria.
	// Note : You have option for enable and disable second level cache in configuration file.
	// Note : At the time of using Annotation should use AnnotationConfiguration Class instead of Configuration Class.
			  // Remeber below statements mentioned in setter getter file 
					//import javax.persistence.Entity;
					//import javax.persistence.Id;
					//import javax.persistence.Table;
	
	//creating configuration object
	
	/*try
	{*/
	//Configuration cfg=new Configuration();
	Configuration cfg=new AnnotationConfiguration();
	cfg.configure("myhibernate.cfg.xml");
	
	//creating seession factory object
	SessionFactory factory=cfg.buildSessionFactory();
	SessionFactory factory1=cfg.buildSessionFactory();
	
		
	Session session1=factory.openSession();
	Session session2=factory.openSession();
	
	Transaction t1=session1.beginTransaction();
	
    Employee emp1=(Employee)session1.load(Employee.class,new Integer(1));
    System.out.println("Result 1 "+emp1.getId()+" "+emp1.getFirstName()+" "+emp1.getLastName());
    
    
    emp1=(Employee)session1.load(Employee.class,new Integer(1));  
    System.out.println("Result 2 "+emp1.getId()+" "+emp1.getFirstName()+" "+emp1.getLastName());
    session1.evict(emp1);
    factory.evict(Employee.class);
    emp1=(Employee)session2.load(Employee.class,new Integer(1));  
    System.out.println("Result 3 "+emp1.getId()+" "+emp1.getFirstName()+" "+emp1.getLastName());
    
            
    t1.commit();
    
	/*//creating session object
	Session session=factory.openSession();
	
	//creating transaction object
	Transaction t=session.beginTransaction();
	
	Employee e1=new Employee();
	e1.setId(1);
	e1.setFirstName("demo");
	e1.setLastName("record");
	
	//session.save(e1);
	//session.update(e1);
	
	t.commit();//transaction is commited
	session.close();
	
	System.out.println("successfully saved");
	}
	catch (Exception e) {
		String s="";
	}*/
	
}
}
