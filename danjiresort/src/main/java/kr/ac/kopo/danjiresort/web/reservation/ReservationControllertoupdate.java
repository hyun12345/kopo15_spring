package kr.ac.kopo.danjiresort.web.reservation;
//package kr.ac.kopo.board.web.gongji;
//
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
//import kr.ac.kopo.board.domain.Reservation;
//import kr.ac.kopo.board.domain.User;
//import kr.ac.kopo.board.service.GongjiService;
//import kr.ac.kopo.board.vo.PaginationVO;
//
////jdbc.properties db��, username, password �����ؾ� db�� ���� ����
//
//@Controller
//public class GongjiController {
//	
////	private static final Logger logger = LoggerFactory.getLogger(GongjiController.class);
////	//logger : console â�� �α� ���	
////	
////	@Autowired
////	private GongjiService gongjiService;
////	
////	//��������Ʈ
////	@RequestMapping(value = "/gongji_list", method = RequestMethod.GET)
////	public String gongji_list(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
////		//<String, String> : ex)from=n&cnt=n : String �����̹Ƿ� from, cnt ���� �޾ƿ��� ���� �̰��� ����
////		//Map(MultiValueMap) : ���� Ÿ�� �� �ϳ�
////		//@RequestParam : key=value ���·� ȭ�鿡�� �Ѿ���� ������Ʈ�� Ȥ�� �� �����͸� �޼ҵ��� �Ķ���ͷ� ����
////		logger.info("gongji list");
////		
////		int page = 0;
////		int itemSizePerPage = 0;
////		
////		if(parameter.get("page") == null) {
////			page = 1;
////		} else {
////			page = Integer.parseInt(parameter.get("page"));
////		}
////		
////		if(parameter.get("itemSizePerPage") == null) {
////			itemSizePerPage = 10;
////		} else {
////			itemSizePerPage = Integer.parseInt(parameter.get("itemSizePerPage"));
////		}
////		//����� ��ũâ�� �Է��� page, itemSizePerPage�� ���� �Ķ���ͷ� �޾ƿ�
////		//���� �����ͺ��̽��� �����Ͱ� �� ����ŭ �������� �ʾƵ� ����ó�� ���� ����
////		//null �� ó���ϹǷ� gongji_list������ �Է��ص� list ȭ�� �� �� �ֵ��� ����(����)
////		
////		logger.info("page : " + page);
////		logger.info("itemSizePerPage : " + itemSizePerPage + "\n");
////		
////		long count = gongjiService.count();
////		//List<Gongji> gongjiList = gongjiService.selectAll();
////		//���������̼� ���� ���� ���� gongjiList ����Ʈ
////		List<Reservation> gongjiList = gongjiService.selectAllByPagination(page, itemSizePerPage);
////		//���������̼� ������ gongjiList ����Ʈ
////		
////		model.addAttribute("page", page );
////		model.addAttribute("itemSizePerPage", itemSizePerPage );
////		model.addAttribute("count", count );
////		model.addAttribute("gongjiList", gongjiList );
////		//���� �޾ƿ� �Ķ���� ���� ����� �� �ֵ��� model ��ü Ȱ��
////		
////		PaginationVO paginationVO = gongjiService.calcPagination(page, itemSizePerPage);
////		model.addAttribute("paginationVO", paginationVO );
////		
////		return "gongji/list";
////		//src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml ���� Ȯ��
////		//22~24��° �� �ڵ� Ȯ���ϸ� return ���� gongji/list �հ� �ڿ� ������ ���� ������ Ȯ���� �� ����
////		// /board(�⺻â?) ������ ��ũ �ּ��� ���� �������� ����
////	}
////	
////	//������
////	@RequestMapping(value = "/gongji_view", method = RequestMethod.GET)
////	public String gongji_view(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
////		logger.info("gongji view");
////		
////		int key = Integer.parseInt(parameter.get("key"));
////		
////		logger.info("key : " + key + "\n");
////
////		Reservation gongjiView = gongjiService.selectOne(key);
//////		Gongji gongjiView = gongjiService.selectOnewithCheckPoint(1, 382);
////
//////		if (gongjiView != null) {
////			int viewcnt = gongjiView.getViewcnt() +1;
////			gongjiView.setViewcnt(viewcnt);
////
////			gongjiService.updateOne(gongjiView);
//////		}
////		
////		model.addAttribute("gongjiView", gongjiView);
////		
////		return "gongji/view";
////	}
////	
////	//�Խñ� ����
////	@RequestMapping(value = "/gongji_insert", method = RequestMethod.GET)
////	public String gongji_insert(Locale locale, @RequestParam Map<String, String> parameter, Model model) throws Exception {
////		logger.info("gongji insert\n");
////		
////		Date today_date = new Date();
////		model.addAttribute("today_date", today_date);
////		
////		return "gongji/insert";
////	}
////	
////	@RequestMapping(value = "/gongji_wrtie_insert", method = RequestMethod.POST)
////	public String gongji_wrtie_insert(Locale locale, @RequestParam Map<String, String> parameter) throws Exception {
////		logger.info("gongji write_insert\n");
////		
////		Reservation gongjiInsert = new Reservation();
////		
////		String title = parameter.get("title");
////		String content = parameter.get("content");
//////		int userId = Integer.parseInt(parameter.get("userId"));
////		
//////		User userId_2 = gongjiInsert.getUser(); => null
//////		User user = userService.selectOne(userId);
//////		User user = new User();
//////		int userId = user.getId();
////		
////		Date today_date = new Date();
////
////		gongjiInsert.setTitle(title);
//////		gongjiInsert.getUser();
////		gongjiInsert.setContent(content);
////		gongjiInsert.setDate(today_date);
////		gongjiInsert.setRelevel(0);
////		gongjiInsert.setRecnt(0);
////		
////		logger.info("title : " + title);
//////		logger.info("userId : " + userId_2 + ", " + userId);
////		logger.info("insert date : " + today_date + "\n");
////		
////		
////		gongjiInsert.setRootid(gongjiInsert);
////		gongjiService.createOne(gongjiInsert);
////		
////		return "gongji/write_insert";
////	}	
////	
////	//��� ����
////	@RequestMapping(value = "/gongji_reinsert", method = RequestMethod.GET)
////	public String gongji_reinsert(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
////		logger.info("gongji reinsert");
////		
////		int key = Integer.parseInt(parameter.get("key"));
////		
////		logger.info("key : " + key);
////
////		Reservation gongjiReinsert = gongjiService.selectOne(key);
////		
////		
////		int recnt = gongjiService.selectRecnt(gongjiReinsert.getRootid(), gongjiReinsert.getRelevel(), gongjiReinsert.getRecnt());
////		
////		gongjiReinsert.setParent(gongjiReinsert);
////		
////		Date today_date = new Date();
////		model.addAttribute("today_date", today_date);
////		model.addAttribute("recnt", recnt);
////		model.addAttribute("gongjiReinsert", gongjiReinsert);
////		
////		logger.info("recnt : " + recnt);
////		logger.info("parent : " + key + "\n");
////		
////
////		return "gongji/reinsert";
////	}
////	
////	@RequestMapping(value = "/gongji_wrtie_reinsert", method = RequestMethod.POST)
////	public String gongji_wrtie_reinsert(Locale locale, @RequestParam Map<String, String> parameter) throws Exception {
////		logger.info("gongji write_reinsert");
////		
////		Reservation gongjiReinsert = new Reservation();
////
////		String title = parameter.get("title");
////		String content = parameter.get("content");
////		Date today_date = new Date();
////		
////		//Gongji ��ü rootid �����Ͽ� rootid_int�� ���� �޾ƿ����� selectOne �޼ҵ忡 ����
////		//Gongji rootid = gongjiService.selectOne(rootid_int);
////		
////		int parent = Integer.parseInt(parameter.get("parent"));
////		Reservation gongji = gongjiService.selectOne(parent);
////
//////		Gongji parent = null;
////
//////		if (rootid_int == parent_int) {
//////			parent = rootid;
//////		} else if (rootid_int != parent_int) {
//////		}
////		
////		//1 ������ ���� �Ķ���� ������ �޾ƿ� ���������� ����ȯ
////		int rootid = Integer.parseInt(parameter.get("rootid"));
////		int relevel = Integer.parseInt(parameter.get("relevel"));
////		int recnt = Integer.parseInt(parameter.get("recnt"));
////
////		//�� column�� ���� set���� �Էµǵ��� ����
////		gongjiReinsert.setTitle(title);
////		gongjiReinsert.setContent(content);
////		gongjiReinsert.setDate(today_date);
////		gongjiReinsert.setRootid(gongji.getRootid());
////		gongjiReinsert.setRelevel(relevel);
////		gongjiReinsert.setRecnt(recnt);
////		gongjiReinsert.setParent(gongji);	
////		
////		gongjiService.updateRecnt(rootid, recnt);
////		gongjiService.createOne(gongjiReinsert);
////
////		
////		logger.info("title : " + title);
////		logger.info("reinsert date : " + today_date);
////		logger.info("rootid : " + gongji.getRootid().getId());		
////		logger.info("relevel : " + relevel);	
////		logger.info("recnt : " + recnt);
////		logger.info("parent : " + gongji.getId() + "\n");		
////		
////		return "gongji/write_reinsert";
////	}
////	
////	//�Խñ�*��� ����
////	@RequestMapping(value = "/gongji_update", method = RequestMethod.GET)
////    public String gongji_update(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
////        logger.info("gongji update");
////        
////        int key = Integer.parseInt(parameter.get("key"));
////        
////        logger.info("key : " + key + "\n");
////        
////        Reservation gongjiUpdate = gongjiService.selectOne(key);
////        
////        model.addAttribute("gongjiUpdate", gongjiUpdate);
////        
////        Date update_date = new Date();
////		model.addAttribute("update_date", update_date);
////        
////        return "gongji/update";
////    }
////    
////    @RequestMapping(value = "/gongji_wrtie_update", method = RequestMethod.POST)
////    public String gongji_wrtie_update(Locale locale, @RequestParam Map<String, String> parameter, Model model) throws Exception {
////        logger.info("gongji wrtie_update");
////        
////        int key = Integer.parseInt(parameter.get("key"));
////        
////        logger.info("key : " + key + "\n");
////        
////        Reservation gongjiUpdate = gongjiService.selectOne(key);
////        
////        Date update_date = new Date();
////
////        gongjiUpdate.setTitle(parameter.get("title"));
////        gongjiUpdate.setContent(parameter.get("content"));
////        gongjiUpdate.setDate(update_date);
////        
////        logger.info("update_date : " + update_date + "\n");
////
////        gongjiService.updateOne(gongjiUpdate);
////        
////        model.addAttribute("gongjiUpdate", gongjiUpdate);
////        
////        return "gongji/write_update";
////    }
////	
////    //�Խñ�*��� ����
////	@RequestMapping(value = "/gongji_delete", method = RequestMethod.GET)
////	public String gongji_delete(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
////		logger.info("gongji delete");
////		
////		int key = Integer.parseInt(parameter.get("key"));
////		
////		logger.info("key : " + key + "\n");
////
////		Reservation gongjiDelete = gongjiService.selectOne(key);
////		int endrecnt = gongjiService.selectRecnt(gongjiDelete.getRootid(), gongjiDelete.getRelevel(), gongjiDelete.getRecnt());
////        gongjiService.deleteGongji(gongjiDelete.getRootid(),gongjiDelete.getRecnt(), endrecnt);
////
////		model.addAttribute("gongjiDelete", gongjiDelete);
////		
//////		gongjiService.deleteOne(gongjiDelete);
////
////		return "gongji/delete";
////	}
//}
