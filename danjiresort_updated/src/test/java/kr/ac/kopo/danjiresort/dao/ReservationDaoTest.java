package kr.ac.kopo.danjiresort.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.danjiresort.dao.ReservationDao;
import kr.ac.kopo.danjiresort.domain.Reservation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/applicationContext-test.xml"})
public class ReservationDaoTest {

	@Autowired
	//Spring���� �ش� ��ü ����
	ReservationDao reservationDao;
	
//    @Before
//    public void setUp() throws Exception {
//    	String u1 = "user1";
//    	User user1 = new User();
//    	user1.setPassword("pw");
//    	user1.setUsername(u1);
//    	user1.setName(u1);
//    	user1.setEmail(u1);
//    	user1.setCreated(new Date());
//    	
//    	String u2 = "user2";
//    	User user2 = new User();
//    	user2.setPassword("pw");
//    	user2.setUsername(u2);
//    	user2.setName(u2);
//    	user2.setEmail(u2);
//    	user2.setCreated(new Date());
//    	
//    	String u3 = "user3";
//    	User user3 = new User();
//    	user3.setPassword("pw");
//    	user3.setUsername(u3);
//    	user3.setName(u3);
//    	user3.setEmail(u3);
//    	user3.setCreated(new Date());
//    	
//    	userDao.createOne(user1);
//    	userDao.createOne(user2);
//    	userDao.createOne(user3);
//    }
    
//    @After
//    public void cleanUp(){
//    	userDao.deleteAll();
//    }
    
//    @Test
//    public void testCount() throws Exception {
//    	//���̺� ��ü ������ �� ��ȸ
//    	Long count = gongjiDao.count();
//        assertEquals(1, count.intValue());
//    }
    
//    @Test
//    public void testSelectOne() throws Exception {
////		���̺� ��ü ������ �� �� ������ ��ȸ(view �������� ����)
////    	Gongji g = gongjiDao.selectOne(1);
////        assertEquals(1, g.getId());
//        
//    	Reservation resv = reservationDao.selectOne(1);
//        assertEquals(1, resv.getId());
//    }
//    
//    @Test
//    public void testSelectAll() throws Exception {
//		//���̺� ��ü ������ �� ��ȸ(list �������� ����)
//    	List<Gongji> g = gongjiDao.selectAll();
//        assertEquals(2, g.size());
//        //DB�� ����Ǿ����� Ȯ�� ����(���� ���ڴ� ��ȸ�� ������ ��)
//        
//        //assertEquals(5, 20);
//        //���� �ٸ��Ƿ� ����
//        //assertEquals(5, 5);
//        //���� �����Ƿ� ����
//    }
	
  @Test
  public void testSelectAll() throws Exception {
      	Reservation reservtaion1 = reservationDao.selectReservationByDate("2018-09-05", 1);
	  	Reservation reservation2 = reservationDao.selectReservationByDate("2018-09-05", 2);
	  	Reservation reservation3 = reservationDao.selectReservationByDate("2018-09-05", 3);
  	
	  	
	  	System.out.println("aaa");
	  	
  }
	
	
    
//    @Test
//    public void testSelectAllByPagination() throws Exception {
//    	//�� �������� ��µǴ� ������ �� ���� �����Ͽ� �� �������� ��µǴ� ������ �� ��ȸ(list �������� ����)
//    	List<Gongji> gongjis = gongjiDao.selectAllByPagination(1, 10);
//    	//(������, ������ �� ������ ��)
//    	
//    	for (Gongji g: gongjis) {
//    		System.out.println(g.getId());
//    	}
//    	
//        assertEquals(10, gongjis.size());
//        //�� �������� ��µǴ� ������ ��
//    }
    
//    @Test
//    public void testCreateOne() throws Exception {
//    	String name = "user4";
//    	User u = new User();
//    	u.setPassword("pw");
//    	u.setUsername(name);
//    	u.setName(name);
//    	u.setEmail(name);
//    	u.setCreated(new Date());
//    	
//    	int id = userDao.createOne(u);
//    	assertEquals(167, id);
//    }
    
//    @Test
//    public void testUpdateOne() throws Exception {
//    	String pw = "pw3";
//    	User u = userDao.selectOne(1);
//    	u.setPassword(pw);
//    	userDao.updateOne(u);
//    	
//    	assertEquals(pw, u.getPassword());
//    }
    
//    @Test
//    public void testDeleteOne() throws Exception {
//    	User u = userDao.selectOne(167);
//    	userDao.deleteOne(u);
//    	
//    	assertEquals(1, 1);
//    }
    
//    @Test
//    public void testDeleteAll() throws Exception {
//    	int count = userDao.deleteAll();
//    	assertEquals(1, count);
//    }
    
//  @Test
//  public void countSuitroom() throws Exception {
//  	int count = reservationDao.countSuitroom("2018-08-21", 1);
//  	assertEquals(1, count);
//  }
    
    @Test
    public void selectReservations() throws Exception {
    	Reservation reservation = reservationDao.selectReservationByDate("2018-08-21", 1);
    	assertEquals("����Ʈ��", reservation.getRoom().getType());
    }
  
}
