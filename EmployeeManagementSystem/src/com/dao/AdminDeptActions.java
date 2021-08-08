package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.beans.Department;

public class AdminDeptActions {
	
public static void insertDepartmentinDB(Department d) {
		
		Configuration configuration = new Configuration().configure("/com/dao/hibernate.cfg.xml");
		configuration.addAnnotatedClass(com.beans.Department.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(d);
		transaction.commit();
		session.close();
	}

	public static Department viewDepartmentFromDB(int depId) {
		Configuration configuration = new Configuration().configure("/com/dao/hibernate.cfg.xml");
		configuration.addAnnotatedClass(com.beans.Department.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Department dep = session.get(Department.class, depId);
		session.close();
		return dep;
	}

}
