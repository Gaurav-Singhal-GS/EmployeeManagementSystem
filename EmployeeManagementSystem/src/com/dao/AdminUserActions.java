package com.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.beans.Department;
import com.beans.Login;
import com.beans.User;

public class AdminUserActions {
	
		public static void insertEmployeeinDB(User e, Department d) {
			
			System.out.println(e);
			
			Configuration configuration = new Configuration().configure("/com/dao/hibernate.cfg.xml");
			configuration.addAnnotatedClass(com.beans.User.class);
			configuration.addAnnotatedClass(com.beans.Login.class);
			configuration.addAnnotatedClass(com.beans.Department.class);
			StandardServiceRegistryBuilder builder = 
					new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
					
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
//			session.save(d);
			Criteria criteria = session.createCriteria(Department.class);
			Department dept = (Department)criteria.add(Restrictions.eq("name", d.getName())).uniqueResult();
			if(dept == null)
				session.save(d);
			else
				e.setDep(dept);
				
			session.save(e);
			transaction.commit();
			
			transaction.begin();
			criteria = session.createCriteria(User.class);
			User u = (User)criteria.add(Restrictions.eq("email", e.getEmail())).uniqueResult();
			
			Login l = new Login(u.getUserId(), u.getFname(), "user");
			session.save(l);
			transaction.commit();
			session.close();
		}
		
		public static void deleteEmployeeFromDB(int empid) {
			Configuration configuration = new Configuration().configure("/com/dao/hibernate.cfg.xml");
			configuration.addAnnotatedClass(com.beans.User.class);
			configuration.addAnnotatedClass(com.beans.Login.class);
			configuration.addAnnotatedClass(com.beans.Department.class);
			StandardServiceRegistryBuilder builder = 
					new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
					
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			User e1 = session.get(User.class, empid);
			Login l = session.get(Login.class, empid);
			System.out.println(e1);
			session.delete(e1);
			session.delete(l);
			transaction.commit();
			session.close();
		}
		
		public static void updateEmployeeFromDB(int Id, User e) {	
			Configuration configuration = new Configuration().configure("/com/dao/hibernate.cfg.xml");
			configuration.addAnnotatedClass(com.beans.User.class);
			configuration.addAnnotatedClass(com.beans.Department.class);
			StandardServiceRegistryBuilder builder = 
					new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
					
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			User updatedEmplyee = session.get(User.class, Id);
			session.save(e.getDep());
			updatedEmplyee.setFname(e.getFname());
			updatedEmplyee.setLname(e.getLname());
			updatedEmplyee.setDob(e.getDob());
			updatedEmplyee.setEmail(e.getEmail());
			updatedEmplyee.setDep(e.getDep());
			
			transaction.commit();
			session.close();
		}
		
		public static User viewEmployeeFromDB(int empId) {
			Configuration configuration = new Configuration().configure("/com/dao/hibernate.cfg.xml");
			configuration.addAnnotatedClass(com.beans.User.class);
			configuration.addAnnotatedClass(com.beans.Department.class);
			StandardServiceRegistryBuilder builder = 
					new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
					
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			User emp = session.get(User.class, empId);
			
			transaction.commit();
			session.close();
			return emp;
			
		}

}
