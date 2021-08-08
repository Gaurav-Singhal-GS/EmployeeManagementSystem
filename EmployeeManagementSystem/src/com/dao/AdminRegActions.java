package com.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.beans.Department;
import com.beans.Regulations;

public class AdminRegActions {

	public static Regulations viewRegulationsFromDB(int compId) {
		Configuration configuration = new Configuration().configure("/com/dao/hibernate.cfg.xml");
		configuration.addAnnotatedClass(com.beans.Department.class);
		configuration.addAnnotatedClass(com.beans.Regulations.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Regulations comp = session.get(Regulations.class, compId);
		session.close();
		return comp;
		

	}
	
	public static void insertRegulationsIntoDB(Regulations reg) {
		Configuration configuration = new Configuration().configure("/com/dao/hibernate.cfg.xml");
		configuration.addAnnotatedClass(com.beans.Department.class);
		configuration.addAnnotatedClass(com.beans.Regulations.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
//		session.save(reg.getDept());
		Department d = reg.getDept();
		Criteria criteria = session.createCriteria(Department.class);
		Department dept = (Department)criteria.add(Restrictions.eq("name", d.getName())).uniqueResult();
		if(dept == null)
			session.save(d);
		else
			reg.setDept(dept);
			
		session.save(reg);
		transaction.commit();
		session.close();
	}

}
