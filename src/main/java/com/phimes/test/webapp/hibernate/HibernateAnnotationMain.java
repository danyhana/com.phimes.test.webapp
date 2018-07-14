package com.phimes.test.webapp.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.phimes.test.webapp.hibernate.model.People;
import com.phimes.test.webapp.hibernate.util.HibernateUtil;

public class HibernateAnnotationMain {

	public static void main(String[] args) {
		
		//Creare istanza che rappresenta una riga sulla tabella People
		People p = new People();
		p.setFirstName("Maria");
		p.setLastName("Macau");
		p.setAge(32);
		p.setCity("Alessandria");
		p.setId(9);
	    
		
		saveOrUpdatePeople(p);
		
		
		List<People> peoples = getListAllPeople();
		
		for (People var: peoples) {
			System.out.println(var.getFirstName());
		}
		

	}

	/**
	 * Restituisce una Lista con tutte le righe della tabella
	 * @param session
	 * @return
	 */
	private static List<People> getListAllPeople() {
//		Acquisizione Session
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		// inizio transaction
		session.beginTransaction();
		List<People> peoples = session.createQuery("from People").list();
		
		session.close();
		return peoples;
	}

	/**
	 * Salva o aggiona riga della tabella utlizzando l'istanza appena creata
	 * @param session
	 * @param p
	 */
	private static void saveOrUpdatePeople(People p) {
//		Acquisizione Session
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();

		// inizio transaction
		session.beginTransaction();

		
		session.saveOrUpdate(p);
		session.getTransaction().commit();
		session.close();

	}
	
	/**
	 * Il Metodo elimia una riga della tabella definita dall'id dell'istanza di
	 * People
	 * @param p
	 */
	private static void deletePeople(People p) {
//		Acquisizione Session
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();

		// inizio transaction
		session.beginTransaction();

		
		session.delete(p);
		session.getTransaction().commit();
		session.close();

	}


}
