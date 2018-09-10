//package kr.ac.kopo.danjiresort.web.reservation;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import kr.ac.kopo.danjiresort.domain.Reservation;
//import kr.ac.kopo.danjiresort.domain.Room;
//import kr.ac.kopo.danjiresort.domain.User;
//import kr.ac.kopo.danjiresort.service.ReservationService;
//import kr.ac.kopo.danjiresort.service.RoomService;
//import kr.ac.kopo.danjiresort.service.UserService;
//import kr.ac.kopo.danjiresort.vo.ReservationVO;
//
//@Controller
//public class ReservationControllerBackup {
//
//	private static final Logger logger = LoggerFactory.getLogger(ReservationControllerBackup.class);
//
//	@Autowired
//	private ReservationService reservationService;
//
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private RoomService roomService;
//
//	// home 페이지에서 출력되는 reservation에 걸리는 링크 내용
//	@RequestMapping(value = "/")
//	public String home() {
//		return "redirect:main";
//	}
//
//	@RequestMapping(value = "/main")
//	public String main() {
//
//		return "reservation/main";
//	}
//
//	@RequestMapping(value = "/suitroom")
//	public String suitroom() {
//
//		return "reservation/a_01";
//	}
//
//	@RequestMapping(value = "/doubleroom")
//	public String doubleroom() {
//
//		return "reservation/a_02";
//	}
//
//	@RequestMapping(value = "/singleroom")
//	public String singleroom() {
//
//		return "reservation/a_03";
//	}
//
//	@RequestMapping(value = "/map")
//	public String map() {
//
//		return "reservation/b_01";
//	}
//
//	@RequestMapping(value = "/transport")
//	public String transport() {
//
//		return "reservation/b_02";
//	}
//
//	@RequestMapping(value = "/car")
//	public String car() {
//
//		return "reservation/b_03";
//	}
//
//	@RequestMapping(value = "/mountain")
//	public String mountain() {
//
//		return "reservation/c_01";
//	}
//
//	@RequestMapping(value = "/beach")
//	public String beach() {
//
//		return "reservation/c_02";
//	}
//
//	@RequestMapping(value = "/hotspring")
//	public String hotspring() {
//
//		return "reservation/c_03";
//	}
//
//	// 예약목록
//	@RequestMapping(value = "/reservation_list", method = RequestMethod.GET)
//	public String reservation_list(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
//		// <String, String> : ex)from=n&cnt=n : String 형태이므로 from, cnt 값을 받아오기 위해 이같이 선언
//		// Map(MultiValueMap) : 변수 타입 중 하나
//		// @RequestParam : key=value 형태로 화면에서 넘어오는 쿼리스트링 혹은 폼 데이터를 메소드의 파라미터로 지정
//		logger.info("reservation list");
//
//		// List<Gongji> gongjiList = gongjiService.selectAll();
//		// 페이지네이션 적용 하지 않은 gongjiList 리스트
////		List<Reservation> reservationList = reservationService.selectAll();
////		List<ReservationVO> reservations = new ArrayList<>();
//		Date datetouse = new Date();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		String today = dateFormat.format(datetouse);
//
////		String reservation1 = reservationService.selectReservations(today,  1).getUser().getName();
////		String reservation2 = reservationService.selectReservations(today,  2).getUser().getName();
////		String reservation3 = reservationService.selectReservations(today,  3).getUser().getName();
////		
////		if(reservation1 == null || reservation2 == null || reservation3 == null) {
////			if (reservation1 == null)
////				reservation1 = "예약가능";
////			else if (reservation2 == null)
////				reservation2 = "예약가능";
////			else if (reservation3 == null)
////				reservation3 = "예약가능";
////			List<ReservationVO> reservations = reservationService.setReservation(today, today, reservation1, reservation2, reservation3);
////			model.addAttribute("reservations", reservations );
////		} else {
////			List<ReservationVO> reservations = reservationService.setReservation(today, today, reservation1, reservation2, reservation3);
////			model.addAttribute("reservations", reservations );
////		}
//
//		List<ReservationVO> reservations = reservationService.getReservation();
//		model.addAttribute("reservations", reservations);
//
////		List<ReservationVO> reservations = new ArrayList<>();
////		reservations.add(new ReservationVO("2018-08-22", "(수)", "냠냠", "냠냠", "냠냠"));
//
////ArrayList 생성 예시
////		reservations.add(new ReservationVO("2018-08-21"));
//
//		return "reservation/d_01";
//		// src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml 파일 확인
//		// 22~24번째 줄 코드 확인하면 return 값인 gongji/list 앞과 뒤에 생략된 값이 있음을 확인할 수 있음
//		// /board(기본창?) 까지의 링크 주소의 값은 생략되지 않음
//	}
//
//	// 예약폼
//	@RequestMapping(value = "/reservation_form", method = RequestMethod.GET)
//	public String reservation_form(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
//		logger.info("reservation form");
//
//		String date = parameter.get("date");
//		logger.info("date" + date);
//
//		int room_id = Integer.parseInt(parameter.get("room"));
//		logger.info("room_id" + room_id);
//		model.addAttribute("room_id", room_id);
//
//			User user = userService.selectOne(3);
//			Room room = roomService.selectOne(room_id);
//			List<Room> roomList = roomService.selectAll();
//
//			model.addAttribute("date", date);
//
////			List<User> userList = userService.selectAll();
////		model.addAttribute("userList", userList);
//
//			model.addAttribute("user", user);
//
//			model.addAttribute("room", room);
//			model.addAttribute("roomList", roomList);
//
//			return "reservation/d_02";
//	}
//
//	// 예약완료
//	@RequestMapping(value = "/reservation_result", method = RequestMethod.GET)
//	public String reservation_result(Locale locale, @RequestParam Map<String, String> parameter, Model model)
//			throws ParseException {
//		logger.info("reservation result");
//
//		int user_id = Integer.parseInt(parameter.get("user_id"));
//		int room_id = Integer.parseInt(parameter.get("room_id"));
//		logger.info("user_id" + user_id);
//		logger.info("room_id" + room_id);
//
//		String date_toweb = parameter.get("date");
//		model.addAttribute("date", date_toweb);
//
//		if (reservationService.selectReservationByDate(date_toweb, room_id) == null) {
//			User user = userService.selectOne(user_id);
//			Room room = roomService.selectOne(room_id);
//
//			logger.info("room.id" + room.getId());
//			logger.info("user.id" + user.getId());
//
//			String comment = parameter.get("comment");
//			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(parameter.get("date"));
//
//			Reservation reservation = new Reservation();
//
//			reservation.setUser(user);
//			reservation.setRoom(room);
//			reservation.setComment(comment);
//			reservation.setDate(date);
//
//			reservationService.createOne(reservation);
//
//			model.addAttribute("reservation", reservation);
//			return "reservation/d_02_write";
//		} else {
//			return "reservation/d_02_error";
//		}
//
//		// src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml 파일 확인
//		// 22~24번째 줄 코드 확인하면 return 값인 gongji/list 앞과 뒤에 생략된 값이 있음을 확인할 수 있음
//		// /board(기본창?) 까지의 링크 주소의 값은 생략되지 않음
//	}
//
//}
