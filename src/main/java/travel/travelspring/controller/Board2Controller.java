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
import travel.travelspring.domain.Blike2;
import travel.travelspring.domain.Board2;
import travel.travelspring.domain.Reply2;
import travel.travelspring.service.Blike2Service;
import travel.travelspring.service.Board2Service;
import travel.travelspring.service.FileService;
import travel.travelspring.service.Reply2Service;

@Slf4j
@Controller
public class Board2Controller {
	
	private Board2Service board2Service;
	private FileService fileService;
	private Reply2Service reply2Service;
	private Blike2Service blike2Service;

	@Autowired
	public Board2Controller(Board2Service board2Service, FileService fileService, Reply2Service reply2Service, Blike2Service blike2Service) {
		this.board2Service = board2Service;
		this.fileService = fileService;
		this.reply2Service = reply2Service;
		this.blike2Service = blike2Service;
	}
	
	// 나의계획 게시판 목록
	@GetMapping("/board2list.do")
	public String boardlist(
			@RequestParam(value="page", defaultValue = "0") int page,
            @RequestParam(value="size", defaultValue = "10") int size,
            @RequestParam(value="field", required = false) String field,
            @RequestParam(value="kw", required = false) String kw,
			Model model) {
		// 인기글 리스트 조회
		List<Board2> likeList = board2Service.getBoardLikeList();
		if(likeList != null && likeList.size() != 0) {
			if(likeList.size() >= 3) {
				Board2 l1 = likeList.get(0);
				Board2 l2 = likeList.get(1);
				Board2 l3 = likeList.get(2);
				
				model.addAttribute("l1", l1);
				model.addAttribute("l2", l2);
				model.addAttribute("l3", l3);
			}else if (likeList.size() == 2) {
				Board2 l1 = likeList.get(0);
				Board2 l2 = likeList.get(1);
				
				model.addAttribute("l1", l1);
				model.addAttribute("l2", l2);
			}else if (likeList.size() == 1) {
				Board2 l1 = likeList.get(0);
				model.addAttribute("l1", l1);
			}
		}
		
		if(field != null && kw != null) {
			model.addAttribute("boardList2", board2Service.searchBoardList(page, size, field, kw));
		}else {
			model.addAttribute("boardList2", board2Service.getBoards(page, size));
		}
		return "/board2/board2list";
	}
	
	// 나의계획 게시글 작성 폼
	@GetMapping("/write2form.do")
	public String writeform() {
		return "/board2/write2form";
	}
	
	// 나의계획 게시글 작성 처리
	@PostMapping("/write2.do")
	public String writeBoard(@RequestParam("filename2") MultipartFile file,
						@RequestParam("title2") String title,
						@RequestParam("content2") String content,
						HttpSession session) {
//		log.info("게시글 작성!");
		String username = (String)session.getAttribute("sessionId");
		String filename = null;
		try {
			filename = fileService.saveFile(file, "board2");
		} catch (IOException e) {
			e.printStackTrace();
		}
		board2Service.writeBoard(username, title, content, filename);
		
		return "redirect:/board2list.do";
	}
	
	// 나의계획 게시판 상세보기
	@GetMapping("/board2view.do")
	public String boardview(@RequestParam("bno2") String bno, Model model) {
//		log.info("나의계획 게시판 상세보기");
		Board2 board = board2Service.getBoardOne(Long.parseLong(bno)).get();
		List<Reply2> replyList = reply2Service.getReplyListByBno(Long.parseLong(bno));
		
		// 조회수 증가
		board2Service.increaseBoardHit(Long.parseLong(bno));
		
		model.addAttribute("board2", board);
		model.addAttribute("replyList2", replyList);
		return "/board2/board2view";
	}
	
	// 나의계획 게시물 삭제
	@GetMapping("/deleteboard2.do")
	public String deleteBoard(@RequestParam("bno2") String bno) {
		board2Service.deleteBoard(Long.parseLong(bno));
		return "redirect:/board2list.do";
	}
	
	// 나의계획 게시물 수정 폼
	@GetMapping("/updateboard2form.do")
	public String updateBoardform(@RequestParam("bno2") String bno, Model model) {
		Board2 board = board2Service.getBoardOne(Long.parseLong(bno)).get();
		model.addAttribute("board2", board);
		return "/board2/updateboard2form";
	}
	
	// 나의계획 게시물 수정 처리
	@PostMapping("/updateboard2.do")
	public String updateBoard(@RequestParam("filename2") MultipartFile file,
			@RequestParam("bno2") String bno,
			@RequestParam("title2") String title,
			@RequestParam("content2") String content) {
		log.info("[updateboard2(Controller)] bno : " + bno  + " title : " + title + " content : " + content + " file : " + file.getOriginalFilename());
		String filename = null;
		try {
			filename = fileService.saveFile(file, "board");
		} catch (IOException e) {
			e.printStackTrace();
		}
		board2Service.updateBoard(Long.parseLong(bno), title, content, filename);
		return "redirect:/board2list.do";
	}
	
	// 나의계획 게시물 댓글 작성
	@PostMapping("/insertreply2.do")
	public String insertreply(@RequestParam("bno2") String bno,
							@RequestParam("replyer2") String replyer,
							@RequestParam("rcontent2") String rcontent) {
		reply2Service.insertReply(Long.parseLong(bno), rcontent, replyer);
		return "redirect:/board2view.do?bno2=" + bno;
	}
	
	// 나의계획 게시물 댓글 수정 폼
	@GetMapping("/updatereply2form.do")
	public String updatereplyform(@RequestParam("bno2") String bno,
								@RequestParam("rno2") String rno,
								Model model) {
		Reply2 reply = reply2Service.getReplyOne(Long.parseLong(rno));
		model.addAttribute("reply2",reply);
		return "/board2/updatereply2form";
	}
	
	// 나의계획 게시물 댓글 수정 처리
	@PostMapping("/updatereply2.do")
	public String updatereply(@RequestParam("bno2") String bno,
							@RequestParam("rno2") String rno,
							@RequestParam("rcontent2") String rcontent) {
		reply2Service.updateReply(Long.parseLong(rno), rcontent);
		return "redirect:/board2view.do?bno2=" + bno;
	}
	
	// 나의계획 게시물 댓글 삭제 처리
	@GetMapping("/deletereply2.do")
	public String deletereply(@RequestParam("bno2") String bno,
							 @RequestParam("rno2") String rno) {
		reply2Service.deleteReply(Long.parseLong(rno), Long.parseLong(bno));
		return "redirect:/board2view.do?bno2=" + bno;
	}
	
	// 게시글 좋아요
	@GetMapping("/like2.do")
	public String like(@RequestParam("bno2") String bno,
					  @RequestParam("id2") String username) {
		if(blike2Service.checkLikeByBno(Long.parseLong(bno), username)) {
			blike2Service.deleteLike(Long.parseLong(bno), username);
		}else {
			blike2Service.like(Long.parseLong(bno), username);
		}
		return "redirect:/board2view.do?bno2=" + bno;
	}
	
	// 찜한 목록에서 좋아요 누른 게시글들 조회
	@GetMapping("/board2listBlike.do")
	public String board2listBlike(@RequestParam("id") String id,
			Model model) {
			
			
			List<Blike2> myBlikes = blike2Service.getMyLikes(id);
			List<Board2> boardList = new ArrayList<>();
			if(myBlikes != null) {
				for(Blike2 myBlike : myBlikes) {
					Board2 board = board2Service.getBoardOne(myBlike.getBno2()).get();
					boardList.add(board);
				}
			}
			
			model.addAttribute("boardList2", boardList);
			return "/board2/board2wishlist";
	}
	

}
