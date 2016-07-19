package br.com.onmyway.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.onmyway.entity.User;

public class UserDao {
 
	private SessionFactory sessionFactory;
 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
 
	public void insert(User user){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<User> selectAll(){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		List<User> users = (List<User>)criteria.list();
		session.getTransaction().commit();
		return users;
	}
	 
}