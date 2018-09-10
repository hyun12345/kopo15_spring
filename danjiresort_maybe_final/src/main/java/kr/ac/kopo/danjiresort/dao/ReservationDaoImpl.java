package kr.ac.kopo.danjiresort.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.danjiresort.domain.Reservation;

//hql : hibernate 통해 제공되는 쿼리언어(sql과 유사)
//criteria : 자바 클래스 이용해 다양한 검색 조건을 명시할 수 있도록 해주는 API

@Transactional
@Repository
public class ReservationDaoImpl implements ReservationDao {

	@Autowired
	private SessionFactory sessionFactory;
	//instance 자동 mapping?
	
	private Session getSession() {
//		return sessionFactory.openSession();	
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Long count() {
		String hql = "SELECT COUNT(*) FROM Reservation";
		Query query = getSession().createQuery(hql);
		Long totalCount = (Long) query.uniqueResult();
		return totalCount;
	}
	
	@Override
	public Reservation selectOne(long id) {
		String hql = "FROM Reservation resv WHERE resv.id = " + id;
		Query query = getSession().createQuery(hql);
		return (Reservation) query.uniqueResult();
		
//		return (Gongji) query.list().get(0);
		
//		return (Users) getSession().get(Users.class, id);
	}

	@Override
	public List<Reservation> selectAll() {
		String hql = "FROM Reservation";
		Query query = getSession().createQuery(hql);
		return query.list();
		
//		return getSession().createCriteria(Users.class).list();
	}
	
	@Override
	public List<Reservation> selectAllByPagination(int page, int itemSizePerPage) {
		String hql = "FROM Reservation";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((page - 1) * itemSizePerPage);
		query.setMaxResults(itemSizePerPage);
		return query.list();
	}
	
	@Override
	public int createOne(Reservation reservation) {
		return (int) getSession().save(reservation);
		
//		session.flush();
//		session.close();
	}

	@Override
	public void updateOne(Reservation reservation) {
		getSession().saveOrUpdate(reservation);
	}

	@Override
	public void deleteOne(Reservation reservation) {
		getSession().delete(reservation);
	}
	
	@Override
	public int deleteAll() {
		String hql = "DELETE FROM Reservation";
		Query query = getSession().createQuery(hql);
		return query.executeUpdate();
	}

//	@Override
//	public int countSuitroom(String date, int room_id) {
//		String hql = "SELECT COUNT(*) FROM Reservation where date =" + date + " and room_id = " + room_id;
//		Query query = getSession().createQuery(hql);
//		int count = (int) query.uniqueResult();
//		return count;
//	}
	
//	@Override
//	public List<Reservation> selectReservations(String date, int room_id) {
//		String hql = "FROM Reservation WHERE date like '" + date + "%' and room_id = " + room_id;
//		Query query = getSession().createQuery(hql);
//		return query.list();
//	}
	
	@Override
	public Reservation selectReservationByDate(String date, int room_id) {
		String hql = "FROM Reservation WHERE date(date) = '" + date + "' and room_id = " + room_id;
		Query query = getSession().createQuery(hql);
		
		return (Reservation) query.uniqueResult();
	}
	
	
	
//	public Reservation selectReservations(String date) {
//	String hql = "FROM Reservation WHERE date(date) = '" + date + "'";
	
//	Object o = query.uniqueResult();

	
}
