package travel.travelspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstSideController {

	/**
	 * 
	 * 국내
	 */
	
	@GetMapping("/travel/in_main")
	public String in_main() {
		return "/travel/in_main";
	}
	
	@GetMapping("/travel/gangneung")
	public String gangneung() {
		return "/travel/gangneung";
	}
	
	@GetMapping("/travel/seoul")
	public String seoul() {
		return "/travel/seoul";
	}
	
	@GetMapping("/travel/jeju")
	public String jeju() {
		return "/travel/jeju";
	}
	
	@GetMapping("/travel/busan")
	public String busan() {
		return "/travel/busan";
	}
	
	
	/**
	 * 
	 * 해외
	 */
	
	@GetMapping("/travel/out_main")
	public String out_main() {
		return "/travel/out_main";
	}
	
	@GetMapping("/travel/unitedKingdom")
	public String unitedKingdom() {
		return "/travel/unitedKingdom";
	}
	
	@GetMapping("/travel/switzerland")
	public String switzerland() {
		return "/travel/switzerland";
	}
	
	@GetMapping("/travel/japan")
	public String japan() {
		return "/travel/japan";
	}
	
	@GetMapping("/travel/australia")
	public String australia() {
		return "/travel/australia";
	}
	
	/**
	 * 
	 * 숙소 교통
	 */
	
	@GetMapping("/travel/hotel_traffic")
	public String hotel_traffic() {
		return "/travel/hotel_traffic";
	}
}
