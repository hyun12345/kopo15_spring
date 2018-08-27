package kr.co.uclick.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import kr.co.uclick.configuration.SpringConfiguration;
import kr.co.uclick.entity.User;
import kr.co.uclick.repository.PhoneRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class ServiceTest {

	@Autowired
	UserService userService;
	
	@Autowired
	PhoneService phoneService;
	
	@Autowired
	PhoneRepository phoneRepository;
	
//---------------------------User CRUD---------------------------
	//***User Create***
//	@Test
//	public void insert_user() {
//		User user = new User();
//		user.setId(1L);
//		user.setName("단지");
//		user.setAddress("우리집");
//		userService.save(user);
//	}
	
	//***User Read***
//	@Test
//	public void findById_user() {
//		User user = userService.findById(1L);
//		assertEquals(2, user.getId().longValue());
//	}
	
//	@Test
//	public void findAll_user() {
//		List<User> user = userService.findAll();
//		assertEquals(2, user.get(0).getId().longValue());
//	}
	
	//***User Update***
//	@Test
//	public void update_user() {
//		User user = userService.findById(1L);
//		user.setAddress("우리집");
//		userService.save(user);
//	}
	
	//***User Delete***
//	@Test
//	public void delete_user() {
//		User user = userService.findById(2L);
//		userService.delete(user);
//	}
	

	//---------------------------Phone CRUD---------------------------
	//***Phone Create***
//	@Test
//	public void insert_phone() {
//		User user = userService.findById(1L);
//		Phone phone = new Phone();
//		phone.setId(1L);
//		phone.setUser(user);
//		phone.setNumber("010-1234-5678");
//		phoneService.save(phone);
//	}

	//***Phone Read***
//	@Test
//	public void findById_phone() {
//		Phone phone = phoneService.findById(2L);
//		assertEquals(5, phone.getId().longValue());
//	}
	
//	@Test
//	public void findAll_phone() {
//		List<Phone> phone = phoneService.findAll();
//		assertEquals(2, phone.get(0).getId().longValue());
//	}
	
	//***Phone Update***
//	@Test
//	public void update_phone() {
//		Phone phone = phoneService.findById(2L);
//		phone.setNumber("010-1234-5678");
//		phoneService.save(phone);
//	}
	
	//***Phone Delete***
//	@Test
//	public void delete_phone() {
//		Phone phone = phoneService.findById(1L);
//		phoneService.delete(phone);
//		
//		
//		Optional<Phone> p = phoneRepository.findById(1L);
//		Phone phone = p.get();
//		phoneRepository.delete(phone);
//	}
	
	//***phone number 검색 테스트***
//	@Test
//	public void search_phone() {
//		List<Phone> phone = phoneService.findPhoneByNumber("010-1234-5678");
//		assertEquals(2, phone.get(0).getId().longValue());
//	}
	
	//***user name 검색 테스트***
	@Test
	public void search_user() {
		StopWatch sw = new StopWatch();
		sw.start();
		List<User> user = userService.findUserByNameLike("단지");
		sw.stop();
		System.out.println("1-**<<NUMBER ONE TOTAL TIME : " + sw.getTotalTimeSeconds() + ">>**-");
		
		sw = new StopWatch();
		sw.start();
		user = userService.findUserByNameLike("단지");
		sw.stop();
		System.out.println("2-**<<NUMBER TWO TOTAL TIME : " + sw.getTotalTimeSeconds() + ">>**-");

		sw = new StopWatch();
		sw.start();
		user = userService.findUserByNameLike("단지");
		sw.stop();
		System.out.println("3-**<<NUMBER THREE TOTAL TIME : " + sw.getTotalTimeSeconds() + ">>**-");

		sw = new StopWatch();
		sw.start();
		user = userService.findUserByNameLike("단지");
		sw.stop();
		System.out.println("4-**<<NUMBER FOUR TOTAL TIME : " + sw.getTotalTimeSeconds() + ">>**-");
		
		assertEquals(1, user.get(0).getId().longValue());
	}

}