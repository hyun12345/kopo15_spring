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
	
	//home ���������� ��µǴ� reservation�� �ɸ��� ��ũ ����
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
	
	//��������Ʈ
	@RequestMapping(value = "/reservation_list", method = RequestMethod.GET)
	public String reservation_list(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
		//<String, String> : ex)from=n&cnt=n : String �����̹Ƿ� from, cnt ���� �޾ƿ��� ���� �̰��� ����
		//Map(MultiValueMap) : ���� Ÿ�� �� �ϳ�
		//@RequestParam : key=value ���·� ȭ�鿡�� �Ѿ���� ������Ʈ�� Ȥ�� �� �����͸� �޼ҵ��� �Ķ���ͷ� ����
		logger.info("reservation list");
			
		//List<Gongji> gongjiList = gongjiService.selectAll();
		//���������̼� ���� ���� ���� gongjiList ����Ʈ
//		List<Reservation> reservationList = reservationService.selectAll();
//		List<ReservationVO> reservations = new ArrayList<>();
		Date datetouse = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today = dateFormat.format(datetouse);
		
		List<ReservationVO> reservations = reservationService.setReservation(today, today, "���డ��", "���డ��", "���డ��");
		
//		List<ReservationVO> reservations = new ArrayList<>();
		reservations.add(new ReservationVO("2018-08-22", "(��)", "�ȳ�", "�ȳ�", "�ȳ�"));
		
//ArrayList ���� ����
//		reservations.add(new ReservationVO("2018-08-21"));

		//���������̼� ������ gongjiList ����Ʈ
			
		model.addAttribute("reservations", reservations );

		//���� �޾ƿ� �Ķ���� ���� ����� �� �ֵ��� model ��ü Ȱ��
			
		return "reservation/d_01";
		//src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml ���� Ȯ��
		//22~24��° �� �ڵ� Ȯ���ϸ� return ���� gongji/list �հ� �ڿ� ������ ���� ������ Ȯ���� �� ����
		// /board(�⺻â?) ������ ��ũ �ּ��� ���� �������� ����
	}
	
	//��������Ʈ
	@RequestMapping(value = "/reservation_form", method = RequestMethod.GET)
	public String reservation_form(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
		//<String, String> : ex)from=n&cnt=n : String �����̹Ƿ� from, cnt ���� �޾ƿ��� ���� �̰��� ����
		//Map(MultiValueMap) : ���� Ÿ�� �� �ϳ�
		//@RequestParam : key=value ���·� ȭ�鿡�� �Ѿ���� ������Ʈ�� Ȥ�� �� �����͸� �޼ҵ��� �Ķ���ͷ� ����
		logger.info("reservation form");
			
		return "reservation/d_02";
		//src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml ���� Ȯ��
		//22~24��° �� �ڵ� Ȯ���ϸ� return ���� gongji/list �հ� �ڿ� ������ ���� ������ Ȯ���� �� ����
		// /board(�⺻â?) ������ ��ũ �ּ��� ���� �������� ����
	}
	
}
