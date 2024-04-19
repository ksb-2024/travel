package travel.travelspring.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import travel.travelspring.domain.Board;
import travel.travelspring.domain.Board1;
import travel.travelspring.repository.Board1Repository;
import travel.travelspring.repository.BoardSpecification;

@Service
public class Board1Service {
	
	private final Board1Repository board1Repository;
	
	public Board1Service(Board1Repository board1Repository) {
		this.board1Repository = board1Repository;
	}

	// 동행자찾기 게시글 목록 조회
	public Page<Board1> getBoards(int page, int size){
		
		Sort sort = Sort.by(Sort.Direction.DESC, "bno1");
		
		return board1Repository.findAll(PageRequest.of(page, size, sort));
	}
	
	
	// 동행자찾기 게시글 작성 처리
	public void writeBoard(String username, String title, String content, String filename) {
		Board1 board = new Board1();
		board.setTitle1(title);
		board.setContent1(content);
		board.setCreateDate1(LocalDate.now());
		board.setFilename1(filename);
		board.setHit1(0L);
		board.setUsername1(username);
		board.setReply_count1(0L);
		board.setLikeCount1(0L);
		
		board1Repository.save(board);
	}
	
	// 동행자찾기 게시글 상세 조회
	public Optional<Board1> getBoardOne(Long bno) {
		return board1Repository.findById(bno);
	}
	
	// 동행자찾기 게시글 조회수 증가
	public void increaseBoardHit(Long bno) {
		Board1 board = getBoardOne(bno).get();
		board.setHit1(board.getHit1() + 1);
		board1Repository.save(board);
	}
	
	// 동행자찾기 게시글 삭제
	public void deleteBoard(Long bno) {
		board1Repository.deleteById(bno);
	}
	
	// 동행자찾기 게시글 수정
	public void updateBoard(Long bno, String title, String content, String filename) {
		Board1 board = getBoardOne(bno).get();
		board.setTitle1(title);
		board.setContent1(content);
		board.setFilename1(filename);
		board.setModifyDate1(LocalDate.now());
		
		board1Repository.save(board);
	}
	
	// 동행자찾기 게시글 검색
	public Page<Board1> searchBoardList(int page, int size, String field,String kw){
		Specification<Board1> spec = Specification.where(BoardSpecification.likeField1(field, kw));
		Sort sort = Sort.by(Sort.Direction.DESC, "bno1");
		Pageable pageable = PageRequest.of(page, size, sort);
		return board1Repository.findAll(spec, pageable);
	}
	
	// 동행자찾기 게시글 인기글 조회
	public List<Board1> getBoardLikeList(){
		return board1Repository.findAllByOrderByLikeCount1Desc();
	}
}
