package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.beans.*;

public class UserValidation {
	
	public static boolean validateUsers(Login Data) {
		Configuration configuration = new Configuration().configure("/com/dao/hibernate.cfg.xml");
		configuration.addAnnotatedClass(com.beans.Login.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		String sql = "Select * from empdb.login where id = " + Data.getId() + " and password = \"" + Data.getPassword() + "\" and role=\""+ Data.getRole() +"\"";
		System.out.println(sql);
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List output = query.list();
		
		transaction.commit();
		session.close();
		if(!output.isEmpty())
			return true;
		return false;
	}

}
