package travel.travelspring.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import travel.travelspring.domain.Blike3;
import travel.travelspring.domain.Board3;
import travel.travelspring.domain.Reply3;
import travel.travelspring.service.AdminService;
import travel.travelspring.service.Blike3Service;
import travel.travelspring.service.Board3Service;
import travel.travelspring.service.FileService;
import travel.travelspring.service.Reply3Service;

@Slf4j
@Controller
public class Board3Controller {
	
	private Board3Service board3Service;
	private FileService fileService;
	private Reply3Service reply3Service;
	private Blike3Service blike3Service;
	private AdminService adminService;

	@Autowired
	public Board3Controller(Board3Service board3Service, FileService fileService, Reply3Service reply3Service, Blike3Service blike3Service,AdminService adminService) {
		this.board3Service = board3Service;
		this.fileService = fileService;
		this.reply3Service = reply3Service;
		this.blike3Service = blike3Service;
		this.adminService = adminService;
	}
	
	// Q&A 게시판 목록
	@GetMapping("/board3list.do")
	public String boardlist(
			@RequestParam(value="page", defaultValue = "0") int page,
            @RequestParam(value="size", defaultValue = "10") int size,
            @RequestParam(value="field", required = false) String field,
            @RequestParam(value="kw", required = false) String kw,
			Model model) {
		
		
		if(field != null && kw != null) {
			model.addAttribute("boardList3", board3Service.searchBoardList(page, size, field, kw));
		}else {
			model.addAttribute("boardList3", board3Service.getBoards(page, size));
		}
		return "/board3/board3list";
	}
	
	// Q&A 게시글 작성 폼
	@GetMapping("/write3form.do")
	public String writeform() {
		return "/board3/write3form";
	}
	
	// Q&A 게시글 작성 처리
	@PostMapping("/write3.do")
	public String writeBoard(@RequestParam("filename3") MultipartFile file,
						@RequestParam("title3") String title,
						@RequestParam("content3") String content,
						HttpSession session) {
//		log.info("게시글 작성!");
		String username = (String)session.getAttribute("sessionId");
		String filename = null;
		try {
			filename = fileService.saveFile(file, "board3");
		} catch (IOException e) {
			e.printStackTrace();
		}
		board3Service.writeBoard(username, title, content, filename);
		
		return "redirect:/board3list.do";
	}
	
	// Q&A 게시판 상세보기
	@GetMapping("/board3view.do")
	public String boardview(@RequestParam("bno3") String bno, Model model, HttpSession session) {
//		log.info("Q&A 게시판 상세보기");
		Board3 board = board3Service.getBoardOne(Long.parseLong(bno)).get();
		List<Reply3> replyList = reply3Service.getReplyListByBno(Long.parseLong(bno));
		
		// 조회수 증가
		board3Service.increaseBoardHit(Long.parseLong(bno));
		
		//관리자 권한 체크(Q&A 댓글 작성, 수정, 삭제)
		String nusername = (String)session.getAttribute("sessionId");
		if(nusername != null) {
			if(adminService.checkAdmin(nusername))
				model.addAttribute("admin", true);
		}
		
		model.addAttribute("board3", board);
		model.addAttribute("replyList3", replyList);
		return "/board3/board3view";
	}
	
	// Q&A 게시물 삭제
	@GetMapping("/deleteboard3.do")
	public String deleteBoard(@RequestParam("bno3") String bno) {
		board3Service.deleteBoard(Long.parseLong(bno));
		return "redirect:/board3list.do";
	}
	
	// Q&A 게시물 수정 폼
	@GetMapping("/updateboard3form.do")
	public String updateBoardform(@RequestParam("bno3") String bno, Model model) {
		Board3 board = board3Service.getBoardOne(Long.parseLong(bno)).get();
		model.addAttribute("board3", board);
		return "/board3/updateboard3form";
	}
	
	// Q&A 게시물 수정 처리
	@PostMapping("/updateboard3.do")
	public String updateBoard(@RequestParam("filename3") MultipartFile file,
			@RequestParam("bno3") String bno,
			@RequestParam("title3") String title,
			@RequestParam("content3") String content) {
		log.info("[updateboard3(Controller)] bno : " + bno  + " title : " + title + " content : " + content + " file : " + file.getOriginalFilename());
		String filename = null;
		try {
			filename = fileService.saveFile(file, "board");
		} catch (IOException e) {
			e.printStackTrace();
		}
		board3Service.updateBoard(Long.parseLong(bno), title, content, filename);
		return "redirect:/board3list.do";
	}
	
	// Q&A 게시물 댓글 작성
	@PostMapping("/insertreply3.do")
	public String insertreply(@RequestParam("bno3") String bno,
							@RequestParam("replyer3") String replyer,
							@RequestParam("rcontent3") String rcontent) {
		reply3Service.insertReply(Long.parseLong(bno), rcontent, replyer);
		return "redirect:/board3view.do?bno3=" + bno;
	}
	
	// Q&A 게시물 댓글 수정 폼
	@GetMapping("/updatereply3form.do")
	public String updatereplyform(@RequestParam("bno3") String bno,
								@RequestParam("rno3") String rno,
								Model model) {
		Reply3 reply = reply3Service.getReplyOne(Long.parseLong(rno));
		model.addAttribute("reply3",reply);
		return "/board3/updatereply3form";
	}
	
	// Q&A 게시물 댓글 수정 처리
	@PostMapping("/updatereply3.do")
	public String updatereply(@RequestParam("bno3") String bno,
							@RequestParam("rno3") String rno,
							@RequestParam("rcontent3") String rcontent) {
		reply3Service.updateReply(Long.parseLong(rno), rcontent);
		return "redirect:/board3view.do?bno3=" + bno;
	}
	
	// Q&A 게시물 댓글 삭제 처리
	@GetMapping("/deletereply3.do")
	public String deletereply(@RequestParam("bno3") String bno,
							 @RequestParam("rno3") String rno) {
		reply3Service.deleteReply(Long.parseLong(rno), Long.parseLong(bno));
		return "redirect:/board3view.do?bno3=" + bno;
	}
	
	// 게시글 좋아요
	@GetMapping("/like3.do")
	public String like(@RequestParam("bno3") String bno,
					  @RequestParam("id3") String username) {
		if(blike3Service.checkLikeByBno(Long.parseLong(bno), username)) {
			blike3Service.deleteLike(Long.parseLong(bno), username);
		}else {
			blike3Service.like(Long.parseLong(bno), username);
		}
		return "redirect:/board3view.do?bno3=" + bno;
	}
	
	// 찜한 목록에서 좋아요 누른 게시글들 조회
	@GetMapping("/board3listBlike.do")
	public String board3listBlike(@RequestParam("id") String id,
			Model model) {
			
			
			List<Blike3> myBlikes = blike3Service.getMyLikes(id);
			List<Board3> boardList = new ArrayList<>();
			if(myBlikes != null) {
				for(Blike3 myBlike : myBlikes) {
					Board3 board = board3Service.getBoardOne(myBlike.getBno3()).get();
					boardList.add(board);
				}
			}
			
			model.addAttribute("boardList3", boardList);
			return "/board3/board3wishlist";
	}

}
