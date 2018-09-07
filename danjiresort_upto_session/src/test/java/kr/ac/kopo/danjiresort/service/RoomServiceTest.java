package kr.ac.kopo.danjiresort.service;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.danjiresort.domain.Room;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/applicationContext-test.xml"})
public class RoomServiceTest {

	@Autowired
	RoomService roomService;
	
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void cleanUp(){
    }
    
    @Test
    public void testIsRoomExist() throws Exception {
    	Room r = new Room();
    	r.setId(1);
    	
    	boolean isExist = roomService.isRoomExist(r);
        assertEquals(true, isExist);
    }
    
}
