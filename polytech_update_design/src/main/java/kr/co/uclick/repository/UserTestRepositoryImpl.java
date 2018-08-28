//package kr.co.uclick.repository;
//
//import java.util.List;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
//
//import kr.co.uclick.entity.Sample;
//import kr.co.uclick.entity.User;
//
//public class UserTestRepositoryImpl implements UserTestRepository {
//
//	private static final Logger logger = LoggerFactory.getLogger(UserTestRepositoryImpl.class);
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
//	@Cacheable(value = "area")
//	public List<User> findUserByNameLike(String name) {
//		sleep(3000);
//		return findUserByNameLike(name);
//	}
//
//}
