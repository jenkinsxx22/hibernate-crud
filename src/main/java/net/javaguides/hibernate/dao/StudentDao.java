package net.javaguides.hibernate.dao;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.javaguides.hibernate.model.Student;
import net.javaguides.hibernate.util.HIbernateUtil;

public class StudentDao {
	public void SaveStudent(Student student) throws Exception {
		
		Transaction transaction = null;
		
		SessionFactory sf = new Configuration().configure("/net/javaguides/hibernate/util/Hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		
		try {
			//start the transaction
			transaction=(Transaction) s.beginTransaction();	
			
			//save student object
			s.save(student);
			
			//commit the transaction
			transaction.commit();
			
		} catch (Exception e) {	
			
			if(transaction!=null) {				
				transaction.rollback();
			}
		} 		
	}

	public void UpdateStudent(Student student) throws Exception {
		
		Transaction transaction = null;
		SessionFactory sf = new Configuration().configure("/net/javaguides/hibernate/util/Hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
try {
		//start the transaction
			transaction=(Transaction) s.beginTransaction();		
			
			//save student object
			s.saveOrUpdate(student);
			
			//commit the transaction
			transaction.commit();
			
		} catch (SecurityException e) {
			
			if(transaction!=null) {				
				transaction.rollback();
			}
		} 
		
	}

	public Student getStudentById(long id) throws Exception {
		
		Transaction transaction = null;
		Student student = null;
		SessionFactory sf = new Configuration().configure("/net/javaguides/hibernate/util/Hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		try {	
		//start the transaction
			transaction=(Transaction) s.beginTransaction();		
			
			//get student object
			
			student = s.load(Student.class, id);
			  
			//commit the transaction
			transaction.commit();
			
		} catch (SecurityException e) {
			
			if(transaction!=null) {
				
				transaction.rollback();
			}
		}		
		
		return student;
		
	}

	public List<Student> getAllStudent() throws Exception {
		
		Transaction transaction = null;
		List<Student> students = null;
		SessionFactory sf = new Configuration().configure("/net/javaguides/hibernate/util/Hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		try {
		//start the transaction
			transaction=(Transaction) s.beginTransaction();		
			
			//get students object
			students = s.createQuery("from Student").list();
			  
			//commit the transaction
			transaction.commit();
			
		} catch (SecurityException e) {
			
			if(transaction!=null) {
				
				transaction.rollback();
			}
		} 
		return students;
		
	}

	public void DeleteStudent(long id) throws Exception {
		
		Transaction transaction = null;
		Student student = null;
		SessionFactory sf = new Configuration().configure("/net/javaguides/hibernate/util/Hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		try {
		//start the transaction
			transaction=(Transaction) s.beginTransaction();		
			
			student = s.get(Student.class, id);
			//save student object
			s.delete(student);
			
			//commit the transaction
			transaction.commit();
			
		} catch (SecurityException e) {
			
			if(transaction!=null) {
				
				transaction.rollback();
			}
		} 	
	}

}
