package rw.ac.rca.smis.smisApp;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import rw.ac.rca.smis.orm.Address;
import rw.ac.rca.smis.orm.Course;
import rw.ac.rca.smis.orm.Instructor;
import rw.ac.rca.smis.orm.Mark;
import rw.ac.rca.smis.orm.Student;

public class Starter {

	public static void main(String[] args) {
		Address add= new Address("Kigali","KN59 ST 13"); 
		
		Date date = new Date();
		Instructor eden = new Instructor("Rwagaju Aphrodice",date,'M');
		eden.setAddress(add);
		Course course1 = new Course(eden, 5, "python", 12);
		Student student1 = new Student(course1,"eden",date,'f',add);
		Mark mark = new Mark(course1,student1,100);
		
		
		
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		
		
		@SuppressWarnings("deprecation")
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		System.out.println(" Beginning transaction...........");
		Transaction transaction = session.beginTransaction();
		
		//saving objects
		session.saveOrUpdate(add);
		session.saveOrUpdate(course1);
		session.saveOrUpdate(eden);
		session.saveOrUpdate(student1);
		session.saveOrUpdate(mark);
		
		
		transaction.commit();
		session.close();
		factory.close();
		
	}
}
