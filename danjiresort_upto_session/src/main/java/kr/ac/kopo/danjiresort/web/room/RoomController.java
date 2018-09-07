package kr.ac.kopo.danjiresort.web.room;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.danjiresort.service.RoomService;

@Controller
public class RoomController {
	
	private static final Logger logger = LoggerFactory.getLogger(RoomController.class);
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping(value = "/room", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("room index");
		
		model.addAttribute("room", roomService.selectOne(1));
		
		return "room/home";
	}
	
}
