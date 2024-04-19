package travel.travelspring.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import travel.travelspring.domain.Board;
import travel.travelspring.domain.NReply;
import travel.travelspring.domain.Notice;
import travel.travelspring.domain.Reply;
import travel.travelspring.service.AdminService;
import travel.travelspring.service.FileService;
import travel.travelspring.service.NReplyService;
import travel.travelspring.service.NlikeService;
import travel.travelspring.service.NoticeService;

@Slf4j
@Controller
public class NoticeController {
	
	private NoticeService noticeService;
	private FileService fileService;
	private AdminService adminService;

	@Autowired
	public NoticeController(NoticeService noticeService, FileService fileService, AdminService adminService) {
		this.noticeService = noticeService;
		this.fileService = fileService;
		this.adminService = adminService;
	}
	
	// 여행후기 게시판 목록
	@GetMapping("/noticelist.do")
	public String noticelist(
			@RequestParam(value="page", defaultValue = "0") int page,
            @RequestParam(value="size", defaultValue = "10") int size,
            @RequestParam(value="field", required = false) String field,
            @RequestParam(value="kw", required = false) String kw,
			Model model,
			HttpSession session) {
		
		// 관리자 권한 체크(공지사항 작성)
		String nusername = (String)session.getAttribute("sessionId");
		if(nusername != null) {
			if(adminService.checkAdmin(nusername))
				model.addAttribute("admin", true);
		}
		
		if(field != null && kw != null) {
			model.addAttribute("noticeList", noticeService.searchNoticeList(page, size, field, kw));
		}else {
			model.addAttribute("noticeList", noticeService.getNotices(page, size));
		}
		return "/notice/noticelist";
	}
	
	// 여행후기 게시글 작성 폼
	@GetMapping("/noticewriteform.do")
	public String noticewriteform() {
		return "/notice/noticewriteform";
	}
	
	// 여행후기 게시글 작성 처리
	@PostMapping("/noticewrite.do")
	public String writeBoard(@RequestParam("nfilename") MultipartFile file,
						@RequestParam("ntitle") String title,
						@RequestParam("ncontent") String content,
						HttpSession session) {
//		log.info("게시글 작성!");
		String username = (String)session.getAttribute("sessionId");
		String filename = null;
		try {
			filename = fileService.saveFile(file, "notice");
		} catch (IOException e) {
			e.printStackTrace();
		}
		noticeService.writeNotice(username, title, content, filename);
		
		return "redirect:/noticelist.do";
	}
	
	// 여행후기 게시판 상세보기
	@GetMapping("/noticeview.do")
	public String noticeview(@RequestParam("nno") String nno, Model model, HttpSession session) {
//		log.info("여행후기 게시판 상세보기");
		
		//관리자 권한 체크(공지사항 수정, 삭제)
		String nusername = (String)session.getAttribute("sessionId");
		if(nusername != null) {
			if(adminService.checkAdmin(nusername))
				model.addAttribute("admin", true);
		}
		
		
		Notice notice = noticeService.getNoticeOne(Long.parseLong(nno)).get();
		
		// 조회수 증가
		noticeService.increaseNoticeHit(Long.parseLong(nno));
		
		model.addAttribute("notice", notice);
		return "/notice/noticeview";
	}
	
	// 여행후기 게시물 삭제
	@GetMapping("/deletenotice.do")
	public String deleteNotice(@RequestParam("nno") String nno) {
		noticeService.deleteNotice(Long.parseLong(nno));
		return "redirect:/noticelist.do";
	}
	
	// 여행후기 게시물 수정 폼
	@GetMapping("/updatenoticeform.do")
	public String updateNoticeform(@RequestParam("nno") String nno, Model model) {
		Notice notice = noticeService.getNoticeOne(Long.parseLong(nno)).get();
		model.addAttribute("notice", notice);
		return "/notice/updatenoticeform";
	}
	
	// 여행후기 게시물 수정 처리
	@PostMapping("/updatenotice.do")
	public String updateNotice(@RequestParam(value="nfilename", required=false) MultipartFile file,
			@RequestParam("nno") String nno,
			@RequestParam("ntitle") String title,
			@RequestParam("ncontent") String content) {
//		log.info("[updateNotice(Controller)] nno : " + nno  + " title : " + title + " content : " + content + " file : " + file.getOriginalFilename());
		String filename = null;
		try {
			if(file != null)
			filename = fileService.saveFile(file, "notice");
		} catch (IOException e) {
			e.printStackTrace();
		}
		noticeService.updateNotice(Long.parseLong(nno), title, content, filename);
		return "redirect:/noticelist.do";
	}

}
