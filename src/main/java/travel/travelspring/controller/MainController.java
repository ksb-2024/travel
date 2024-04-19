package travel.travelspring.controller;

import java.io.IOException;
import java.time.LocalDate;
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
import travel.travelspring.domain.Blike2;
import travel.travelspring.domain.Blike3;
import travel.travelspring.domain.Board;
import travel.travelspring.domain.Board1;
import travel.travelspring.domain.Board2;
import travel.travelspring.domain.Board3;
import travel.travelspring.domain.User;
import travel.travelspring.service.Blike1Service;
import travel.travelspring.service.Blike2Service;
import travel.travelspring.service.Blike3Service;
import travel.travelspring.service.BlikeService;
import travel.travelspring.service.Board1Service;
import travel.travelspring.service.Board2Service;
import travel.travelspring.service.Board3Service;
import travel.travelspring.service.BoardService;
import travel.travelspring.service.FileService;
import travel.travelspring.service.RateService;
import travel.travelspring.service.UserService;

@Slf4j
@Controller
public class MainController {
	

	private UserService userService;
	private RateService rateService;
	private FileService fileService;
	private BlikeService blikeService;
	private BoardService boardService;
	private Blike1Service blike1Service;
	private Board1Service board1Service;
	private Blike2Service blike2Service;
	private Board2Service board2Service;
	private Blike3Service blike3Service;
	private Board3Service board3Service;

	@Autowired
	public MainController(UserService userService, 
						  FileService fileService,
						  BlikeService blikeService,
						  BoardService boardService,
						  Blike1Service blike1Service,
						  Board1Service board1Service,
						  Blike2Service blike2Service,
						  Board2Service board2Service,
						  Blike3Service blike3Service,
						  Board3Service board3Service
						  ) {
		this.userService = userService;
		this.rateService = new RateService();
		this.fileService = fileService;
		this.blikeService = blikeService;
		this.boardService = boardService;
		this.blike1Service = blike1Service;
		this.board1Service = board1Service;
		this.blike2Service = blike2Service;
		this.board2Service = board2Service;
		this.blike3Service = blike3Service;
		this.board3Service = board3Service;
	}
	
	
	// 기본적으로 로그인 페이지
	@GetMapping("/")
	public String home() {
		return "loginform";
	}
	
	// 로그인 첫 화면
	@GetMapping("/loginform.do")
	public String loginForm() {
		return "loginform";
	}
	
	// 메인페이지
	@GetMapping("/main.do")
	public String mainpage(Model model) {
		
		// 환율 정보
		List<String> rateList = rateService.getRateList();
		model.addAttribute("rateList", rateList);
		
		// 여행 후기 인기글 리스트 조회
		List<Board> likeList00 = boardService.getBoardLikeList();
		List<Board> likeList = new ArrayList<>();
		if(likeList00 != null && likeList00.size() != 0) {
			if(likeList00.size() >= 3) {
				likeList.add(likeList00.get(0));
				likeList.add(likeList00.get(1));
				likeList.add(likeList00.get(2));
				
				model.addAttribute("likeList", likeList);
			}else if (likeList00.size() == 2) {
				likeList.add(likeList00.get(0));
				likeList.add(likeList00.get(1));
				
				model.addAttribute("likeList", likeList);
			}else if (likeList00.size() == 1) {
				likeList.add(likeList00.get(0));
				
				model.addAttribute("likeList", likeList);
			}
		}
		
		// 여행 후기 최신글 리스트 조회
		List<Board> boardList00 = boardService.getBoardListDesc();
		List<Board> boardList = new ArrayList<>();
		if(boardList00 != null && boardList00.size() != 0) {
			if(boardList00.size() >= 3) {
				boardList.add(boardList00.get(0));
				boardList.add(boardList00.get(1));
				boardList.add(boardList00.get(2));
				
				model.addAttribute("boardList", boardList);
			}else if (boardList00.size() == 2) {
				boardList.add(boardList00.get(0));
				boardList.add(boardList00.get(1));
				
				model.addAttribute("boardList", boardList);
			}else if (boardList00.size() == 1) {
				boardList.add(boardList00.get(0));
				
				model.addAttribute("boardList", boardList);
			}
		}
		
		// 동행자 찾기 인기글 리스트 조회
		List<Board1> likeList01 = board1Service.getBoardLikeList();
		List<Board1> likeList1 = new ArrayList<>();
		if(likeList01 != null && likeList01.size() != 0) {
			if(likeList01.size() >= 3) {
				likeList1.add(likeList01.get(0));
				likeList1.add(likeList01.get(1));
				likeList1.add(likeList01.get(2));
				
				model.addAttribute("likeList1", likeList1);
			}else if (likeList01.size() == 2) {
				likeList1.add(likeList01.get(0));
				likeList1.add(likeList01.get(1));
				
				model.addAttribute("likeList1", likeList1);
			}else if (likeList01.size() == 1) {
				likeList1.add(likeList01.get(0));
				
				model.addAttribute("likeList1", likeList1);
			}
		}
		
		// 동행자 찾기 최신글 리스트 조회
		List<Board1> boardList01 = board1Service.getBoardListDesc();
		List<Board1> boardList1 = new ArrayList<>();
		if(boardList01 != null && boardList01.size() != 0) {
			if(boardList01.size() >= 3) {
				boardList1.add(boardList01.get(0));
				boardList1.add(boardList01.get(1));
				boardList1.add(boardList01.get(2));
				
				model.addAttribute("boardList1", boardList1);
			}else if (boardList01.size() == 2) {
				boardList1.add(boardList01.get(0));
				boardList1.add(boardList01.get(1));
				
				model.addAttribute("boardList1", boardList1);
			}else if (boardList01.size() == 1) {
				boardList1.add(boardList01.get(0));
				
				model.addAttribute("boardList1", boardList1);
			}
		}
		
		// 동행자 찾기 인기글 리스트 조회
		List<Board2> likeList02 = board2Service.getBoardLikeList();
		List<Board2> likeList2 = new ArrayList<>();
		if(likeList02 != null && likeList02.size() != 0) {
			if(likeList02.size() >= 3) {
				likeList2.add(likeList02.get(0));
				likeList2.add(likeList02.get(1));
				likeList2.add(likeList02.get(2));
				
				model.addAttribute("likeList2", likeList2);
			}else if (likeList02.size() == 2) {
				likeList2.add(likeList02.get(0));
				likeList2.add(likeList02.get(1));
				
				model.addAttribute("likeList2", likeList2);
			}else if (likeList02.size() == 1) {
				likeList2.add(likeList02.get(0));
				
				model.addAttribute("likeList2", likeList2);
			}
		}
		
		// 동행자 찾기 최신글 리스트 조회
		List<Board2> boardList02 = board2Service.getBoardListDesc();
		List<Board2> boardList2 = new ArrayList<>();
		if(boardList02 != null && boardList02.size() != 0) {
			if(boardList02.size() >= 3) {
				boardList2.add(boardList02.get(0));
				boardList2.add(boardList02.get(1));
				boardList2.add(boardList02.get(2));
				
				model.addAttribute("boardList2", boardList2);
			}else if (boardList02.size() == 2) {
				boardList2.add(boardList02.get(0));
				boardList2.add(boardList02.get(1));
				
				model.addAttribute("boardList2", boardList2);
			}else if (boardList02.size() == 1) {
				boardList2.add(boardList02.get(0));
				
				model.addAttribute("boardList2", boardList2);
			}
		}
		
		
		
		return "main";
	}
	
	// 로그인 버튼 눌렀을때 처리 및 이동
	@PostMapping("/login.do")
	public String loginProcess(@RequestParam("id") String id,
			   @RequestParam("pw") String pw, Model model,HttpSession session) {
		
		// 데이터 입력 확인 코드
//		log.info("id : " + id);
//		log.info("pw : " + pw);
		//log.info("아직 그냥 메인페이지로 보냄");
		
		boolean loginPass = userService.checkPw(id, pw);
//		log.info("loginPass : " + loginPass);
		if(loginPass) {
			session.setAttribute("sessionId", id);
			return "main";
		}else {
			return "redirect:/";
		}
	}
	
	// 로그아웃
	@GetMapping("/logout.do")
	public String logoutProcess(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// 회원가입01 화면
	@GetMapping("/joinform01.do")
	public String joinform01() {
		return "joinform01";
	}
	
	// 회원가입02 화면
	@PostMapping("/joinform02.do")
	public String joinform02() {
		return "joinform02";
	}
	
	// 회원가입 처리(WIP)
	@PostMapping("/insertusers.do")
	public String insertuser(@RequestParam("id") String id,
						   @RequestParam("pw") String pw,
						   @RequestParam("email") String email1,
						   @RequestParam("domain-txt") String email2,
						   @RequestParam("birth-year") String birthyear,
						   @RequestParam("birth-month") String birthmonth,
						   @RequestParam("birth-day") String birthday,
						   @RequestParam("tel") String tel,
						   @RequestParam("gender") String gender) {
		
		// 데이터 입력 확인 코드
		/*
		log.info("id : " + id);
		log.info("pw : " + pw);
		log.info("email : " + email1 + "@" + email2);
		log.info("birth-year : " + birthyear);
		log.info("birth-month : " + birthmonth);
		log.info("birth-day : " + birthday);
		log.info("tel : " + tel);
		log.info("gender : " + gender);
		*/
		
		String email = email1 + "@" + email2;
		Integer birth = Integer.parseInt(birthyear + birthmonth + birthday); 
		
		User user = new User();
		user.setUsername(id);
		user.setUserpw(pw);
		user.setUseremail(email);
		user.setUserbirth(birth);
		user.setUsertel(tel);
		user.setUsergender(gender);
		user.setSignupday(LocalDate.now());
		userService.join(user);
		
//		log.info("회원가입 완료!");
		
		return "redirect:/";
	}
	
	// 마이페이지
	@GetMapping("/mypage.do")
	public String viewMypage(Model model, HttpSession session) {
		String username = (String)session.getAttribute("sessionId");
		UserForm userform = userService.findUserOnMyPage(username);
		model.addAttribute("user", userform);
		return "mypage";
	}
	
	// 마이페이지 설정 페이지
	@GetMapping("/setting.do")
	public String settingpage() {
		return "setting";
	}
	
	// 회원 탈퇴 처리
	@GetMapping("/deleteUser.do")
	public String deleteUser(HttpSession session) {
		String username = (String)session.getAttribute("sessionId");
		userService.deleteUser(username);
		session.invalidate();
//		log.info("deleteUser[MainController]");
		
		return "redirect:/main.do";
	}
	
	
	// 회원 수정 처리
	@PostMapping("/updateUser.do")
	public String updateUser(@RequestParam("passwd") String pw,
							@RequestParam("tel") String tel,
							@RequestParam("email") String email,
							HttpSession session) {
		String username = (String)session.getAttribute("sessionId");
		
		userService.updateUser(username, pw, tel, email);
		
		return "redirect:/mypage.do";
	}
	
	// 회원 프로필 사진 수정
	@PostMapping("/editprofile_pic.do")
	public String updateProfilePic(@RequestParam("profile_pic") MultipartFile file, HttpSession session) {
		 String profileName = null;
		 String username = (String)session.getAttribute("sessionId");
		 if (!file.isEmpty()) {
			 log.info("filename : " + file.getOriginalFilename());
			 try {
				profileName = fileService.saveFile(file, "profile_pic"); // 서버에 파일 등록
				userService.updateProfileImg(username, profileName); // 회원 정보에 메타 데이터(파일 이름) 등록
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
		
		return "redirect:/mypage.do";
	}
	
	// 회원 프로필 소개글 수정
	@PostMapping("/editprofile.do")
	public String updateProfileIntro(@RequestParam("introduction") String introduction, HttpSession session) {
		String username = (String)session.getAttribute("sessionId");
		userService.updateProfileIntro(username, introduction);
		return "redirect:/mypage.do";
	}
	
	// 찜한 목록 페이지
	@GetMapping("/wishlist.do")
	public String wishlist(HttpSession session, Model model) {
		String username = (String)session.getAttribute("sessionId");
		
		
		// 여행 후기 게시글 찜한 목록 조회
		List<Blike> myBlikes = blikeService.getMyLikes(username);
		if(myBlikes != null && myBlikes.size() != 0) {
			if(myBlikes.size() >= 3) {
				Blike l1 = myBlikes.get(0);
				Blike l2 = myBlikes.get(1);
				Blike l3 = myBlikes.get(2);
				
				Board w1 = boardService.getBoardOne(l1.getBno()).get();
				Board w2 = boardService.getBoardOne(l2.getBno()).get();
				Board w3 = boardService.getBoardOne(l3.getBno()).get();
				
				model.addAttribute("w1", w1);
				model.addAttribute("w2", w2);
				model.addAttribute("w3", w3);
			}else if (myBlikes.size() == 2) {
				Blike l1 = myBlikes.get(0);
				Blike l2 = myBlikes.get(1);
				
				Board w1 = boardService.getBoardOne(l1.getBno()).get();
				Board w2 = boardService.getBoardOne(l2.getBno()).get();
				
				model.addAttribute("w1", w1);
				model.addAttribute("w2", w2);
			}else if (myBlikes.size() == 1) {
				Blike l1 = myBlikes.get(0);
				
				Board w1 = boardService.getBoardOne(l1.getBno()).get();
				
				model.addAttribute("w1", w1);
			}
		}
		
		// 동행자 찾기 게시글 찜한 목록 조회
		List<Blike1> myBlikes1 = blike1Service.getMyLikes(username);
		if(myBlikes1 != null && myBlikes1.size() != 0) {
			if(myBlikes1.size() >= 3) {
				Blike1 l11 = myBlikes1.get(0);
				Blike1 l21 = myBlikes1.get(1);
				Blike1 l31 = myBlikes1.get(2);
				
				Board1 w11 = board1Service.getBoardOne(l11.getBno1()).get();
				Board1 w21 = board1Service.getBoardOne(l21.getBno1()).get();
				Board1 w31 = board1Service.getBoardOne(l31.getBno1()).get();
				
				model.addAttribute("w11", w11);
				model.addAttribute("w21", w21);
				model.addAttribute("w31", w31);
			}else if (myBlikes1.size() == 2) {
				Blike1 l11 = myBlikes1.get(0);
				Blike1 l21 = myBlikes1.get(1);
				
				Board1 w11 = board1Service.getBoardOne(l11.getBno1()).get();
				Board1 w21 = board1Service.getBoardOne(l21.getBno1()).get();
				
				model.addAttribute("w11", w11);
				model.addAttribute("w21", w21);
			}else if (myBlikes1.size() == 1) {
				Blike1 l11 = myBlikes1.get(0);
				
				Board1 w11 = board1Service.getBoardOne(l11.getBno1()).get();
				
				model.addAttribute("w11", w11);
			}
		}
		
		// 나의 계획 게시글 찜한 목록 조회
		List<Blike2> myBlikes2 = blike2Service.getMyLikes(username);
		if(myBlikes2 != null && myBlikes2.size() != 0) {
			if(myBlikes2.size() >= 3) {
				Blike2 l12 = myBlikes2.get(0);
				Blike2 l22 = myBlikes2.get(1);
				Blike2 l32 = myBlikes2.get(2);
				
				Board2 w12 = board2Service.getBoardOne(l12.getBno2()).get();
				Board2 w22 = board2Service.getBoardOne(l22.getBno2()).get();
				Board2 w32 = board2Service.getBoardOne(l32.getBno2()).get();
				
				model.addAttribute("w12", w12);
				model.addAttribute("w22", w22);
				model.addAttribute("w32", w32);
			}else if (myBlikes2.size() == 2) {
				Blike2 l12 = myBlikes2.get(0);
				Blike2 l22 = myBlikes2.get(1);
				
				Board2 w12 = board2Service.getBoardOne(l12.getBno2()).get();
				Board2 w22 = board2Service.getBoardOne(l22.getBno2()).get();
				
				model.addAttribute("w12", w12);
				model.addAttribute("w22", w22);
			}else if (myBlikes2.size() == 1) {
				Blike2 l12 = myBlikes2.get(0);
				
				Board2 w12 = board2Service.getBoardOne(l12.getBno2()).get();
				
				model.addAttribute("w12", w12);
			}
		}
		
		// Q&A 게시글 찜한 목록 조회
		List<Blike3> myBlikes3 = blike3Service.getMyLikes(username);
		if(myBlikes3 != null && myBlikes3.size() != 0) {
			if(myBlikes3.size() >= 3) {
				Blike3 l13 = myBlikes3.get(0);
				Blike3 l23 = myBlikes3.get(1);
				Blike3 l33 = myBlikes3.get(2);
				
				Board3 w13 = board3Service.getBoardOne(l13.getBno3()).get();
				Board3 w23 = board3Service.getBoardOne(l23.getBno3()).get();
				Board3 w33 = board3Service.getBoardOne(l33.getBno3()).get();
				
				model.addAttribute("w13", w13);
				model.addAttribute("w23", w23);
				model.addAttribute("w33", w33);
			}else if (myBlikes3.size() == 2) {
				Blike3 l13 = myBlikes3.get(0);
				Blike3 l23 = myBlikes3.get(1);
				
				Board3 w13 = board3Service.getBoardOne(l13.getBno3()).get();
				Board3 w23 = board3Service.getBoardOne(l23.getBno3()).get();
				
				model.addAttribute("w13", w13);
				model.addAttribute("w23", w23);
			}else if (myBlikes3.size() == 1) {
				Blike3 l13 = myBlikes3.get(0);
				
				Board3 w13 = board3Service.getBoardOne(l13.getBno3()).get();
				
				model.addAttribute("w13", w13);
			}
		}
		
		return "wishlist";
	}
	
}
