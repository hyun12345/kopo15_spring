package kr.ac.kopo.danjiresort.service;
//package kr.ac.kopo.board.service;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import kr.ac.kopo.board.domain.Reservation;
//import kr.ac.kopo.board.vo.PaginationVO;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath*:META-INF/applicationContext-test.xml"})
//public class GongjiServiceTest {
//
//	@Autowired
//	GongjiService gongjiService;
//	//GongjiDao에 접근 가능
//	
//    @Before
//    public void setUp() throws Exception {
//    }
//    
//    @After
//    public void cleanUp(){
//    }
//    
////    @Test
////    public void testIsGongjiExist() throws Exception {
////    	Gongji g = new Gongji();
////    	g.setId(1);
////    	
////    	boolean isExist = gongjiService.isGongjiExist(g);
////        assertEquals(true, isExist);
////    }
//    
//    @Test
//    public void testCalcPagination() throws Exception {
//        PaginationVO p = gongjiService.calcPagination(1, 1);
//    	//assertEquals(2, p.getPrev());
//    	//assertEquals(2, p.getNext());
//        
//      	//assertEquals(2, p.getFirst());
//        //assertEquals(2, p.getLast());
//        
////        assertEquals(1, p.getStart());        
//        assertEquals(2, p.getEnd());
//        
//        
//        p = gongjiService.calcPagination(2, 10);
////        assertEquals(1, p.getStart());   
//        assertEquals(10, p.getEnd());
////        p = gongjiService.calcPagination(3, 3);
////        assertEquals(1, p.getStart());
////        assertEquals(10, p.getEnd());
////        p = gongjiService.calcPagination(9, 3);
////        assertEquals(1, p.getStart());
////        assertEquals(10, p.getEnd());
////        p = gongjiService.calcPagination(10, 3);
////        assertEquals(1, p.getStart());
////        assertEquals(10, p.getEnd());
////        p = gongjiService.calcPagination(11, 3);
////        assertEquals(11, p.getStart());
////        assertEquals(20, p.getEnd());
////        p = gongjiService.calcPagination(21, 3);
////        assertEquals(21, p.getStart());
////        assertEquals(30, p.getEnd());
////        p = gongjiService.calcPagination(30, 3);
////        assertEquals(21, p.getStart());   
////        assertEquals(30, p.getEnd());
////        p = gongjiService.calcPagination(31, 3);
////        assertEquals(31, p.getStart());
////        assertEquals(40, p.getEnd());
//        
//        //assertEquals(2, p.getTotal_page());
//    	
//    }
//}
