//package kr.co.uclick.repository;
//
//import java.util.List;
//
//import javax.persistence.QueryHint;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.jpa.repository.QueryHints;
//
//import kr.co.uclick.entity.User;
//
//public class UserTestRepositoryImpl implements UserTestRepository {
//
//	@Autowired
//	private SessionFactory sessionFactory;
//	
//	private Session getSession() {
//		return sessionFactory.getCurrentSession();
//	}
//
//	private void sleep(long millis) {
//		try {
//			Thread.sleep(millis);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//	
////	@Cacheable(value = "area")
//	public List<User> findUserByNameLike(String name) {
//		sleep(3000);
//		return findUserByNameLike(name);
//	}
//	
////	@CacheEvict(value = "area", key="#user.id")
////	@CacheEvict(value = "area", allEntries = true)
////	public void updateOne(User user) {
////		sleep(3000);
////		
////		getSession().saveOrUpdate(user);
////	}
//
//}
