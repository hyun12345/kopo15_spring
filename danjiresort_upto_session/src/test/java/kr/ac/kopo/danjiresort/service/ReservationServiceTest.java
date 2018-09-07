package kr.ac.kopo.danjiresort.service;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.danjiresort.domain.Reservation;
import kr.ac.kopo.danjiresort.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/applicationContext-test.xml"})
public class ReservationServiceTest {

	@Autowired
	ReservationService reservationService;
	
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void cleanUp(){
    }
    
    @Test
    public void testIsReservationExist() throws Exception {
    	Reservation resv = new Reservation();
    	resv.setId(1);
    	
    	boolean isExist = reservationService.isReservationExist(resv);
        assertEquals(true, isExist);
    }
    
    @Test
    public void selectReservations() throws Exception {
    	Reservation reservation = new Reservation();
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		
		Reservation reservationRoom = reservationService.selectReservationByDate(dateformat.format(cal.getTime()), reservation.getRoom().getId());
        assertEquals("½ºÀ§Æ®·ë", reservationRoom);
    }
    
}
