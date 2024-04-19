package travel.travelspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThirdSideController {

	@GetMapping("/ccc.do")
	public String ccc() {
		return "/about/ccc";
	}
	
	@GetMapping("/membership.do")
	public String membership() {
		return "/about/membership";
	}
	
	@GetMapping("/fao.do")
	public String fao() {
		return "/about/fao";
	}
}
