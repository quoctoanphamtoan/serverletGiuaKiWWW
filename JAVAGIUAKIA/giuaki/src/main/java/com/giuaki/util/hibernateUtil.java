package com.giuaki.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class hibernateUtil {
	private static final SessionFactory SESSION_FACTORY;
	
	static {
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SESSION_FACTORY = metadata.getSessionFactoryBuilder().build();
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
	public static void main(String[] args) {
		new hibernateUtil().getSessionFactory();
	}
	
 
}
