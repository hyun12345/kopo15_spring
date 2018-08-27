package kr.ac.kopo.danjiresort.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.danjiresort.domain.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
//		return sessionFactory.openSession();	
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Long count() {
		String hql = "SELECT COUNT(*) FROM User";
		Query query = getSession().createQuery(hql);
		Long totalCount = (Long) query.uniqueResult();
		return totalCount;
	}
	
	@Override
	public User selectOne(long id) {
		String hql = "FROM User u WHERE u.id = " + id;
		Query query = getSession().createQuery(hql);
		return (User) query.uniqueResult();
		
//		return (User) query.list().get(0);
		
//		return (Users) getSession().get(Users.class, id);
	}

	@Override
	public List<User> selectAll() {
		String hql = "FROM User";
		Query query = getSession().createQuery(hql);
		return query.list();
		
//		return getSession().createCriteria(Users.class).list();
	}
	
	@Override
	public List<User> selectAllByPagination(int page, int itemSizePerPage) {
		String hql = "FROM User ORDER BY username";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((page - 1) * itemSizePerPage);
		query.setMaxResults(itemSizePerPage);
		return query.list();
	}

	@Override
	public int createOne(User user) {
		return (int) getSession().save(user);
		
//		session.flush();
//		session.close();
	}

	@Override
	public void updateOne(User user) {
		getSession().saveOrUpdate(user);
	}

	@Override
	public void deleteOne(User user) {
		getSession().delete(user);
	}
	
	@Override
	public int deleteAll() {
		String hql = "DELETE FROM User";
		Query query = getSession().createQuery(hql);
		return query.executeUpdate();
	}
	
}
