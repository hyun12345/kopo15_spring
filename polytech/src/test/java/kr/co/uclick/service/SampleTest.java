package kr.co.uclick.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import kr.co.uclick.configuration.SpringConfiguration;
import kr.co.uclick.entity.Sample;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class SampleTest {

	@Autowired
	SampleService sampleService;
	
//	@Test
//	public void testSelectOne() {
//		StopWatch sw = new StopWatch();
//		sw.start();
//		Sample s1 = sampleService.selectOne(1L);
//		sw.stop();
//		
//		System.out.println("-**<<TOTAL TIME : " + sw.getTotalTimeSeconds() + ">>**-");
//		
//		sw = new StopWatch();
//		sw.start();
//		Sample s2 = sampleService.selectOne(1L);
//		sw.stop();
//		
//		System.out.println("-**<<TOTAL TIME : " + sw.getTotalTimeSeconds()+ ">>**-");
//		
//		assertEquals(1, s1.getId().intValue());
//		
//	}
	
	@Test
	public void testUpdateOne() {
		StopWatch sw = new StopWatch();
		sw.start();
		Sample s1 = sampleService.selectOne(1L);
		sw.stop();
		System.out.println("1-**<<NUMBER ONE TOTAL TIME : " + sw.getTotalTimeSeconds() + ">>**-");
		
		sw = new StopWatch();
		sw.start();
		s1 = sampleService.selectOne(1L);
		sw.stop();
		System.out.println("2-**<<NUMBER TWO TOTAL TIME : " + sw.getTotalTimeSeconds() + ">>**-");
		
//		sw = new StopWatch();
//		sw.start();
//		s1 = sampleService.selectOne(1L);
//		sw.stop();
		s1.setName("2");
		sampleService.updateOne(s1);
//		System.out.println("-**<<NUMBER THREE TOTAL TIME : " + sw.getTotalTimeSeconds()+ ">>**-");
		
		sw = new StopWatch();
		sw.start();
		s1 = sampleService.selectOne(1L);
		sw.stop();
		System.out.println("3-**<<NUMBER THREE TOTAL TIME : " + sw.getTotalTimeSeconds()+ ">>**-");
		
		sw = new StopWatch();
		sw.start();
		s1 = sampleService.selectOne(1L);
		sw.stop();
		System.out.println("4-**<<NUMBER FOUR TOTAL TIME : " + sw.getTotalTimeSeconds()+ ">>**-");
		
//		assertEquals(1, s1.getId().intValue());
	}
	
	

}