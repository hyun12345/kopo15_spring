package kr.co.uclick.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.uclick.entity.Sample;
import kr.co.uclick.service.SampleService;

@Controller
//클라이언트의 요청 받고, 서비스 호출하고, 봐야할 view 어떻게 뿌려줄 것인지에 대한 역할
//jsp : view
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

	@Autowired
	private SampleService sampleService;
	//의존도 삽입?

//	@RequestMapping(value = "sample.html")
//	//sample.html이 등록되어있으므로 호출되면 아래메소드 실행
//	public String sample(Model model) {
//		model.addAttribute("samples", sampleService.findAll());
//		//호출시 ssampleService의 findAll() 메소드 실행
//		return "sample";
//	}
//
//	@RequestMapping(value = "list.html")
//	public String list(Model model) {
//		model.addAttribute("users", sampleService.findAll());
//		return "list";
//	}
	
	@RequestMapping(value = "cache")
	public String cache(Model model) {

		
		StopWatch sw = new StopWatch();
		sw.start();
		Sample sample = sampleService.selectOne(1L);
		model.addAttribute("sample", sample);
		sw.stop();
		
		System.out.println("-**<<TOTAL TIME : " + sw.getTotalTimeSeconds() + ">>**-");
		
		return "cache";
	}
//
//	@RequestMapping(value = "newForm.html")
//	public String newForm(Model model) {
//		return "newForm";
//	}
//
//	@RequestMapping(value = "editForm.html")
//	public String editForm(Long sampleId, Model model) {
//		sampleService.findById(sampleId);
//		return "editForm";
//	}
//
//	@RequestMapping(value = "save.html")
//	public String save(Sample sample, Model model) {
//		return "redirect:list.html";
//	}
//
//	@RequestMapping(value = "delete.html")
//	public String delete(Long sampleId, Model model) {
//		return "redirect:list.html";
//	}

	@RequestMapping(value = "sample")
	public String sample(String name, Sample sample, Model model) {

		logger.debug("sample name : {}", name);
		logger.debug("Sample.name : {}", sample.getName());

		model.addAttribute("samples", sampleService.findAll());
		model.addAttribute("sample", sample);
		model.addAttribute("findSampleByName", sampleService.findSampleByName(name));
		return "sample";
	}
}
