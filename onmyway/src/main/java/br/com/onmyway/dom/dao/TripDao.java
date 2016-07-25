package br.com.onmyway.dom.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.onmyway.dom.entity.Trip;
import br.com.onmyway.dom.repository.TripRepository;
import br.com.onmyway.util.HibernateUtil;

public class TripDao extends GenericDAOImpl<Trip, Integer> implements
	TripRepository {

    @SuppressWarnings("unchecked")
    @Override
    public List<Trip> findAllTrips() {
	List<Trip> trips = new ArrayList<Trip>();
	try {
	    HibernateUtil.beginTransaction();
	    trips = findAll(Trip.class);
	    HibernateUtil.commitTransaction();
	} catch (HibernateException ex) {
	    ex.printStackTrace();
	}
	return trips;
    }

    @Override
    public List<Trip> findAllActiveTrips() {
	List<Trip> person = null;
	String sql = "SELECT t FROM Trip t WHERE t.finished=0";
	HibernateUtil.beginTransaction();
	Query query = HibernateUtil.getSession().createQuery(sql);
	person = (List<Trip>) findMany(query);
	HibernateUtil.commitTransaction();
	return person;
    }
    
    @Override
    public List<Trip> findAllTripsNotFinishedsoOnTime() {
	List<Trip> person = null;
	Date date = new Date();
	String sql = "SELECT t FROM Trip t WHERE t.finished=0 AND t.endTime < :date";
	HibernateUtil.beginTransaction();
	Query query = HibernateUtil.getSession().createQuery(sql).setParameter("date", date);
	person = (List<Trip>) findMany(query);
	HibernateUtil.commitTransaction();
	return person;
    }

}