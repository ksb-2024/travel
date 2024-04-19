package travel.travelspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import travel.travelspring.service.AdminService;

@Controller
public class AdminController {
	
	private AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	// 로그인 첫 화면
	@GetMapping("/adminloginform.do")
	public String adminloginForm() {
		return "adminloginform";
	}
	
	// 로그인 버튼 눌렀을때 처리 및 이동
	@PostMapping("/adminlogin.do")
	public String adminloginProcess(@RequestParam("id") String id,
			   @RequestParam("pw") String pw, Model model,HttpSession session) {
		
		// 데이터 입력 확인 코드
//			log.info("id : " + id);
//			log.info("pw : " + pw);
		//log.info("아직 그냥 메인페이지로 보냄");
		
		boolean loginPass = adminService.checkAdminPw(id, pw);
//			log.info("loginPass : " + loginPass);
		if(loginPass) {
			session.setAttribute("sessionId", id);
			return "main";
		}else {
			return "redirect:/";
		}
	}
	
}
