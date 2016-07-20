package br.com.onmyway.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.onmyway.entity.Contact;

public class ContactDao {
 
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
 
	public void insert(Contact contact){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(contact);
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
	}
 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Contact> selectAll(){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Contact.class);
		List<Contact> contacts = (List<Contact>)criteria.list();
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
		return contacts;
	}
	 
}
