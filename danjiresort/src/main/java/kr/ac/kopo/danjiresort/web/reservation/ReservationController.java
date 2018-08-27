package kr.ac.kopo.danjiresort.web.reservation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.danjiresort.domain.Reservation;
import kr.ac.kopo.danjiresort.service.ReservationService;
import kr.ac.kopo.danjiresort.vo.ReservationVO;

@Controller
public class ReservationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private ReservationService reservationService;
	
	//home 페이지에서 출력되는 reservation에 걸리는 링크 내용
	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("reservation index");
		
		model.addAttribute("reservation", reservationService.selectOne(1));
		
		return "reservation/home";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		
		return "reservation/main";
	}
	
	@RequestMapping(value = "/suitroom", method = RequestMethod.GET)
	public String suitroom() {
		
		return "reservation/a_01";
	}
	
	@RequestMapping(value = "/doubleroom", method = RequestMethod.GET)
	public String doubleroom() {
		
		return "reservation/a_02";
	}
	
	@RequestMapping(value = "/singleroom", method = RequestMethod.GET)
	public String singleroom() {
		
		return "reservation/a_03";
	}
	
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String map() {
		
		return "reservation/b_01";
	}
	
	@RequestMapping(value = "/transport", method = RequestMethod.GET)
	public String transport() {
		
		return "reservation/b_02";
	}
	
	@RequestMapping(value = "/car", method = RequestMethod.GET)
	public String car() {
		
		return "reservation/b_03";
	}
	
	@RequestMapping(value = "/mountain", method = RequestMethod.GET)
	public String mountain() {
		
		return "reservation/c_01";
	}
	
	@RequestMapping(value = "/beach", method = RequestMethod.GET)
	public String beach() {
		
		return "reservation/c_02";
	}
	
	@RequestMapping(value = "/hotspring", method = RequestMethod.GET)
	public String hotspring() {
		
		return "reservation/c_03";
	}
	
	//공지리스트
	@RequestMapping(value = "/reservation_list", method = RequestMethod.GET)
	public String reservation_list(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
		//<String, String> : ex)from=n&cnt=n : String 형태이므로 from, cnt 값을 받아오기 위해 이같이 선언
		//Map(MultiValueMap) : 변수 타입 중 하나
		//@RequestParam : key=value 형태로 화면에서 넘어오는 쿼리스트링 혹은 폼 데이터를 메소드의 파라미터로 지정
		logger.info("reservation list");
			
		//List<Gongji> gongjiList = gongjiService.selectAll();
		//페이지네이션 적용 하지 않은 gongjiList 리스트
//		List<Reservation> reservationList = reservationService.selectAll();
//		List<ReservationVO> reservations = new ArrayList<>();
		Date datetouse = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today = dateFormat.format(datetouse);
		
		List<ReservationVO> reservations = reservationService.setReservation(today, today, "예약가능", "예약가능", "예약가능");
		
//		List<ReservationVO> reservations = new ArrayList<>();
		reservations.add(new ReservationVO("2018-08-22", "(수)", "냠냠", "냠냠", "냠냠"));
		
//ArrayList 생성 예시
//		reservations.add(new ReservationVO("2018-08-21"));

		//페이지네이션 적용한 gongjiList 리스트
			
		model.addAttribute("reservations", reservations );

		//웹에 받아온 파라미터 값을 출력할 수 있도록 model 객체 활용
			
		return "reservation/d_01";
		//src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml 파일 확인
		//22~24번째 줄 코드 확인하면 return 값인 gongji/list 앞과 뒤에 생략된 값이 있음을 확인할 수 있음
		// /board(기본창?) 까지의 링크 주소의 값은 생략되지 않음
	}
	
	//공지리스트
	@RequestMapping(value = "/reservation_form", method = RequestMethod.GET)
	public String reservation_form(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
		//<String, String> : ex)from=n&cnt=n : String 형태이므로 from, cnt 값을 받아오기 위해 이같이 선언
		//Map(MultiValueMap) : 변수 타입 중 하나
		//@RequestParam : key=value 형태로 화면에서 넘어오는 쿼리스트링 혹은 폼 데이터를 메소드의 파라미터로 지정
		logger.info("reservation form");
			
		return "reservation/d_02";
		//src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml 파일 확인
		//22~24번째 줄 코드 확인하면 return 값인 gongji/list 앞과 뒤에 생략된 값이 있음을 확인할 수 있음
		// /board(기본창?) 까지의 링크 주소의 값은 생략되지 않음
	}
	
}
