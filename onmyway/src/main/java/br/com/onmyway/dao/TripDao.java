package br.com.onmyway.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.onmyway.entity.Trip;

public class TripDao {
 
	private SessionFactory sessionFactory;
 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
 
	public void insert(Trip trip){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(trip);
		session.getTransaction().commit();
	}
 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Trip> selectAll(){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Trip.class);
		List<Trip> trips = (List<Trip>)criteria.list();
		session.getTransaction().commit();
		return trips;
	}
	 
}