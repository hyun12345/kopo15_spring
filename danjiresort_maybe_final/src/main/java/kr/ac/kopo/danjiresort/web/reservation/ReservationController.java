package kr.ac.kopo.danjiresort.web.reservation;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.danjiresort.domain.Reservation;
import kr.ac.kopo.danjiresort.domain.Room;
import kr.ac.kopo.danjiresort.domain.User;
import kr.ac.kopo.danjiresort.service.ReservationService;
import kr.ac.kopo.danjiresort.service.RoomService;
import kr.ac.kopo.danjiresort.service.UserService;
import kr.ac.kopo.danjiresort.vo.ReservationVO;

@Controller
public class ReservationController {

	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private UserService userService;

	@Autowired
	private RoomService roomService;
	
	// home ���������� ��µǴ� reservation�� �ɸ��� ��ũ ����
	@RequestMapping(value = "/")
	public String home() {
		return "redirect:login";
	}
	
	//�α���
	@RequestMapping(value = "/login")
	public String login(HttpSession session, Model model) {
		logger.info("login");
		
		if(session.getAttribute("ID") == null) {
			
			return "reservation/login";
			
		} else {
			
			model.addAttribute("message", "�̹� �α����� �����Դϴ�.");
			return "reservation/alert";
			
		}
	}
	
	//�α׾ƿ�
	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpSession session) {
		logger.info("logout");
		
		if(session.getAttribute("ID") != null) {
			session.invalidate(); 
			return "reservation/logout_alert";
		} else {
			model.addAttribute("message", "���� �α��� ���� ���� �����Դϴ�. �α��� �Ͻʽÿ�.");
			return "reservation/alert";
		}
	}
	
	//�α��� ȯ��
	@RequestMapping(value = "/welcome")
	public String welcome(Locale locale, @RequestParam Map<String, String> parameter, Model model, HttpSession session, HttpServletResponse response) throws UnsupportedEncodingException {
		logger.info("welcome");
		String id = parameter.get("id");
		String password = parameter.get("password");

		User user = userService.selectOneByAuth(id);
		model.addAttribute("user", user);
		if (user == null) {
			
			model.addAttribute("message", "ID / password�� Ʋ�Ƚ��ϴ�.");
			return "reservation/alert";
			
		} else if (id.equals(user.getAuth()) && password.equals(user.getPasswd())) {
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss (EE)");
			
			//cookie�� ����
			Date usetodate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss�� (EE)");
			String date = sdf.format(usetodate);
			
			// set cookie
			Cookie timeCookie = new Cookie("timeCookie", URLEncoder.encode(date, "UTF-8"));
			timeCookie.setPath("/");
			timeCookie.setMaxAge(-1);
			response.addCookie(timeCookie);
			
			// set session
			session.setAttribute("ID", id);
			
			model.addAttribute("timestamp", dateformat.format(cal.getTime()));
			return "reservation/welcome";
			
		} else {
			
			model.addAttribute("message", "ID / password�� Ʋ�Ƚ��ϴ�.");
			return "reservation/alert";
			
		}
	}
	
	@RequestMapping(value = "/top")
	public String top() {
		logger.info("top");

		return "reservation/top";
	}

	@RequestMapping(value = "/main")
	public String main(Model model, @CookieValue(value = "timeCookie", required = false) Cookie timeCookie) throws UnsupportedEncodingException {
		logger.info("main");
		
		// get cookie
		if (timeCookie == null) {
			return "reservation/main";
		} else {
			logger.info("timeCookie" + timeCookie);
			model.addAttribute("timeCookie", URLDecoder.decode(timeCookie.getValue(), "UTF-8"));
			return "reservation/main";
		}

		
		
		
	}

	@RequestMapping(value = "/suitroom")
	public String suitroom() {
		
		logger.info("suitroom");

		return "reservation/a_01";
	}

	@RequestMapping(value = "/doubleroom")
	public String doubleroom() {
		
		logger.info("doubleroom");

		return "reservation/a_02";
	}

	@RequestMapping(value = "/singleroom")
	public String singleroom() {
		
		logger.info("doubleroom");

		return "reservation/a_03";
	}

	@RequestMapping(value = "/map")
	public String map() {
		
		logger.info("map");

		return "reservation/b_01";
	}

	@RequestMapping(value = "/transport")
	public String transport() {
		
		logger.info("transport");

		return "reservation/b_02";
	}

	@RequestMapping(value = "/car")
	public String car() {
		
		logger.info("car");

		return "reservation/b_03";
	}

	@RequestMapping(value = "/mountain")
	public String mountain() {
		
		logger.info("transport");

		return "reservation/c_01";
	}

	@RequestMapping(value = "/beach")
	public String beach() {
		
		logger.info("transport");

		return "reservation/c_02";
	}

	@RequestMapping(value = "/hotspring")
	public String hotspring() {
		
		logger.info("transport");
		
		return "reservation/c_03";
	}

	// ������
	@RequestMapping(value = "/reservation_list", method = RequestMethod.GET)
	public String reservation_list(Locale locale, Model model) {
		logger.info("reservation list");

		List<ReservationVO> reservations = reservationService.getReservation();
		model.addAttribute("reservations", reservations);
		
//		List<ReservationVO> reservations = new ArrayList<>();
//		reservations.add(new ReservationVO("2018-08-22", "(��)", "�ȳ�", "�ȳ�", "�ȳ�"));

//ArrayList ���� ����
//		reservations.add(new ReservationVO("2018-08-21"));

		return "reservation/d_01";
	}

	// ������
	@RequestMapping(value = "/reservation_form", method = RequestMethod.GET)
	public String reservation_form(Locale locale, @RequestParam Map<String, String> parameter, Model model, HttpSession session) {
		logger.info("reservation form");
		String auth = (String) session.getAttribute("ID");
		
		if (auth == null) {
			model.addAttribute("message", "����� ������ �����ϴ�. �α��� �Ͻʽÿ�.");
			return "reservation/alert";
		} else {

			if (parameter.get("room") != null) {
				String date = parameter.get("date");
				logger.info("date" + date);

				int room_id = Integer.parseInt(parameter.get("room"));
				logger.info("room_id" + room_id);
				model.addAttribute("room_id", room_id);

				Room room = roomService.selectOne(room_id);
				List<Room> roomList = roomService.selectAll();

				model.addAttribute("date", date);

				model.addAttribute("room", room);
				model.addAttribute("roomList", roomList);

				List<ReservationVO> reservations = reservationService.getReservation();
				model.addAttribute("reservations", reservations);

				return "reservation/d_02";
			} else {
				return "reservation/d_02_error";
			}
		}
	}

	// ����Ϸ�
	@RequestMapping(value = "/reservation_result", method = RequestMethod.GET)
	public String reservation_result(Locale locale, @RequestParam Map<String, String> parameter, Model model, HttpSession session)
			throws ParseException {
		logger.info("reservation result");
		
		String auth = (String) session.getAttribute("ID");
		model.addAttribute("auth", auth);
		
		User user = userService.selectOneByAuth(auth);
		model.addAttribute("user", user);

		int room_id = Integer.parseInt(parameter.get("room_id"));
		logger.info("room_id" + room_id);

		String date_toweb = parameter.get("date");
		model.addAttribute("date", date_toweb);

		if (reservationService.selectReservationByDate(date_toweb, room_id) == null) {
			Room room = roomService.selectOne(room_id);

			logger.info("room.id" + room.getId());
			logger.info("user.id" + user.getId());

			String comment = parameter.get("comment");
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(parameter.get("date"));

			Reservation reservation = new Reservation();

			reservation.setUser(user);
			reservation.setRoom(room);
			reservation.setComment(comment);
			reservation.setDate(date);

			reservationService.createOne(reservation);

			model.addAttribute("reservation", reservation);
			return "reservation/d_02_write";
		} else {
			model.addAttribute("message", "���� ������ �Ϸ�� ���Դϴ�. �ٸ� ��¥ / ���� �����Ͽ� �ֽʽÿ�.");
			return "reservation/alert";
		}

		// src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml ���� Ȯ��
		// 22~24��° �� �ڵ� Ȯ���ϸ� return ���� gongji/list �հ� �ڿ� ������ ���� ������ Ȯ���� �� ����
		// /board(�⺻â?) ������ ��ũ �ּ��� ���� �������� ����
	}
	
	//������ ������
	@RequestMapping(value = "/adm_allview", method = RequestMethod.GET)
	public String admin_allview(Locale locale, @RequestParam Map<String, String> parameter, Model model, HttpSession session) {
		logger.info("adm_allview");
		String admin = (String) session.getAttribute("ID");
		
		if (admin == null) {
			
			model.addAttribute("message", "����� ������ �����ϴ�. �α��� �Ͻʽÿ�.");
			return "reservation/alert";
		} else if (admin.equals("admin")) {
			
			List<ReservationVO> reservations = reservationService.getReservation();
			model.addAttribute("reservations", reservations);
			
			return "reservation/adm_allview";
		} else {
			model.addAttribute("message", "�����ڸ� ���� ������ �������Դϴ�.");
			return "reservation/alert";
		}
	}
	
	// ������ ����� ��
	@RequestMapping(value = "/adm_oneview", method = RequestMethod.GET)
	public String adm_oneview(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
		logger.info("adm_oneview");
		
		String date = parameter.get("date");
		model.addAttribute("date", date);
		int room_id = Integer.parseInt(parameter.get("room"));
		
		List<Room> roomList = roomService.selectAll();
		model.addAttribute("roomList", roomList);
		
		List<ReservationVO> reservations = reservationService.getReservation();
		model.addAttribute("reservations", reservations);
		
		Reservation reservation = reservationService.selectReservationByDate(date, room_id);
		model.addAttribute("reservation", reservation);

			return "reservation/adm_oneview";
	}
	
	// ������ ���� ����
	@RequestMapping(value = "/adm_update")
	public String adm_update(Locale locale, @RequestParam Map<String, String> parameter, Model model) throws ParseException {
		logger.info("adm_update");
		
		String date_toweb = parameter.get("date");
		int room_id = Integer.parseInt(parameter.get("room_id"));
		
		if (reservationService.selectReservationByDate(date_toweb, room_id) == null) {
		
		int key = Integer.parseInt(parameter.get("key"));
		Reservation reservation = reservationService.selectOne(key);
		
		int user_id = Integer.parseInt(parameter.get("user_id"));
		String name = parameter.get("name");
		String address = parameter.get("address");
		String telnum = parameter.get("number");
		
		User usertoupdate = userService.selectOne(user_id);
		usertoupdate.setName(name);
		usertoupdate.setAddr(address);
		usertoupdate.setTelnum(telnum);
		
		userService.updateOne(usertoupdate);
		
		reservation.setUser(usertoupdate);
		
		Room room = roomService.selectOne(room_id);
		
		reservation.setRoom(room);
		
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(parameter.get("date"));
		reservation.setDate(date);
		
		String comment = parameter.get("comment");
		reservation.setComment(comment);
		
		reservationService.updateOne(reservation);
		model.addAttribute("reservtaion", reservation);
		logger.info("reservation.user.name" + reservation.getUser().getName());
		
			return "reservation/adm_update";
		} else {
			model.addAttribute("message", "���� ������ �Ϸ�� ���Դϴ�. �ٸ� ��¥ / ���� �����Ͽ� �ֽʽÿ�.");
			return "reservation/alert";
		}
	}
	
	// ������ ���� ����
	@RequestMapping(value = "/adm_delete", method = RequestMethod.GET)
	public String adm_delete(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
		logger.info("adm_delete");
		
		int key = Integer.parseInt(parameter.get("key"));
		
		Reservation reservation = reservationService.selectOne(key);
		reservationService.deleteOne(key);
		
		model.addAttribute("reservation", reservation);
		return "reservation/adm_delete";
	}
	
	//������ �α׾ƿ�
	@RequestMapping(value = "/adm_logout")
	public String adm_logout(Model model, HttpSession session) {
		logger.info("adm_logout");
		String admin = (String) session.getAttribute("ID");
		
		if(admin == null) {
			model.addAttribute("message", "���� �α��� ���� ���� �����Դϴ�. �α��� �Ͻʽÿ�.");
			return "reservation/alert";
			
		}else if (!(session.getAttribute("ID").equals("admin"))) {
			model.addAttribute("message", "�����ڸ� ���� ������ �������Դϴ�.");
			return "reservation/alert";	
		} else  {
			session.invalidate(); 
			model.addAttribute("message", "���������� �α׾ƿ� �Ǿ����ϴ�. ���� �Ϸ� �Ǽ���.");
			return "reservation/logout_alert";
		}
	}

	@RequestMapping(value = "/news")
	public String news() {
		logger.info("news");

		return "reservation/e_01";
	}

	@RequestMapping(value = "/review")
	public String review() {
		logger.info("review");

		return "reservation/e_02";
	}

	@RequestMapping(value = "/jsp_setCookie")
	public String jsp_setCookie() {

		return "reservation/jsp_setCookie";
	}

	@RequestMapping(value = "/jsp_getCookie")
	public String jsp_getCookie() {

		return "reservation/jsp_getCookie";
	}

	@RequestMapping(value = "/jsp_delCookie")
	public String jsp_delCookie() {

		return "reservation/jsp_delCookie";
	}

	@RequestMapping(value = "/jsp_setSession")
	public String jsp_setSession() {

		return "reservation/jsp_setSession";
	}

//	@RequestMapping(value = "/set_cookie", method = RequestMethod.GET)
//	public String setCookie(Model model, HttpServletResponse response) {
//		logger.info("set_cookie");
//
//		// set cookie
//		Cookie userIdCookie = new Cookie("userIdCookie", "DANJI");
//		userIdCookie.setPath("/");
//		userIdCookie.setMaxAge(60 * 60 * 24 * 30);
//		response.addCookie(userIdCookie);
//
//		return "reservation/spring_setCookie";
//	}
//
//	@RequestMapping(value = "/get_cookie", method = RequestMethod.GET)
//	public String getCookie(Model model, @CookieValue(value = "userIdCookie", required = false) Cookie userIdCookie) {
//		logger.info("get_cookie");
//
//		// get cookie
//		if (userIdCookie != null) {
//			System.out.println("userIdCookie : " + userIdCookie.getValue());
//		}
//
//		model.addAttribute("userIdCookie", userIdCookie.getValue());
//
//		return "reservation/spring_getCookie";
//	}

	@RequestMapping(value = "/set_session", method = RequestMethod.GET)
	public String set_session(Model model, HttpSession session) {
		logger.info("set_session");

		// set session
		session.setAttribute("userId", 12345);

		return "reservation/spring_setSession";
	}

	@RequestMapping(value = "/get_session", method = RequestMethod.GET)
	public String get_session(Model model, HttpSession session) {
		logger.info("get_session");

		// get session
		int ID = (int) session.getAttribute("ID");
		System.out.println("ID : " + ID);

		model.addAttribute("ID" + ID);
		return "reservation/spring_getSession";
	}
	
}
