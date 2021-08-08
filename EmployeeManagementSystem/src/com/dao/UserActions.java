package com.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.beans.Regulations;
import com.beans.Report;
import com.beans.User;

public class UserActions {

	public static ArrayList<String> viewRegulations(String id) {
		Configuration configuration = new Configuration().configure("/com/dao/hibernate.cfg.xml");
		configuration.addAnnotatedClass(com.beans.Report.class);
		configuration.addAnnotatedClass(com.beans.User.class);
		configuration.addAnnotatedClass(com.beans.Regulations.class);
		configuration.addAnnotatedClass(com.beans.Department.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		User u = session.get(User.class, Integer.parseInt(id));
		String sql = "Select details from empdb.Regulations where dept_departmentid = " +u.getDep().getId();
		System.out.println(sql);
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List output = query.list();
		
		ArrayList<String> l = new ArrayList<String>();
		for(Object o:output) {
			Map d = (Map) o;
			l.add(d.get("details").toString());
		}
		
		transaction.commit();
		session.close();
		return l;
	}
	
	public static ArrayList<String> viewComments(String id) {
		Configuration configuration = new Configuration().configure("/com/dao/hibernate.cfg.xml");
		configuration.addAnnotatedClass(com.beans.Report.class);
		configuration.addAnnotatedClass(com.beans.User.class);
		configuration.addAnnotatedClass(com.beans.Regulations.class);
		configuration.addAnnotatedClass(com.beans.Department.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		String sql = "Select comments from empdb.Report where emp_userID = " +id;
		System.out.println(sql);
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List output = query.list();
		
		ArrayList<String> l = new ArrayList<String>();
		for(Object o:output) {
			Map d = (Map) o;
			l.add(d.get("reg_regId").toString());
		}
		
		transaction.commit();
		session.close();
		return l;
	}
	
	public static void addComments(String comment, String regId, String userId) {
		Configuration configuration = new Configuration().configure("/com/dao/hibernate.cfg.xml");
		configuration.addAnnotatedClass(com.beans.Report.class);
		configuration.addAnnotatedClass(com.beans.User.class);
		configuration.addAnnotatedClass(com.beans.Regulations.class);
		configuration.addAnnotatedClass(com.beans.Department.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Report r = new Report();
		User u = session.get(User.class, Integer.parseInt(userId));
		Regulations reg = session.get(Regulations.class, Integer.parseInt(regId));
		r.setEmp(u);
		r.setReg(reg);
		r.setDep(u.getDep());
		r.setComments(comment);
		r.setCreatDate(new SimpleDateFormat("yyyy-mm-dd").format(new Date()));
		session.save(r);
		transaction.commit();
		session.close();
	}
	
}
