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
import travel.travelspring.domain.Board2;
import travel.travelspring.repository.Board2Repository;
import travel.travelspring.repository.BoardSpecification;

@Service
public class Board2Service {
	
	private final Board2Repository board2Repository;
	
	public Board2Service(Board2Repository board2Repository) {
		this.board2Repository = board2Repository;
	}
	
	// 최신 게시글 목록 조회
	public List<Board2> getBoardListDesc(){
		return board2Repository.findAllByOrderByBno2Desc();
	}

	// 나의계획 게시글 목록 조회
	public Page<Board2> getBoards(int page, int size){
		
		Sort sort = Sort.by(Sort.Direction.DESC, "bno2");
		
		return board2Repository.findAll(PageRequest.of(page, size, sort));
	}
	
	
	// 나의계획 게시글 작성 처리
	public void writeBoard(String username, String title, String content, String filename) {
		Board2 board = new Board2();
		board.setTitle2(title);
		board.setContent2(content);
		board.setCreateDate2(LocalDate.now());
		board.setFilename2(filename);
		board.setHit2(0L);
		board.setUsername2(username);
		board.setReply_count2(0L);
		board.setLikeCount2(0L);
		
		board2Repository.save(board);
	}
	
	// 나의계획 게시글 상세 조회
	public Optional<Board2> getBoardOne(Long bno) {
		return board2Repository.findById(bno);
	}
	
	// 나의계획 게시글 조회수 증가
	public void increaseBoardHit(Long bno) {
		Board2 board = getBoardOne(bno).get();
		board.setHit2(board.getHit2() + 1);
		board2Repository.save(board);
	}
	
	// 나의계획 게시글 삭제
	public void deleteBoard(Long bno) {
		board2Repository.deleteById(bno);
	}
	
	// 나의계획 게시글 수정
	public void updateBoard(Long bno, String title, String content, String filename) {
		Board2 board = getBoardOne(bno).get();
		board.setTitle2(title);
		board.setContent2(content);
		board.setFilename2(filename);
		board.setModifyDate2(LocalDate.now());
		
		board2Repository.save(board);
	}
	
	// 나의계획 게시글 검색
	public Page<Board2> searchBoardList(int page, int size, String field,String kw){
		Specification<Board2> spec = Specification.where(BoardSpecification.likeField2(field, kw));
		Sort sort = Sort.by(Sort.Direction.DESC, "bno2");
		Pageable pageable = PageRequest.of(page, size, sort);
		return board2Repository.findAll(spec, pageable);
	}
	
	// 나의계획 게시글 인기글 조회
	public List<Board2> getBoardLikeList(){
		return board2Repository.findAllByOrderByLikeCount2Desc();
	}
}
