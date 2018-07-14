package com.phimes.test.webapp.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;



public class HibernateUtil {

	private static StandardServiceRegistry registry;
	
	//	Configurazione XML 
	private static SessionFactory sessionFactory;
	
	//	Configurazione Annotation
	private static SessionFactory sessionAnnotationFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }

	public static SessionFactory getSessionAnnotationFactory() {
		if(sessionAnnotationFactory == null) sessionAnnotationFactory = buildSessionAnnotationFactory();
        return sessionAnnotationFactory;
    }
	
	private static SessionFactory buildSessionFactory() {
        try {
        	// 	Crea la SessionFactory da hibernate.cfg.xml
    		registry = new StandardServiceRegistryBuilder().configure("hibernate-annotation.cfg.xml").build();
        	System.out.println("ServiceRegistry creato");
            MetadataSources sources = new MetadataSources(registry);
            Metadata metadata = sources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
            
            // 	SessionFactory creata
            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Creazione SessionFactory non riuscita." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    private static SessionFactory buildSessionAnnotationFactory() {
    	try {
        	// 	Crea la SessionFactory da hibernate-annotation.cfg.xml
    		registry = new StandardServiceRegistryBuilder().configure("hibernate-annotation.cfg.xml").build();
        	System.out.println("ServiceRegistry creato");
            MetadataSources sources = new MetadataSources(registry);
            Metadata metadata = sources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        	
        	// 	SessionFactory creata
            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}

	public static void destroySessionFactory() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}	
	
}
