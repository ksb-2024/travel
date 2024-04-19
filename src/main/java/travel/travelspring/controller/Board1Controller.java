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
import travel.travelspring.domain.Blike;
import travel.travelspring.domain.Blike1;
import travel.travelspring.domain.Board1;
import travel.travelspring.domain.Reply1;
import travel.travelspring.service.Blike1Service;
import travel.travelspring.service.Board1Service;
import travel.travelspring.service.FileService;
import travel.travelspring.service.Reply1Service;

@Slf4j
@Controller
public class Board1Controller {
	
	private Board1Service board1Service;
	private FileService fileService;
	private Reply1Service reply1Service;
	private Blike1Service blike1Service;

	@Autowired
	public Board1Controller(Board1Service board1Service, FileService fileService, Reply1Service reply1Service, Blike1Service blike1Service) {
		this.board1Service = board1Service;
		this.fileService = fileService;
		this.reply1Service = reply1Service;
		this.blike1Service = blike1Service;
	}
	
	// 동행자찾기 게시판 목록
	@GetMapping("/board1list.do")
	public String boardlist(
			@RequestParam(value="page", defaultValue = "0") int page,
            @RequestParam(value="size", defaultValue = "10") int size,
            @RequestParam(value="field", required = false) String field,
            @RequestParam(value="kw", required = false) String kw,
			Model model) {
		// 인기글 리스트 조회
		List<Board1> likeList = board1Service.getBoardLikeList();
		if(likeList != null && likeList.size() != 0) {
			if(likeList.size() >= 3) {
				Board1 l1 = likeList.get(0);
				Board1 l2 = likeList.get(1);
				Board1 l3 = likeList.get(2);
				
				model.addAttribute("l1", l1);
				model.addAttribute("l2", l2);
				model.addAttribute("l3", l3);
			}else if (likeList.size() == 2) {
				Board1 l1 = likeList.get(0);
				Board1 l2 = likeList.get(1);
				
				model.addAttribute("l1", l1);
				model.addAttribute("l2", l2);
			}else if (likeList.size() == 1) {
				Board1 l1 = likeList.get(0);
				model.addAttribute("l1", l1);
			}
		}
		
		if(field != null && kw != null) {
			model.addAttribute("boardList1", board1Service.searchBoardList(page, size, field, kw));
		}else {
			model.addAttribute("boardList1", board1Service.getBoards(page, size));
		}
		return "/board1/board1list";
	}
	
	// 동행자찾기 게시글 작성 폼
	@GetMapping("/write1form.do")
	public String writeform() {
		return "/board1/write1form";
	}
	
	// 동행자찾기 게시글 작성 처리
	@PostMapping("/write1.do")
	public String writeBoard(@RequestParam("filename1") MultipartFile file,
						@RequestParam("title1") String title,
						@RequestParam("content1") String content,
						HttpSession session) {
//		log.info("게시글 작성!");
		String username = (String)session.getAttribute("sessionId");
		String filename = null;
		try {
			filename = fileService.saveFile(file, "board1");
		} catch (IOException e) {
			e.printStackTrace();
		}
		board1Service.writeBoard(username, title, content, filename);
		
		return "redirect:/board1list.do";
	}
	
	// 동행자찾기 게시판 상세보기
	@GetMapping("/board1view.do")
	public String boardview(@RequestParam("bno1") String bno, Model model) {
//		log.info("동행자찾기 게시판 상세보기");
		Board1 board = board1Service.getBoardOne(Long.parseLong(bno)).get();
		List<Reply1> replyList = reply1Service.getReplyListByBno(Long.parseLong(bno));
		
		// 조회수 증가
		board1Service.increaseBoardHit(Long.parseLong(bno));
		
		model.addAttribute("board1", board);
		model.addAttribute("replyList1", replyList);
		return "/board1/board1view";
	}
	
	// 동행자찾기 게시물 삭제
	@GetMapping("/deleteboard1.do")
	public String deleteBoard(@RequestParam("bno1") String bno) {
		board1Service.deleteBoard(Long.parseLong(bno));
		return "redirect:/board1list.do";
	}
	
	// 동행자찾기 게시물 수정 폼
	@GetMapping("/updateboard1form.do")
	public String updateBoardform(@RequestParam("bno1") String bno, Model model) {
		Board1 board = board1Service.getBoardOne(Long.parseLong(bno)).get();
		model.addAttribute("board", board);
		return "/board1/updateboard1form";
	}
	
	// 동행자찾기 게시물 수정 처리
	@PostMapping("/updateboard1.do")
	public String updateBoard(@RequestParam("filename1") MultipartFile file,
			@RequestParam("bno1") String bno,
			@RequestParam("title1") String title,
			@RequestParam("content1") String content) {
		log.info("[updateboard1(Controller)] bno : " + bno  + " title : " + title + " content : " + content + " file : " + file.getOriginalFilename());
		String filename = null;
		try {
			filename = fileService.saveFile(file, "board");
		} catch (IOException e) {
			e.printStackTrace();
		}
		board1Service.updateBoard(Long.parseLong(bno), title, content, filename);
		return "redirect:/board1list.do";
	}
	
	// 동행자찾기 게시물 댓글 작성
	@PostMapping("/insertreply1.do")
	public String insertreply(@RequestParam("bno1") String bno,
							@RequestParam("replyer1") String replyer,
							@RequestParam("rcontent1") String rcontent) {
		reply1Service.insertReply(Long.parseLong(bno), rcontent, replyer);
		return "redirect:/board1view.do?bno1=" + bno;
	}
	
	// 동행자찾기 게시물 댓글 수정 폼
	@GetMapping("/updatereply1form.do")
	public String updatereplyform(@RequestParam("bno1") String bno,
								@RequestParam("rno1") String rno,
								Model model) {
		Reply1 reply = reply1Service.getReplyOne(Long.parseLong(rno));
		model.addAttribute("reply1",reply);
		return "/board1/updatereply1form";
	}
	
	// 동행자찾기 게시물 댓글 수정 처리
	@PostMapping("/updatereply1.do")
	public String updatereply(@RequestParam("bno1") String bno,
							@RequestParam("rno1") String rno,
							@RequestParam("rcontent1") String rcontent) {
		reply1Service.updateReply(Long.parseLong(rno), rcontent);
		return "redirect:/board1view.do?bno1=" + bno;
	}
	
	// 동행자찾기 게시물 댓글 삭제 처리
	@GetMapping("/deletereply1.do")
	public String deletereply(@RequestParam("bno1") String bno,
							 @RequestParam("rno1") String rno) {
		reply1Service.deleteReply(Long.parseLong(rno), Long.parseLong(bno));
		return "redirect:/board1view.do?bno1=" + bno;
	}
	
	// 게시글 좋아요
	@GetMapping("/like1.do")
	public String like(@RequestParam("bno1") String bno,
					  @RequestParam("id1") String username) {
		if(blike1Service.checkLikeByBno(Long.parseLong(bno), username)) {
			blike1Service.deleteLike(Long.parseLong(bno), username);
		}else {
			blike1Service.like(Long.parseLong(bno), username);
		}
		return "redirect:/board1view.do?bno1=" + bno;
	}
	
	// 찜한 목록에서 좋아요 누른 게시글들 조회
	@GetMapping("/board1listBlike.do")
	public String board1listBlike(@RequestParam("id") String id,
			Model model) {
			
			
			List<Blike1> myBlikes = blike1Service.getMyLikes(id);
			List<Board1> boardList = new ArrayList<>();
			if(myBlikes != null) {
				for(Blike1 myBlike : myBlikes) {
					Board1 board = board1Service.getBoardOne(myBlike.getBno1()).get();
					boardList.add(board);
				}
			}
			
			model.addAttribute("boardList1", boardList);
			return "/board1/board1wishlist";
	}
	
}
