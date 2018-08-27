package kr.ac.kopo.board.web.gongji;

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

import kr.ac.kopo.board.domain.Gongji;
import kr.ac.kopo.board.service.GongjiService;
import kr.ac.kopo.board.vo.PaginationVO;

//jdbc.properties db명, username, password 수정해야 db와 연결 가능
@Controller
public class GongjiController {
	
	private static final Logger logger = LoggerFactory.getLogger(GongjiController.class);
	//logger : console 창에 로그 출력	
	
	@Autowired
	private GongjiService gongjiService;
	
	//공지리스트
	@RequestMapping(value = "/gongji_list", method = RequestMethod.GET)
	public String gongji_list(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
		//<String, String> : ex)from=n&cnt=n : String 형태이므로 from, cnt 값을 받아오기 위해 이같이 선언
		//Map(MultiValueMap) : 변수 타입 중 하나
		//@RequestParam : key=value 형태로 화면에서 넘어오는 쿼리스트링 혹은 폼 데이터를 메소드의 파라미터로 지정
		logger.info("gongji list");
		
		int page = 0;
		int itemSizePerPage = 0;
		
		if(parameter.get("page") == null) {
			page = 1;
		} else {
			page = Integer.parseInt(parameter.get("page"));
		}
		
		if(parameter.get("itemSizePerPage") == null) {
			itemSizePerPage = 10;
		} else {
			itemSizePerPage = Integer.parseInt(parameter.get("itemSizePerPage"));
		}
		//현재는 링크창에 입력한 page, itemSizePerPage의 값을 파라미터로 받아옴
		//따라서 데이터베이스에 데이터가 그 수만큼 존재하지 않아도 오류처리 되지 않음
		//null 값 처리하므로 gongji_list까지만 입력해도 list 화면 뜰 수 있도록 설정(수정)
		
		logger.info("page : " + page);
		logger.info("itemSizePerPage : " + itemSizePerPage + "\n");
		
		long count = gongjiService.count();
		//List<Gongji> gongjiList = gongjiService.selectAll();
		//페이지네이션 적용 하지 않은 gongjiList 리스트
		List<Gongji> gongjiList = gongjiService.selectAllByPagination(page, itemSizePerPage);
		//페이지네이션 적용한 gongjiList 리스트
		
		model.addAttribute("page", page );
		model.addAttribute("itemSizePerPage", itemSizePerPage );
		model.addAttribute("count", count );
		model.addAttribute("gongjiList", gongjiList );
		//웹에 받아온 파라미터 값을 출력할 수 있도록 model 객체 활용
		
		PaginationVO paginationVO = gongjiService.calcPagination(page, itemSizePerPage);
		model.addAttribute("paginationVO", paginationVO );
		
		return "gongji/list";
		//src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml 파일 확인
		//22~24번째 줄 코드 확인하면 return 값인 gongji/list 앞과 뒤에 생략된 값이 있음을 확인할 수 있음
		// /board(기본창?) 까지의 링크 주소의 값은 생략되지 않음
	}
	
	//공지뷰
	@RequestMapping(value = "/gongji_view", method = RequestMethod.GET)
	public String gongji_view(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
		logger.info("gongji view");
		
		int key = Integer.parseInt(parameter.get("key"));
		
		logger.info("key : " + key + "\n");

		Gongji gongjiView = gongjiService.selectOne(key);

			int viewcnt = gongjiView.getViewcnt() +1;
			gongjiView.setViewcnt(viewcnt);

			gongjiService.updateOne(gongjiView);

			model.addAttribute("gongjiView", gongjiView);
		
		return "gongji/view";
	}
	
	//게시글 생성
	@RequestMapping(value = "/gongji_insert", method = RequestMethod.GET)
	public String gongji_insert(Locale locale, @RequestParam Map<String, String> parameter, Model model) throws Exception {
		logger.info("gongji insert\n");
		
		Date today_date = new Date();
		model.addAttribute("today_date", today_date);
		
		return "gongji/insert";
	}
	
	@RequestMapping(value = "/gongji_wrtie_insert", method = RequestMethod.POST)
	public String gongji_wrtie_insert(Locale locale, @RequestParam Map<String, String> parameter) throws Exception {
		logger.info("gongji write_insert\n");
		
		Gongji gongjiInsert = new Gongji();
		
		String title = parameter.get("title");
		String content = parameter.get("content");

		Date today_date = new Date();

		gongjiInsert.setTitle(title);
		gongjiInsert.setContent(content);
		gongjiInsert.setDate(today_date);
		gongjiInsert.setRelevel(0);
		gongjiInsert.setRecnt(0);
		
		int rootid = gongjiService.createOne(gongjiInsert);
		gongjiInsert.setRootid(rootid);
		gongjiService.updateOne(gongjiInsert);
		
		logger.info("title : " + title);
		logger.info("rootid : " + rootid);
		logger.info("insert date : " + today_date + "\n");
		
		return "gongji/write_insert";
	}	
	
	//댓글 생성
	@RequestMapping(value = "/gongji_reinsert", method = RequestMethod.GET)
	public String gongji_reinsert(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
		logger.info("gongji reinsert");
		
		int key = Integer.parseInt(parameter.get("key"));
		
		logger.info("key : " + key);

		Gongji gongjiReinsert = gongjiService.selectOne(key);
		
		int recnt = gongjiService.selectRecnt(gongjiReinsert.getRootid(), gongjiReinsert.getRelevel(), gongjiReinsert.getRecnt());
		
		gongjiReinsert.setParent(gongjiReinsert);
		
		Date today_date = new Date();
		model.addAttribute("today_date", today_date);
		model.addAttribute("recnt", recnt);
		model.addAttribute("gongjiReinsert", gongjiReinsert);
		
		logger.info("recnt : " + recnt);
		logger.info("parent : " + key + "\n");

		return "gongji/reinsert";
	}
	
	@RequestMapping(value = "/gongji_wrtie_reinsert", method = RequestMethod.POST)
	public String gongji_wrtie_reinsert(Locale locale, @RequestParam Map<String, String> parameter) throws Exception {
		logger.info("gongji write_reinsert");
		
		Gongji gongjiReinsert = new Gongji();

		String title = parameter.get("title");
		String content = parameter.get("content");
		Date today_date = new Date();
		
		//1 더해진 값을 파라미터 값으로 받아와 정수형으로 형변환
		int rootid = Integer.parseInt(parameter.get("rootid"));
		int relevel = Integer.parseInt(parameter.get("relevel"));
		int recnt = Integer.parseInt(parameter.get("recnt"));

		//각 column의 값을 set으로 입력되도록 설정
		gongjiReinsert.setTitle(title);
		gongjiReinsert.setContent(content);
		gongjiReinsert.setDate(today_date);
		gongjiReinsert.setRootid(rootid);
		gongjiReinsert.setRelevel(relevel);
		gongjiReinsert.setRecnt(recnt);
		gongjiReinsert.setViewcnt(0);
		
		gongjiService.updateRecnt(rootid, recnt);
		
		int parent = Integer.parseInt(parameter.get("parent"));
		Gongji gongji = gongjiService.selectOne(parent);
		gongjiReinsert.setParent(gongji);	

		gongjiService.createOne(gongjiReinsert);

		logger.info("title : " + title);
		logger.info("reinsert date : " + today_date);
		logger.info("rootid : " + rootid);		
		logger.info("relevel : " + relevel);	
		logger.info("recnt : " + recnt);
		logger.info("parent : " + gongji.getId() + "\n");		
		
		return "gongji/write_reinsert";
	}
	
	//게시글*댓글 수정
	@RequestMapping(value = "/gongji_update", method = RequestMethod.GET)
    public String gongji_update(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
        logger.info("gongji update");
        
        int key = Integer.parseInt(parameter.get("key"));
        
        logger.info("key : " + key + "\n");
        
        Gongji gongjiUpdate = gongjiService.selectOne(key);
        
        model.addAttribute("gongjiUpdate", gongjiUpdate);
        
        Date update_date = new Date();
		model.addAttribute("update_date", update_date);
        
        return "gongji/update";
    }
    
    @RequestMapping(value = "/gongji_wrtie_update", method = RequestMethod.POST)
    public String gongji_wrtie_update(Locale locale, @RequestParam Map<String, String> parameter, Model model) throws Exception {
        logger.info("gongji wrtie_update");
        
        int key = Integer.parseInt(parameter.get("key"));
        
        logger.info("key : " + key + "\n");
        
        Gongji gongjiUpdate = gongjiService.selectOne(key);
        
        Date update_date = new Date();

        gongjiUpdate.setTitle(parameter.get("title"));
        gongjiUpdate.setContent(parameter.get("content"));
        gongjiUpdate.setDate(update_date);
        
        logger.info("update_date : " + update_date + "\n");

        gongjiService.updateOne(gongjiUpdate);
        
        model.addAttribute("gongjiUpdate", gongjiUpdate);
        
        return "gongji/write_update";
    }
	
    //게시글*댓글 삭제
	@RequestMapping(value = "/gongji_delete", method = RequestMethod.GET)
	public String gongji_delete(Locale locale, @RequestParam Map<String, String> parameter, Model model) {
		logger.info("gongji delete");
		
		int key = Integer.parseInt(parameter.get("key"));
		
		logger.info("key : " + key + "\n");

		Gongji gongjiDelete = gongjiService.selectOne(key);
		int endrecnt = gongjiService.selectRecnt(gongjiDelete.getRootid(), gongjiDelete.getRelevel(), gongjiDelete.getRecnt());
        gongjiService.deleteGongji(gongjiDelete.getRootid(),gongjiDelete.getRecnt(), endrecnt);

		model.addAttribute("gongjiDelete", gongjiDelete);
		
		return "gongji/delete";
	}
}
