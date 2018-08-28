package kr.co.uclick.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.uclick.service.PhoneService;
import kr.co.uclick.service.SampleService;
import kr.co.uclick.service.UserService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class SpringConfigurationTest {

	@Autowired
	SampleService sampleService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PhoneService phoneService;
	
	@Test
	public void test() {
		sampleService.findAll();
//		userService.findAll();
//		phoneService.findAll();
		
		
		
	}
	
	

}
