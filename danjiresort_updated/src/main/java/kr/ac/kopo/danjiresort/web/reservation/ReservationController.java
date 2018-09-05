package kr.ac.kopo.danjiresort.web.reservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		return "redirect:main";
	}

	@RequestMapping(value = "/main")
	public String main() {

		return "reservation/main";
	}

	@RequestMapping(value = "/suitroom")
	public String suitroom() {

		return "reservation/a_01";
	}

	@RequestMapping(value = "/doubleroom")
	public String doubleroom() {

		return "reservation/a_02";
	}

	@RequestMapping(value = "/singleroom")
	public String singleroom() {

		return "reservation/a_03";
	}

	@RequestMapping(value = "/map")
	public String map() {

		return "reservation/b_01";
	}

	@RequestMapping(value = "/transport")
	public String transport() {

		return "reservation/b_02";
	}

	@RequestMapping(value = "/car")
	public String car() {

		return "reservation/b_03";
	}

	@RequestMapping(value = "/mountain")
	public String mountain() {

		return "reservation/c_01";
	}

	@RequestMapping(value = "/beach")
	public String beach() {

		return "reservation/c_02";
	}

	@RequestMapping(value = "/hotspring")
	public String hotspring() {

		return "reservation/c_03";
	}

	// ������
	@RequestMapping(value = "/reservation_list", method = RequestMethod.GET)
	public String reservation_list(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
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
	public String reservation_form(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
		logger.info("reservation form");

		if (parameter.get("room") != null) {
			String date = parameter.get("date");
			logger.info("date" + date);

			int room_id = Integer.parseInt(parameter.get("room"));
			logger.info("room_id" + room_id);
			model.addAttribute("room_id", room_id);

			User user = userService.selectOne(3);
			Room room = roomService.selectOne(room_id);
			List<Room> roomList = roomService.selectAll();

			model.addAttribute("date", date);

//			List<User> userList = userService.selectAll();
//		model.addAttribute("userList", userList);

			model.addAttribute("user", user);

			model.addAttribute("room", room);
			model.addAttribute("roomList", roomList);

			return "reservation/d_02";
		} else {
			return "reservation/error";
		}
	}

	// ����Ϸ�
	@RequestMapping(value = "/reservation_result", method = RequestMethod.GET)
	public String reservation_result(Locale locale, @RequestParam Map<String, String> parameter, Model model)
			throws ParseException {
		logger.info("reservation result");

		int user_id = Integer.parseInt(parameter.get("user_id"));
		int room_id = Integer.parseInt(parameter.get("room_id"));
		logger.info("user_id" + user_id);
		logger.info("room_id" + room_id);

		String date_toweb = parameter.get("date");
		model.addAttribute("date", date_toweb);

		if (reservationService.selectReservationByDate(date_toweb, room_id) == null) {
			User user = userService.selectOne(user_id);
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
			String type = parameter.get("type");
			model.addAttribute("type", type);
			return "reservation/error";
		}

		// src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml ���� Ȯ��
		// 22~24��° �� �ڵ� Ȯ���ϸ� return ���� gongji/list �հ� �ڿ� ������ ���� ������ Ȯ���� �� ����
		// /board(�⺻â?) ������ ��ũ �ּ��� ���� �������� ����
	}

}
