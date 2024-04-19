package travel.travelspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import travel.travelspring.service.UserService;

@Slf4j
@RestController
public class MainRestController {
	
	private UserService userService;

	@Autowired
	public MainRestController(UserService userService) {
		this.userService = userService;
	}

	// 중복 아이디 체크
	@GetMapping("/validateID/{checkId}")
	@ResponseBody
	public String validateId(@PathVariable("checkId") String id) {
//		log.info("id : " + id); 
		String pass = "duplicate";
		
		if(!userService.isDuplicateUser(id)) pass = "OK";
		
//		log.info("pass : " + pass);
		return pass;
	}
}
