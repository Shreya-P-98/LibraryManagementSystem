package com.montran.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryUtil {
	
	
	static SessionFactory factory;
	
	static {
		try {
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			System.out.println("Session factory created successfully");
		}catch(Exception e) {
			System.out.println("Error while creating session factory!!");
			e.printStackTrace();
		}
	}
	public static SessionFactory getSessionFacotry() {
		return factory;
		
	}

}
