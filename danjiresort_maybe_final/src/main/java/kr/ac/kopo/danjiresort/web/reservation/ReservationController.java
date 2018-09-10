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
	
	// home 페이지에서 출력되는 reservation에 걸리는 링크 내용
	@RequestMapping(value = "/")
	public String home() {
		return "redirect:login";
	}
	
	//로그인
	@RequestMapping(value = "/login")
	public String login(HttpSession session, Model model) {
		logger.info("login");
		
		if(session.getAttribute("ID") == null) {
			
			return "reservation/login";
			
		} else {
			
			model.addAttribute("message", "이미 로그인한 상태입니다.");
			return "reservation/alert";
			
		}
	}
	
	//로그아웃
	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpSession session) {
		logger.info("logout");
		
		if(session.getAttribute("ID") != null) {
			session.invalidate(); 
			return "reservation/logout_alert";
		} else {
			model.addAttribute("message", "현재 로그인 되지 않은 상태입니다. 로그인 하십시오.");
			return "reservation/alert";
		}
	}
	
	//로그인 환영
	@RequestMapping(value = "/welcome")
	public String welcome(Locale locale, @RequestParam Map<String, String> parameter, Model model, HttpSession session, HttpServletResponse response) throws UnsupportedEncodingException {
		logger.info("welcome");
		String id = parameter.get("id");
		String password = parameter.get("password");

		User user = userService.selectOneByAuth(id);
		model.addAttribute("user", user);
		if (user == null) {
			
			model.addAttribute("message", "ID / password가 틀렸습니다.");
			return "reservation/alert";
			
		} else if (id.equals(user.getAuth()) && password.equals(user.getPasswd())) {
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss (EE)");
			
			//cookie값 설정
			Date usetodate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초 (EE)");
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
			
			model.addAttribute("message", "ID / password가 틀렸습니다.");
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

	// 예약목록
	@RequestMapping(value = "/reservation_list", method = RequestMethod.GET)
	public String reservation_list(Locale locale, Model model) {
		logger.info("reservation list");

		List<ReservationVO> reservations = reservationService.getReservation();
		model.addAttribute("reservations", reservations);
		
//		List<ReservationVO> reservations = new ArrayList<>();
//		reservations.add(new ReservationVO("2018-08-22", "(수)", "냠냠", "냠냠", "냠냠"));

//ArrayList 생성 예시
//		reservations.add(new ReservationVO("2018-08-21"));

		return "reservation/d_01";
	}

	// 예약폼
	@RequestMapping(value = "/reservation_form", method = RequestMethod.GET)
	public String reservation_form(Locale locale, @RequestParam Map<String, String> parameter, Model model, HttpSession session) {
		logger.info("reservation form");
		String auth = (String) session.getAttribute("ID");
		
		if (auth == null) {
			model.addAttribute("message", "사용자 정보가 없습니다. 로그인 하십시오.");
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

	// 예약완료
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
			model.addAttribute("message", "당일 예약이 완료된 방입니다. 다른 날짜 / 방을 선택하여 주십시오.");
			return "reservation/alert";
		}

		// src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml 파일 확인
		// 22~24번째 줄 코드 확인하면 return 값인 gongji/list 앞과 뒤에 생략된 값이 있음을 확인할 수 있음
		// /board(기본창?) 까지의 링크 주소의 값은 생략되지 않음
	}
	
	//관리자 페이지
	@RequestMapping(value = "/adm_allview", method = RequestMethod.GET)
	public String admin_allview(Locale locale, @RequestParam Map<String, String> parameter, Model model, HttpSession session) {
		logger.info("adm_allview");
		String admin = (String) session.getAttribute("ID");
		
		if (admin == null) {
			
			model.addAttribute("message", "사용자 정보가 없습니다. 로그인 하십시오.");
			return "reservation/alert";
		} else if (admin.equals("admin")) {
			
			List<ReservationVO> reservations = reservationService.getReservation();
			model.addAttribute("reservations", reservations);
			
			return "reservation/adm_allview";
		} else {
			model.addAttribute("message", "관리자만 접근 가능한 페이지입니다.");
			return "reservation/alert";
		}
	}
	
	// 관리자 예약상세 뷰
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
	
	// 관리자 예약 수정
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
			model.addAttribute("message", "당일 예약이 완료된 방입니다. 다른 날짜 / 방을 선택하여 주십시오.");
			return "reservation/alert";
		}
	}
	
	// 관리자 예약 삭제
	@RequestMapping(value = "/adm_delete", method = RequestMethod.GET)
	public String adm_delete(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
		logger.info("adm_delete");
		
		int key = Integer.parseInt(parameter.get("key"));
		
		Reservation reservation = reservationService.selectOne(key);
		reservationService.deleteOne(key);
		
		model.addAttribute("reservation", reservation);
		return "reservation/adm_delete";
	}
	
	//관리자 로그아웃
	@RequestMapping(value = "/adm_logout")
	public String adm_logout(Model model, HttpSession session) {
		logger.info("adm_logout");
		String admin = (String) session.getAttribute("ID");
		
		if(admin == null) {
			model.addAttribute("message", "현재 로그인 되지 않은 상태입니다. 로그인 하십시오.");
			return "reservation/alert";
			
		}else if (!(session.getAttribute("ID").equals("admin"))) {
			model.addAttribute("message", "관리자만 접근 가능한 페이지입니다.");
			return "reservation/alert";	
		} else  {
			session.invalidate(); 
			model.addAttribute("message", "정상적으로 로그아웃 되었습니다. 좋은 하루 되세요.");
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
