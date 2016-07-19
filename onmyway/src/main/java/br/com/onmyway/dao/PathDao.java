package br.com.onmyway.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.onmyway.entity.Path;

public class PathDao {
 
	private SessionFactory sessionFactory;
 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
 
	public void insert(Path path){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(path);
		session.getTransaction().commit();
	}
 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Path> selectAll(){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Path.class);
		List<Path> paths = (List<Path>)criteria.list();
		session.getTransaction().commit();
		return paths;
	}
	 
}