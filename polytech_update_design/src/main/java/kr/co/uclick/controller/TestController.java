package kr.co.uclick.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.uclick.entity.Phone;
import kr.co.uclick.entity.User;
import kr.co.uclick.service.PhoneService;
import kr.co.uclick.service.UserService;

@Controller
//클라이언트의 요청 받고, 서비스 호출하고, 봐야할 view 어떻게 뿌려줄 것인지에 대한 역할
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired
	private UserService userService;

	@Autowired
	private PhoneService phoneService;

	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		return "redirect:list";
	}

	@RequestMapping(value = "list")
	public String list(Model model) {
		logger.info("list");

		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);

		return "list";
	}

	@RequestMapping(value = "view")
	public String view(@RequestParam Map<String, String> parameter, Model model) {
		logger.info("view");
		Long key = Long.parseLong(parameter.get("key"));

		User user = userService.findById(key);

		Collection<Phone> phoneList = user.getPhones();

		model.addAttribute("userView", user);
		model.addAttribute("phoneView", phoneList);
		return "view";
	}

	@RequestMapping(value = "insert_user")
	public String insert_user() {

		logger.info("insert_user");
		return "insert_user";
	}

	@RequestMapping(value = "update_user")
	public String update_user(@RequestParam Map<String, String> parameter, Model model) {
		logger.info("update_user");

		Long key = Long.parseLong(parameter.get("key"));
		User user = userService.findById(key);
		model.addAttribute("userUpdate", user);
		return "update_user";
	}

	@RequestMapping(value = "delete_user")
	public String delete_user(@RequestParam Map<String, String> parameter, Model model) {
		logger.info("delete_user");

		Long key = Long.parseLong(parameter.get("key"));
		User user = userService.findById(key);

		try {
			userService.delete(user);

			model.addAttribute("userDelete", user);
			return "delete_user";
		} catch (Exception exception) {
			logger.info("Error Message : " + exception);
			model.addAttribute("userDelete", user);
			return "delete_user_error";
		}

	}

	@RequestMapping(value = "insert_phone")
	public String insert_phone(@RequestParam Map<String, String> parameter, Model model) {
		logger.info("insert_phone");

		Long key = Long.parseLong(parameter.get("key"));
		User user = userService.findById(key);

		List<User> userList = userService.findAll();

		model.addAttribute("insertPhone", user);
		model.addAttribute("userList", userList);

		return "insert_phone";
	}

	@RequestMapping(value = "new_phone")
	public String new_phone(@RequestParam Map<String, String> parameter, Model model) {
		logger.info("new_phone");

		List<User> userList = userService.findAll();
		String searching_phone = parameter.get("searching_phone");

		model.addAttribute("userList", userList);
		model.addAttribute("searching_phone", searching_phone);

		return "new_phone";
	}

	@RequestMapping(value = "update_phone")
	public String update_phone(@RequestParam Map<String, String> parameter, Model model) {
		logger.info("update_phone");

		Long key = Long.parseLong(parameter.get("key"));
		Phone phone = phoneService.findById(key);

		List<User> userList = userService.findAll();

		model.addAttribute("phoneUpdate", phone);
		model.addAttribute("userList", userList);
		return "update_phone";
	}

	@RequestMapping(value = "delete_phone")
	public String delete_phone(@RequestParam Map<String, String> parameter, Model model) {
		logger.info("delete_phone");

		Long key = Long.parseLong(parameter.get("key"));
		Phone phone = phoneService.findById(key);
		phoneService.delete(phone);

		model.addAttribute("phoneDelete", phone);
		return "delete_phone";
	}

	@RequestMapping(value = "write_insert")
	public String write_insert(@RequestParam Map<String, String> parameter, Model model) {
		logger.info("write_insert");
		String type = parameter.get("type");
		if (phoneService.findPhoneByNumber(parameter.get("number")) == null) {
			if (type.equals("insert_user")) {
				String name = parameter.get("name");
				int age = Integer.parseInt(parameter.get("age"));
				String gender = parameter.get("gender");
				String address = parameter.get("address");

				String number = parameter.get("number");
				String telecom_company = parameter.get("telecom_company");

				Date date = new Date();
				String today = dateFormat.format(date);

				User newuser = new User();
				Phone phone = new Phone();

				newuser.setName(name);
				newuser.setAge(age);
				newuser.setGender(gender);
				newuser.setAddress(address);
				newuser.setEnrolldate(today);

				phone.setTelecom_company(telecom_company);
				phone.setNumber(number);
				phone.setUser(newuser);
				phone.setEnrolldate(today);

				userService.save(newuser);

				User user = userService.findById(newuser.getId());
				phoneService.save(phone);

				model.addAttribute("user", user);
			} else if (type.equals("insert_phone")) {
				Phone phone = new Phone();

				String number = parameter.get("number");
				String telecom_company = parameter.get("telecom_company");

				Long user_id = Long.parseLong(parameter.get("user_id"));
				User user = userService.findById(user_id);

				Date date = new Date();
				String today = dateFormat.format(date);

				phone.setNumber(number);
				phone.setTelecom_company(telecom_company);
				phone.setUser(user);
				phone.setEnrolldate(today);

				model.addAttribute("user", user);

				phoneService.save(phone);
			} else if (type.equals("new_phone")) {
				Phone phone = new Phone();

				String number = parameter.get("number");
				String telecom_company = parameter.get("telecom_company");

				String searching_phone = parameter.get("searching_phone");
				logger.info("! : " + searching_phone);

				Long user_id = Long.parseLong(parameter.get("user_id"));
				User user = userService.findById(user_id);

				Date date = new Date();
				String today = dateFormat.format(date);

				phone.setNumber(number);
				phone.setTelecom_company(telecom_company);
				phone.setUser(user);
				phone.setEnrolldate(today);

				phoneService.save(phone);

				model.addAttribute("user", user);
				model.addAttribute("searching_phone", searching_phone);
			}
			model.addAttribute("type", type);
			return "write_insert";
		} else {
			return "duplicate_error";
		}
	}


	@RequestMapping(value = "write_update")
	public String write_update(@RequestParam Map<String, String> parameter, Model model) {
		logger.info("write_update");
		Long key = Long.parseLong(parameter.get("key"));
		String type = parameter.get("type");

		if (type.equals("update_user")) {
			User user = userService.findById(key);

			String name = parameter.get("name");
			int age = Integer.parseInt(parameter.get("age"));
			String gender = parameter.get("gender");
			String address = parameter.get("address");

			user.setName(name);
			user.setAge(age);
			user.setGender(gender);
			user.setAddress(address);

			userService.save(user);

			model.addAttribute("user", user);

		} else if (type.equals("update_phone")) {

			Phone searching_number = phoneService.findPhoneByNumber(parameter.get("number"));
			Phone number_to_update = phoneService.findById(key);

			if (searching_number == null || searching_number.getId() == number_to_update.getId()) {

				String number = parameter.get("number");
				String telecom_company = parameter.get("telecom_company");

				Long user_id = Long.parseLong(parameter.get("user_id"));
				User user = userService.findById(user_id);

				number_to_update.setNumber(number);
				number_to_update.setTelecom_company(telecom_company);
				number_to_update.setUser(user);

				phoneService.save(number_to_update);

				model.addAttribute("user", user);
			} else {
				return "duplicate_error";
			}
		}
		model.addAttribute("key", key);
		model.addAttribute("type", type);
		return "write_update";
	}

	@RequestMapping(value = "search_result")
	public String search(@RequestParam Map<String, String> parameter, Model model) {
		logger.info("search");

		String type = parameter.get("type");

		String searching_user = parameter.get("searching_user");
		String searching_phone = parameter.get("searching_phone");

		if (type.equals("user")) {
			List<User> userList = userService.findUserByNameLike(searching_user);

			model.addAttribute("userList", userList);
			model.addAttribute("searching_user", searching_user);
		} else if (type.equals("phone")) {
			Phone phone = phoneService.findPhoneByNumber(searching_phone);

			model.addAttribute("phone", phone);
			model.addAttribute("searching_phone", searching_phone);
		}
		model.addAttribute("type", type);

//		model.addAttribute("searching_user", searching_user);
//		model.addAttribute("searching_phone", searching_phone);

		return "search_result";
	}
}
