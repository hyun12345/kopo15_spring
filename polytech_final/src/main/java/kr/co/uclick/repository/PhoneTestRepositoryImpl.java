//package kr.co.uclick.repository;
//
//import java.util.List;
//
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
//import kr.co.uclick.entity.User;
//
//public class PhoneTestRepositoryImpl implements PhoneTestRepository {
//
//	private static final Logger logger = LoggerFactory.getLogger(PhoneTestRepositoryImpl.class);
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
//	@Transactional(readOnly = true)
//	public Phone findPhoneByNumber(String number) {
//		sleep(3000);
//		return findPhoneByNumber(number);
//	}
//}
