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
import travel.travelspring.domain.Board;
import travel.travelspring.domain.Reply;
import travel.travelspring.service.BlikeService;
import travel.travelspring.service.BoardService;
import travel.travelspring.service.FileService;
import travel.travelspring.service.ReplyService;

@Slf4j
@Controller
public class BoardController {
	
	private BoardService boardService;
	private FileService fileService;
	private ReplyService replyService;
	private BlikeService blikeService;

	@Autowired
	public BoardController(BoardService boardService, FileService fileService, ReplyService replyService, BlikeService blikeService) {
		this.boardService = boardService;
		this.fileService = fileService;
		this.replyService = replyService;
		this.blikeService = blikeService;
	}
	
	// 여행후기 게시판 목록
	@GetMapping("/boardlist.do")
	public String boardlist(
			@RequestParam(value="page", defaultValue = "0") int page,
            @RequestParam(value="size", defaultValue = "10") int size,
            @RequestParam(value="field", required = false) String field,
            @RequestParam(value="kw", required = false) String kw,
			Model model) {
		// 인기글 리스트 조회
		List<Board> likeList = boardService.getBoardLikeList();
		if(likeList != null && likeList.size() != 0) {
			if(likeList.size() >= 3) {
				Board l1 = likeList.get(0);
				Board l2 = likeList.get(1);
				Board l3 = likeList.get(2);
				
				model.addAttribute("l1", l1);
				model.addAttribute("l2", l2);
				model.addAttribute("l3", l3);
			}else if (likeList.size() == 2) {
				Board l1 = likeList.get(0);
				Board l2 = likeList.get(1);
				
				model.addAttribute("l1", l1);
				model.addAttribute("l2", l2);
			}else if (likeList.size() == 1) {
				Board l1 = likeList.get(0);
				model.addAttribute("l1", l1);
			}
		}
		
		if(field != null && kw != null) {
			model.addAttribute("boardList", boardService.searchBoardList(page, size, field, kw));
		}else {
			model.addAttribute("boardList", boardService.getBoards(page, size));
		}
		return "/board/boardlist";
	}
	
	// 여행후기 게시글 작성 폼
	@GetMapping("/writeform.do")
	public String writeform() {
		return "/board/writeform";
	}
	
	// 여행후기 게시글 작성 처리
	@PostMapping("/write.do")
	public String writeBoard(@RequestParam("filename") MultipartFile file,
						@RequestParam("title") String title,
						@RequestParam("content") String content,
						HttpSession session) {
//		log.info("게시글 작성!");
		String username = (String)session.getAttribute("sessionId");
		String filename = null;
		try {
			filename = fileService.saveFile(file, "board");
		} catch (IOException e) {
			e.printStackTrace();
		}
		boardService.writeBoard(username, title, content, filename);
		
		return "redirect:/boardlist.do";
	}
	
	// 여행후기 게시판 상세보기
	@GetMapping("/boardview.do")
	public String boardview(@RequestParam("bno") String bno, Model model) {
//		log.info("여행후기 게시판 상세보기");
		Board board = boardService.getBoardOne(Long.parseLong(bno)).get();
		List<Reply> replyList = replyService.getReplyListByBno(Long.parseLong(bno));
		
		// 조회수 증가
		boardService.increaseBoardHit(Long.parseLong(bno));
		
		model.addAttribute("board", board);
		model.addAttribute("replyList", replyList);
		return "/board/boardview";
	}
	
	// 여행후기 게시물 삭제
	@GetMapping("/deleteboard.do")
	public String deleteBoard(@RequestParam("bno") String bno) {
		boardService.deleteBoard(Long.parseLong(bno));
		return "redirect:/boardlist.do";
	}
	
	// 여행후기 게시물 수정 폼
	@GetMapping("/updateboardform.do")
	public String updateBoardform(@RequestParam("bno") String bno, Model model) {
		Board board = boardService.getBoardOne(Long.parseLong(bno)).get();
		model.addAttribute("board", board);
		return "/board/updateboardform";
	}
	
	// 여행후기 게시물 수정 처리
	@PostMapping("/updateboard.do")
	public String updateBoard(@RequestParam("filename") MultipartFile file,
			@RequestParam("bno") String bno,
			@RequestParam("title") String title,
			@RequestParam("content") String content) {
		log.info("[updateboard(Controller)] bno : " + bno  + " title : " + title + " content : " + content + " file : " + file.getOriginalFilename());
		String filename = null;
		try {
			filename = fileService.saveFile(file, "board");
		} catch (IOException e) {
			e.printStackTrace();
		}
		boardService.updateBoard(Long.parseLong(bno), title, content, filename);
		return "redirect:/boardlist.do";
	}
	
	// 여행후기 게시물 댓글 작성
	@PostMapping("/insertreply.do")
	public String insertreply(@RequestParam("bno") String bno,
							@RequestParam("replyer") String replyer,
							@RequestParam("rcontent") String rcontent) {
		replyService.insertReply(Long.parseLong(bno), rcontent, replyer);
		return "redirect:/boardview.do?bno=" + bno;
	}
	
	// 여행후기 게시물 댓글 수정 폼
	@GetMapping("/updatereplyform.do")
	public String updatereplyform(@RequestParam("bno") String bno,
								@RequestParam("rno") String rno,
								Model model) {
		Reply reply = replyService.getReplyOne(Long.parseLong(rno));
		model.addAttribute("reply",reply);
		return "/board/updatereplyform";
	}
	
	// 여행후기 게시물 댓글 수정 처리
	@PostMapping("/updatereply.do")
	public String updatereply(@RequestParam("bno") String bno,
							@RequestParam("rno") String rno,
							@RequestParam("rcontent") String rcontent) {
		replyService.updateReply(Long.parseLong(rno), rcontent);
		return "redirect:/boardview.do?bno=" + bno;
	}
	
	// 여행후기 게시물 댓글 삭제 처리
	@GetMapping("/deletereply.do")
	public String deletereply(@RequestParam("bno") String bno,
							 @RequestParam("rno") String rno) {
		replyService.deleteReply(Long.parseLong(rno), Long.parseLong(bno));
		return "redirect:/boardview.do?bno=" + bno;
	}
	
	// 게시글 좋아요
	@GetMapping("/like.do")
	public String like(@RequestParam("bno") String bno,
					  @RequestParam("id") String username) {
		if(blikeService.checkLikeByBno(Long.parseLong(bno), username)) {
			blikeService.deleteLike(Long.parseLong(bno), username);
		}else {
			blikeService.like(Long.parseLong(bno), username);
		}
		return "redirect:/boardview.do?bno=" + bno;
	}
	
	// 찜한 목록에서 좋아요 누른 게시글들 조회
	@GetMapping("/boardlistBlike.do")
	public String boardlistBlike(@RequestParam("id") String id,
			Model model) {
			
			
			List<Blike> myBlikes = blikeService.getMyLikes(id);
			List<Board> boardList = new ArrayList<>();
			if(myBlikes != null) {
				for(Blike myBlike : myBlikes) {
					Board board = boardService.getBoardOne(myBlike.getBno()).get();
					boardList.add(board);
				}
			}
			
			model.addAttribute("boardList", boardList);
			return "/board/boardwishlist";
	}
}
