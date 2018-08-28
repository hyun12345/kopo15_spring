//package kr.co.uclick.repository;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.google.common.collect.Lists;
//
//import kr.co.uclick.entity.Phone;
//import kr.co.uclick.entity.QPhone;
//
//public class PhoneTestRepositoryImpl implements PhoneTestRepository {
//
//	private static final Logger logger = LoggerFactory.getLogger(PhoneTestRepositoryImpl.class);
//
//	@Autowired
//	private SessionFactory sessionFactory;
//	
////	private Session getSession() {
////		return sessionFactory.getCurrentSession();
////	}
//	
//	@Cacheable(value = "area")
////	@Transactional(readOnly = true)
//	public Phone findPhoneByNumber(String number) {
//		return findPhoneByNumber(number);
//	}
//}
